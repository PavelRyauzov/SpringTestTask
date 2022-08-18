package ru.ryauzov.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.ClientDAO;
import ru.ryauzov.testtask.dao.ClientDAOImpl;
import ru.ryauzov.testtask.models.Client;

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
    public List<Client> allClients() {
        return clientDAO.allClients();
    }

    @Override
    @Transactional
    public void create(Client client) {
        clientDAO.create(client);
    }

    @Override
    @Transactional
    public void update(Client client) {
        clientDAO.update(client);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        clientDAO.delete(client);
    }

    @Override
    @Transactional
    public Client getById(long id) {
        return clientDAO.getById(id);
    }
}
