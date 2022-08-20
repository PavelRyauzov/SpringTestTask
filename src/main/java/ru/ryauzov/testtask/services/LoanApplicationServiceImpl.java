package ru.ryauzov.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.LoanApplicationDAO;
import ru.ryauzov.testtask.models.LoanApplication;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService{

    private LoanApplicationDAO loanApplicationDAO;

    @Autowired
    public void setLoanApplicationDAO(LoanApplicationDAO loanApplicationDAO) {
        this.loanApplicationDAO = loanApplicationDAO;
    }

    @Override
    @Transactional
    public List<LoanApplication> allLoanApplications() {
        return loanApplicationDAO.allLoanApplications();
    }

    @Override
    @Transactional
    public void create(LoanApplication loanApplication) {
        loanApplicationDAO.create(loanApplication);
    }

    @Override
    @Transactional
    public void update(LoanApplication loanApplication) {
        loanApplicationDAO.update(loanApplication);
    }

    @Override
    @Transactional
    public void delete(LoanApplication loanApplication) {
        loanApplicationDAO.delete(loanApplication);
    }

    @Override
    @Transactional
    public LoanApplication getById(long id) {
        return loanApplicationDAO.getById(id);
    }

    @Override
    @Transactional
    public void makeDecision(LoanApplication loanApplication) {
        Random random = new Random();

        if(random.nextBoolean()) {
            int min = 30;
            int max = 365;
            int diff = max - min;
            int i = random.nextInt(diff + 1);
            i += min;
            loanApplication.setLoanTerm(i);

            min = 5000;
            max = loanApplication.getDesiredLoanAmount();
            diff = max - min;
            i = random.nextInt(diff + 1);
            i += min;
            int amount = i;
            loanApplication.setApprovedLoanAmount(i);

            loanApplicationDAO.update(loanApplication);
        }
    }
}
