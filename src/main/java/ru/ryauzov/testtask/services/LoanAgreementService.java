package ru.ryauzov.testtask.services;

import ru.ryauzov.testtask.models.Client;
import ru.ryauzov.testtask.models.LoanAgreement;

import java.util.List;

public interface LoanAgreementService {
    List<LoanAgreement> allLoanAgreements();
    void create(LoanAgreement loanAgreement);
    void update(LoanAgreement loanAgreement);
    void delete(LoanAgreement loanAgreement);
    LoanAgreement getById(long id);
}
