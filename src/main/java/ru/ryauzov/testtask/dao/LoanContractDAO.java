package ru.ryauzov.testtask.dao;

import ru.ryauzov.testtask.entities.LoanContractEntity;

import java.util.List;

public interface LoanContractDAO {
    List<LoanContractEntity> allLoanContracts();
    List<LoanContractEntity> allSignedLoanContracts();
    void create(LoanContractEntity loanContractEntity);
    void update(LoanContractEntity loanContractEntity);
    void delete(LoanContractEntity loanContractEntity);
    LoanContractEntity getById(long id);
}
