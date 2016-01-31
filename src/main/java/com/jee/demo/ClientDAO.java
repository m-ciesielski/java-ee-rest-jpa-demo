package com.jee.demo;

import com.jee.demo.domain.Client;

import java.util.List;

/**
 * Created by Mateusz on 02-Nov-15.
 */
public interface ClientDAO {
    List<Client> getAll();
    Client add(Client client);
    Client get(long id);
    Client update(Client client);
    void delete(long id);
    void delete(Client client);
}
