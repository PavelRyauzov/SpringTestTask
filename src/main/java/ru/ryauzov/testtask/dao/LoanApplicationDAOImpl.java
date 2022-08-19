package ru.ryauzov.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.models.LoanApplication;

import java.util.List;

@Repository
public class LoanApplicationDAOImpl implements LoanApplicationDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<LoanApplication> allLoanApplications() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LoanApplication").list();
    }

    @Override
    public void create(LoanApplication loanApplication) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(loanApplication);
    }

    @Override
    public void update(LoanApplication loanApplication) {
        Session session = sessionFactory.getCurrentSession();
        session.update(loanApplication);
    }

    @Override
    public void delete(LoanApplication loanApplication) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(loanApplication);
    }

    @Override
    public LoanApplication getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LoanApplication.class, id);
    }
}
