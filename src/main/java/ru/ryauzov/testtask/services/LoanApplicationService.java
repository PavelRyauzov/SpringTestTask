package ru.ryauzov.testtask.services;

import ru.ryauzov.testtask.entities.LoanApplicationEntity;
import ru.ryauzov.testtask.models.LoanApplicationForm;

import java.util.List;

public interface LoanApplicationService {
    List<LoanApplicationEntity> allLoanApplications();
    long create(LoanApplicationForm form);
    void makeDecision(LoanApplicationEntity loanApplicationEntity);
    void delete(LoanApplicationEntity loanApplicationEntity);
    LoanApplicationEntity getById(long id);
}
