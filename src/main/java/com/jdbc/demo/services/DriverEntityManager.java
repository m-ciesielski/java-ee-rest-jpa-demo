package com.jdbc.demo.services;

import com.jdbc.demo.DriverDAO;
import com.jdbc.demo.domain.Driver;
import com.jdbc.demo.domain.FreightTransport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 22-Oct-15.
 */
public class DriverEntityManager extends EntityManager implements DriverDAO {

    private PreparedStatement updateStatement;
    private PreparedStatement createStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement clearStatement;
    private PreparedStatement getStatement;
    private PreparedStatement getAllStatement;
    private PreparedStatement getTransportsStatement;

    private AddressEntityManager addressEntityManager;

    public DriverEntityManager() {

        try {
            addressEntityManager = new AddressEntityManager();
            Connection connection = DriverManager.getConnection(connectionString);
            ResultSet rs = connection.getMetaData().getTables(null, null, null,
                    null);
            boolean tableExists = false;

            while (rs.next()) {
                if ("Driver".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

            if (!tableExists)
                throw new SQLException("Table Driver not found in database");

            createStatement = connection.prepareStatement("INSERT INTO Driver(id_Address, first_name, last_name," +
                    " pesel, salary, salary_bonus, available, deleted) VALUES (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            deleteStatement = connection.prepareStatement("Delete FROM Driver WHERE id_Driver = ?");
            clearStatement = connection.prepareStatement("Delete FROM Driver");
            getAllStatement = connection.prepareStatement("SELECT * FROM Driver");
            getStatement = connection.prepareStatement("SELECT * FROM Driver WHERE id_Driver = ?");
            getTransportsStatement = connection.prepareStatement("SELECT * FROM FreightTransportDrivers WHERE id_Driver = ?");
            updateStatement = connection.prepareStatement("UPDATE Driver SET id_Address = ?, first_name = ?," +
                    " last_name = ?, pesel = ?, salary = ?, salary_bonus = ?, available = ?, deleted = ? WHERE id_Driver = ?");
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public ArrayList<Driver> getAll() {
        ArrayList<Driver> drivers = new ArrayList<Driver>();

        try {
            ResultSet rs = getAllStatement.executeQuery();

            while (rs.next()) {
                Driver driver = new Driver();
                driver.setId(rs.getInt("id_Driver"));
                driver.setAddress(addressEntityManager.get(rs.getInt("id_Address")));
                driver.setFirstName(rs.getString("first_name"));
                driver.setLastName(rs.getString("last_name"));
                driver.setPESEL(rs.getString("pesel"));
                driver.setSalary(rs.getBigDecimal("salary"));
                driver.setSalaryBonus(rs.getBigDecimal("salary_bonus"));
                driver.setAvailable(rs.getBoolean("available"));
                driver.setDeleted(rs.getBoolean("deleted"));

                drivers.add(driver);
            }
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            drivers = null;
        }

        return drivers;
    }

    public Driver add(Driver driver) {
        try {

            createStatement.setInt(1, driver.getAddress().getId());
            createStatement.setString(2, driver.getFirstName());
            createStatement.setString(3, driver.getLastName());
            createStatement.setString(4, driver.getPESEL());
            createStatement.setBigDecimal(5, driver.getSalary());
            createStatement.setBigDecimal(6, driver.getSalaryBonus());
            createStatement.setBoolean(7, driver.isAvailable());
            createStatement.setBoolean(8, driver.isDeleted());

            createStatement.executeUpdate();

            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            generatedKeys.next();

            driver.setId(generatedKeys.getInt(1));

        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }

        return driver;
    }

    public Driver get(int id) {

        Driver driver = new Driver();

        try {
            getStatement.setInt(1, id);
            ResultSet rs = getStatement.executeQuery();
            rs.next();
            driver.setId(rs.getInt("id_Driver"));
            driver.setAddress(addressEntityManager.get(rs.getInt("id_Address")));
            driver.setFirstName(rs.getString("first_name"));
            driver.setLastName(rs.getString("last_name"));
            driver.setPESEL(rs.getString("pesel"));
            driver.setSalary(rs.getBigDecimal("salary"));
            driver.setSalaryBonus(rs.getBigDecimal("salary_bonus"));
            driver.setAvailable(rs.getBoolean("available"));
            driver.setDeleted(rs.getBoolean("deleted"));
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
            driver = null;
        }

        return driver;
    }

    public void delete(int id) {

        try {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public void update(Driver driver) {
        try {
            updateStatement.setInt(1, driver.getAddress().getId());
            updateStatement.setString(2, driver.getFirstName());
            updateStatement.setString(3, driver.getLastName());
            updateStatement.setString(4, driver.getPESEL());
            updateStatement.setBigDecimal(5, driver.getSalary());
            updateStatement.setBigDecimal(6, driver.getSalaryBonus());
            updateStatement.setBoolean(7, driver.isAvailable());
            updateStatement.setBoolean(8, driver.isDeleted());

            updateStatement.setInt(9, driver.getId());

            updateStatement.executeUpdate();
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
    }

    public List<FreightTransport> getTransports(int id) {

        ArrayList<FreightTransport> transports = new ArrayList<FreightTransport>();

        try{
            getTransportsStatement.setInt(1, id);

            ResultSet rs = getTransportsStatement.executeQuery();
            rs.next();


        }
        catch (SQLException e){
            e.printStackTrace();
            transports = null;
        }

        return transports;
    }
}
