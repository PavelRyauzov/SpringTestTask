package ru.ryauzov.testtask.services;

import ru.ryauzov.testtask.entities.LoanContractEntity;
import ru.ryauzov.testtask.models.LoanContractForm;

import java.util.List;

public interface LoanContractService {
    List<LoanContractEntity> allLoanContracts();
    List<LoanContractEntity> allSignedLoanContracts();
        void sign(LoanContractForm loanContractForm, long loanApplicationId);
    void update(LoanContractEntity loanContractEntity);
    void delete(LoanContractEntity loanContractEntity);
    LoanContractEntity getById(long id);
}
