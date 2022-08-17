package ru.ryauzov.testtask.services;

import ru.ryauzov.testtask.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> allClients();
    void create(Client client);
    void update(Client client);
    void delete(Client client);
    Client getById(int id);
}
