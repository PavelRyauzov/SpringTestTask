package ru.ryauzov.testtask.services;

import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanApplication;

import java.util.List;

public interface LoanApplicationService {
    List<LoanApplication> allLoanApplications();
    void create(LoanApplication loanApplication);
    void update(LoanApplication loanApplication);
    void delete(LoanApplication loanApplication);
    LoanApplication getById(long id);
    void makeDecision(LoanApplication loanApplication);

}
