package ru.ryauzov.testtask.dao;

import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanApplication;

import java.util.List;

public interface LoanApplicationDAO {
    List<LoanApplication> allLoanApplications();
    void create(LoanApplication loanApplication);
    void update(LoanApplication loanApplication);
    void delete(LoanApplication loanApplication);
    LoanApplication getById(long id);
}
