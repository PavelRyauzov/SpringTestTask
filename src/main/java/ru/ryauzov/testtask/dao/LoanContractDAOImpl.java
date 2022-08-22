package ru.ryauzov.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.entities.LoanContractEntity;

import java.util.List;

@Repository
public class LoanContractDAOImpl implements LoanContractDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<LoanContractEntity> allLoanContracts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LoanContractEntity").list();
    }

    @Override
    public List<LoanContractEntity> allSignedLoanContracts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LoanContractEntity where signingStatus = true").list();
    }

    @Override
    public void create(LoanContractEntity loanContract) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(loanContract);
    }

    @Override
    public void update(LoanContractEntity loanContract) {
        Session session = sessionFactory.getCurrentSession();
        session.update(loanContract);
    }

    @Override
    public void delete(LoanContractEntity loanContract) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(loanContract);
    }

    @Override
    public LoanContractEntity getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LoanContractEntity.class, id);
    }
}
