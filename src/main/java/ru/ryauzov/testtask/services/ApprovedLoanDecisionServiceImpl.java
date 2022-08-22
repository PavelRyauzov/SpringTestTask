package ru.ryauzov.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.ApprovedLoanDecisionDAO;
import ru.ryauzov.testtask.entities.LoanApplicationEntity;

import javax.transaction.Transactional;

@Service
public class ApprovedLoanDecisionServiceImpl implements ApprovedLoanDecisionService {
    private ApprovedLoanDecisionDAO approvedLoanDecisionDAO;

    @Autowired
    public void setApprovedLoanDecisionDAO(ApprovedLoanDecisionDAO approvedLoanDecisionDAO) {
        this.approvedLoanDecisionDAO = approvedLoanDecisionDAO;
    }

    @Transactional
    @Override
    public void create(LoanApplicationEntity loanApplicationEntity) {
//        ApprovedLoanDecision approvedLoanDecision = new ApprovedLoanDecision();
//
//        Random random = new Random();
//
//        if (random.nextBoolean()) {
//            int minTerm = 30;
//            int maxTerm = 365;
//            int diffTerm = maxTerm - minTerm;
//            int termValue = random.nextInt(diffTerm + 1);
//            termValue += minTerm;
//            approvedLoanDecision.setLoanMaturity(termValue);
//
//            long minAmount = 5000;
//            long maxAmount = loanApplication.getDesiredLoanAmount();
//            int diffAmount = (int) (maxAmount - minAmount);
//            long amountValue = random.nextInt(diffAmount + 1);
//            amountValue += minAmount;
//            approvedLoanDecision.setApprovedLoanAmount(amountValue);
//
//            approvedLoanDecision.setLoanApplication(loanApplication);
//
//            approvedLoanDecisionDAO.create(approvedLoanDecision);
        }
    }

