package ru.ryauzov.testtask.dao;

import ru.ryauzov.testtask.models.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> allClients();
    void create(Client client);
    void update(Client client);
    void delete(Client client);
    Client getById(long id);
}
