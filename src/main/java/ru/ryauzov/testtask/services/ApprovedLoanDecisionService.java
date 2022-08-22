package ru.ryauzov.testtask.services;

import ru.ryauzov.testtask.entities.LoanApplicationEntity;

public interface ApprovedLoanDecisionService {
    void create(LoanApplicationEntity loanApplicationEntity);
}
