package ru.ryauzov.testtask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryauzov.testtask.dao.ApprovedLoanDecisionDAO;
import ru.ryauzov.testtask.dao.ClientDAO;
import ru.ryauzov.testtask.dao.LoanApplicationDAO;
import ru.ryauzov.testtask.entities.ApprovedLoanDecisionEntity;
import ru.ryauzov.testtask.entities.ClientEntity;
import ru.ryauzov.testtask.entities.LoanApplicationEntity;
import ru.ryauzov.testtask.models.LoanApplicationForm;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private LoanApplicationDAO loanApplicationDAO;

    private ClientDAO clientDAO;

    private ApprovedLoanDecisionDAO approvedLoanDecisionDAO;

    @Autowired
    public void setLoanApplicationDAO(LoanApplicationDAO loanApplicationDAO) {
        this.loanApplicationDAO = loanApplicationDAO;
    }

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Autowired
    public void setApprovedLoanDecisionDAO(ApprovedLoanDecisionDAO approvedLoanDecisionDAO) {
        this.approvedLoanDecisionDAO = approvedLoanDecisionDAO;
    }

    @Override
    @Transactional
    public List<LoanApplicationEntity> allLoanApplications() {
        return loanApplicationDAO.allLoanApplications();
    }

    @Override
    @Transactional
    public long create(LoanApplicationForm form) {
        List<ClientEntity> clientByPassport = clientDAO.getByPassport(form.getPassportSerial(), form.getPassportNumber());

        ClientEntity client;

        if (clientByPassport.isEmpty()) {
            client = new ClientEntity();
            client = form.parseEntityFromForm(client);

            clientDAO.create(client);
        } else {
            client = clientByPassport.get(0);
            client = form.parseEntityFromForm(client);

            clientDAO.update(client);
        }

        LoanApplicationEntity loanApplication = new LoanApplicationEntity();
        loanApplication.setClient(client);
        loanApplication.setDesiredLoanAmount(form.getDesiredLoanAmount());
        loanApplicationDAO.create(loanApplication);

        return loanApplication.getId();
    }

    @Override
    @Transactional
    public void makeDecision(LoanApplicationEntity loanApplicationEntity) {
        ApprovedLoanDecisionEntity approvedLoanDecision = new ApprovedLoanDecisionEntity();

        Random random = new Random();

        if (random.nextBoolean()) {
            int minTerm = 30;
            int maxTerm = 365;
            int diffTerm = maxTerm - minTerm;
            int termValue = random.nextInt(diffTerm + 1);
            termValue += minTerm;
            approvedLoanDecision.setLoanMaturity(termValue);

            long minAmount = 5000;
            long maxAmount = loanApplicationEntity.getDesiredLoanAmount();
            int diffAmount = (int) (maxAmount - minAmount);
            long amountValue = random.nextInt(diffAmount + 1);
            amountValue += minAmount;
            approvedLoanDecision.setApprovedLoanAmount(amountValue);

            approvedLoanDecisionDAO.create(approvedLoanDecision);

            loanApplicationEntity.setApprovedLoanDecision(approvedLoanDecision);

            loanApplicationDAO.update(loanApplicationEntity);
        }
    }

    @Override
    @Transactional
    public void delete(LoanApplicationEntity loanApplicationEntity) {
        loanApplicationDAO.delete(loanApplicationEntity);
    }

    @Override
    @Transactional
    public LoanApplicationEntity getById(long id) {
        return loanApplicationDAO.getById(id);
    }
}

