package ru.ryauzov.testtask.dao;

import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.models.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ClientDAOImpl implements ClientDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Client> clients = new HashMap<>();

    static {
        Client testClient = new Client();
        testClient.setId(AUTO_ID.getAndIncrement());
        testClient.setFullName("Иванов Иван Иванович");
    }

    @Override
    public List<Client> allClients() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public void create(Client client) {
        client.setId(AUTO_ID.getAndIncrement());
        clients.put(client.getId(), client);
    }

    @Override
    public void update(Client client) {
        clients.put(client.getId(), client);
    }

    @Override
    public void delete(Client client) {
        clients.remove(client.getId(), client);
    }

    @Override
    public Client getById(int id) {
        return clients.get(id);
    }
}
