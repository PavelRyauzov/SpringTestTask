package ru.ryauzov.testtask.models;

import javax.persistence.*;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "desired_loan_amount")
    private int desiredLoanAmount;

    @Column(name = "loan_term")
    private int loanTerm;

    @Column(name = "approved_loan_amount")
    private int approvedLoanAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getDesiredLoanAmount() {
        return desiredLoanAmount;
    }

    public void setDesiredLoanAmount(int desiredLoanAmount) {
        this.desiredLoanAmount = desiredLoanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public int getApprovedLoanAmount() {
        return approvedLoanAmount;
    }

    public void setApprovedLoanAmount(int approvedLoanAmount) {
        this.approvedLoanAmount = approvedLoanAmount;
    }
}
