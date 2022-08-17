package ru.ryauzov.testtask.services;

import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.ClientDAO;
import ru.ryauzov.testtask.dao.ClientDAOImpl;
import ru.ryauzov.testtask.models.Client;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDAO clientDAO = new ClientDAOImpl();

    @Override
    public List<Client> allClients() {
        return clientDAO.allClients();
    }

    @Override
    public void create(Client client) {
        clientDAO.create(client);
    }

    @Override
    public void update(Client client) {
        clientDAO.update(client);
    }

    @Override
    public void delete(Client client) {
        clientDAO.delete(client);
    }

    @Override
    public Client getById(int id) {
        return clientDAO.getById(id);
    }
}
