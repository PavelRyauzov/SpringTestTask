package ru.ryauzov.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.ClientDAO;
import ru.ryauzov.testtask.entities.ClientEntity;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDAO clientDAO;

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional
    public List<ClientEntity> allClients() {
        return clientDAO.allClients();
    }

    @Override
    @Transactional
    public void create(ClientEntity clientEntity) {

        clientDAO.create(clientEntity);
    }

    @Override
    @Transactional
    public void update(ClientEntity clientEntity) {
        clientDAO.update(clientEntity);
    }

    @Override
    @Transactional
    public void delete(ClientEntity clientEntity) {
        clientDAO.delete(clientEntity);
    }

    @Override
    @Transactional
    public ClientEntity getById(long id) {
        return clientDAO.getById(id);
    }
}
