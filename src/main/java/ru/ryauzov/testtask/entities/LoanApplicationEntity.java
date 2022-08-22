package ru.ryauzov.testtask.entities;

import javax.persistence.*;

@Entity
@Table(name = "loan_applications")
public class LoanApplicationEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;

    @Column(name = "desired_loan_amount")
    private long desiredLoanAmount;

    @OneToOne
    @JoinColumn(name = "loan_decision_id")
    private ApprovedLoanDecisionEntity approvedLoanDecisionEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return clientEntity;
    }

    public void setClient(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public long getDesiredLoanAmount() {
        return desiredLoanAmount;
    }

    public void setDesiredLoanAmount(long desiredLoanAmount) {
        this.desiredLoanAmount = desiredLoanAmount;
    }

    public ApprovedLoanDecisionEntity getApprovedLoanDecision() {
        return approvedLoanDecisionEntity;
    }

    public void setApprovedLoanDecision(ApprovedLoanDecisionEntity approvedLoanDecisionEntity) {
        this.approvedLoanDecisionEntity = approvedLoanDecisionEntity;
    }
}
