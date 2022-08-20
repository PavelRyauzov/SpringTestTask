package ru.ryauzov.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.LoanAgreementDAO;
import ru.ryauzov.testtask.models.LoanAgreement;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LoanAgreementsServiceImpl implements LoanAgreementService {
    private LoanAgreementDAO loanAgreementDAO;

    @Autowired
    public void setLoanAgreementDAO(LoanAgreementDAO loanAgreementDAO) {
        this.loanAgreementDAO = loanAgreementDAO;
    }

    @Override
    @Transactional
    public List<LoanAgreement> allLoanAgreements() {
        return loanAgreementDAO.allLoanAgreements();
    }

    @Override
    @Transactional
    public void create(LoanAgreement loanAgreement) {
        loanAgreementDAO.create(loanAgreement);
    }

    @Override
    @Transactional
    public void update(LoanAgreement loanAgreement) {
        loanAgreementDAO.update(loanAgreement);
    }

    @Override
    @Transactional
    public void delete(LoanAgreement loanAgreement) {
        loanAgreementDAO.delete(loanAgreement);
    }

    @Override
    @Transactional
    public LoanAgreement getById(long id) {
        return loanAgreementDAO.getById(id);
    }
}
