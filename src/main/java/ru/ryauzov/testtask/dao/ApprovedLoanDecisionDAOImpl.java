package ru.ryauzov.testtask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ryauzov.testtask.entities.ApprovedLoanDecisionEntity;

import java.util.List;

@Repository
public class ApprovedLoanDecisionDAOImpl implements ApprovedLoanDecisionDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ApprovedLoanDecisionEntity> allApprovedLoanDecisions() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ApprovedLoanDecision").list();
    }

    @Override
    public void create(ApprovedLoanDecisionEntity approvedLoanDecisionEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(approvedLoanDecisionEntity);
    }

    @Override
    public void update(ApprovedLoanDecisionEntity approvedLoanDecisionEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(approvedLoanDecisionEntity);
    }

    @Override
    public void delete(ApprovedLoanDecisionEntity approvedLoanDecisionEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(approvedLoanDecisionEntity);
    }

    @Override
    public ApprovedLoanDecisionEntity getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ApprovedLoanDecisionEntity.class, id);
    }

    @Override
    public ApprovedLoanDecisionEntity getByLoanApplicationId(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ApprovedLoanDecision where loanApplication.id = :id");
        query.setParameter("id", id);
        List list = query.list();
        return (ApprovedLoanDecisionEntity) list.get(0);
    }
}
