package ru.ryauzov.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.models.LoanAgreement;
import ru.ryauzov.testtask.models.LoanApplication;

import java.util.List;

@Repository
public class LoanAgreementDAOImpl implements LoanAgreementDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<LoanAgreement> allLoanAgreements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LoanAgreement").list();
    }

    @Override
    public void create(LoanAgreement loanAgreement) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(loanAgreement);
    }

    @Override
    public void update(LoanAgreement loanAgreement) {
        Session session = sessionFactory.getCurrentSession();
        session.update(loanAgreement);
    }

    @Override
    public void delete(LoanAgreement loanAgreement) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(loanAgreement);
    }

    @Override
    public LoanAgreement getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(LoanAgreement.class, id);
    }
}
