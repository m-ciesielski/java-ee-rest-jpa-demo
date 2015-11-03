package com.jdbc.demo.services;

import com.jdbc.demo.ClientDAO;
import com.jdbc.demo.domain.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 02-Nov-15.
 */
public class ClientEntityManager extends EntityManager implements ClientDAO {

    public AddressEntityManager addressEntityManager;

    private PreparedStatement updateStatement;
    private PreparedStatement createStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement clearStatement;
    private PreparedStatement getStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getByNameStatement;
    
    public ClientEntityManager(){

        try {
            addressEntityManager = new AddressEntityManager();
            Connection connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;

            while (rs.next()) {
                if ("Client".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                throw new SQLException("Table Client not found in database");

            createStatement = connection.prepareStatement("INSERT INTO Client(id_Address, name, NIP," +
                    " account_number) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            deleteStatement = connection.prepareStatement("Delete FROM Client WHERE id_Client = ?");
            clearStatement = connection.prepareStatement("Delete FROM Client");
            getAllStatement = connection.prepareStatement("SELECT * FROM Client");
            getStatement = connection.prepareStatement("SELECT * FROM Client WHERE id_Client = ?");
            getByNameStatement = connection.prepareStatement("SELECT * FROM Client WHERE name = ?");
            updateStatement = connection.prepareStatement("UPDATE Client SET id_Address = ?, name = ?," +
                    " NIP = ?, account_number = ? WHERE id_Client = ?");
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public List<Client> getAll() {
        ArrayList<Client> clients = new ArrayList<Client>();

        try {
            ResultSet rs = getAllStatement.executeQuery();

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id_Client"));
                client.setAddress(addressEntityManager.get(rs.getInt("id_Address")));
                client.setName(rs.getString("name"));
                client.setNIP(rs.getString("NIP"));
                client.setBankAccountNumber(rs.getString("account_number"));

                clients.add(client);
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            clients = null;
        }

        return clients;
    }

    public Client add(Client client) {
        try {

            createStatement.setInt(1, client.getAddress().getId());
            createStatement.setString(2, client.getName());
            createStatement.setString(3, client.getNIP());
            createStatement.setString(4, client.getBankAccountNumber());

            createStatement.executeUpdate();

            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            generatedKeys.next();

            client.setId(generatedKeys.getInt(1));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }

        return client;
    }

    public Client get(int id) {

        Client client = new Client();

        try {

            getStatement.setInt(1, id);
            ResultSet rs = getStatement.executeQuery();

            while (rs.next()) {

                client.setId(rs.getInt("id_Client"));
                client.setAddress(addressEntityManager.get(rs.getInt("id_Address")));
                client.setName(rs.getString("name"));
                client.setNIP(rs.getString("NIP"));
                client.setBankAccountNumber(rs.getString("account_number"));

            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            client = null;
        }

        return client;
    }

    public Client get(String name) {
        Client client = new Client();

        try {

            getByNameStatement.setString(1, name);
            ResultSet rs = getByNameStatement.executeQuery();

            while (rs.next()) {

                client.setId(rs.getInt("id_Client"));
                client.setAddress(addressEntityManager.get(rs.getInt("id_Address")));
                client.setName(rs.getString("name"));
                client.setNIP(rs.getString("NIP"));
                client.setBankAccountNumber(rs.getString("account_number"));

            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            client = null;
        }

        return client;
    }

    public void update(Client client) {
        try {

            updateStatement.setInt(1, client.getAddress().getId());
            updateStatement.setString(2, client.getName());
            updateStatement.setString(3, client.getNIP());
            updateStatement.setString(4, client.getBankAccountNumber());

            updateStatement.setInt(5, client.getId());

            updateStatement.executeUpdate();

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

    }

    public void delete(int id) {
        try {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }
}
