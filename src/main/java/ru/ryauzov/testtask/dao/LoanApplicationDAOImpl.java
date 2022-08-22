package ru.ryauzov.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.entities.LoanApplicationEntity;

import java.util.List;

@Repository
public class LoanApplicationDAOImpl implements LoanApplicationDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<LoanApplicationEntity> allLoanApplications() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LoanApplicationEntity").list();
    }

    @Override
    public void create(LoanApplicationEntity loanApplicationEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(loanApplicationEntity);
    }

    @Override
    public void update(LoanApplicationEntity loanApplicationEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(loanApplicationEntity);
    }

    @Override
    public void delete(LoanApplicationEntity loanApplicationEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(loanApplicationEntity);
    }

    @Override
    public LoanApplicationEntity getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LoanApplicationEntity.class, id);
    }
}
