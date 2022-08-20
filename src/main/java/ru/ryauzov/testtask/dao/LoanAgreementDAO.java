package ru.ryauzov.testtask.dao;

import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanAgreement;
import ru.ryauzov.testtask.models.LoanApplication;

import java.util.List;

public interface LoanAgreementDAO {
    List<LoanAgreement> allLoanAgreements();
    void create(LoanAgreement loanAgreement);
    void update(LoanAgreement loanAgreement);
    void delete(LoanAgreement loanAgreement);
    LoanAgreement getById(long id);
}
