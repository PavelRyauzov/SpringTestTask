package ru.ryauzov.testtask.dao;

import ru.ryauzov.testtask.entities.ClientEntity;

import java.util.List;

public interface ClientDAO {
    List<ClientEntity> allClients();
    void create(ClientEntity clientEntity);
    void update(ClientEntity clientEntity);
    void delete(ClientEntity clientEntity);
    ClientEntity getById(long id);
    List<ClientEntity> getByPassport(String passportSerial, String passportNumber);
}
