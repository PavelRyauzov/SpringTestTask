package ru.ryauzov.testtask.dao;

import ru.ryauzov.testtask.entities.ApprovedLoanDecisionEntity;

import java.util.List;

public interface ApprovedLoanDecisionDAO {
    List<ApprovedLoanDecisionEntity> allApprovedLoanDecisions();

    void create(ApprovedLoanDecisionEntity approvedLoanDecisionEntity);

    void update(ApprovedLoanDecisionEntity approvedLoanDecisionEntity);

    void delete(ApprovedLoanDecisionEntity approvedLoanDecisionEntity);

    ApprovedLoanDecisionEntity getById(long id);

    public ApprovedLoanDecisionEntity getByLoanApplicationId(long id);
}
