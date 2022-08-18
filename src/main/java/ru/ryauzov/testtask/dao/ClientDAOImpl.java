package ru.ryauzov.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.models.Client;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> allClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clients = session.createQuery("from Client").list();
        return session.createQuery("from Client").list();
    }

    @Override
    public void create(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
    }

    @Override
    public void update(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }

    @Override
    public void delete(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(client);
    }

    @Override
    public Client getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }
}
