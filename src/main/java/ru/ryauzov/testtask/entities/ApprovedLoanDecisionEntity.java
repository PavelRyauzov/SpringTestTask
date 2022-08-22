package ru.ryauzov.testtask.entities;

import javax.persistence.*;

@Entity
@Table(name = "approved_loan_decisions")
public class ApprovedLoanDecisionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "loan_maturity")
    private int loanMaturity;

    @Column(name = "approved_loan_amount")
    private long approvedLoanAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLoanMaturity() {
        return loanMaturity;
    }

    public void setLoanMaturity(int loanMaturity) {
        this.loanMaturity = loanMaturity;
    }

    public long getApprovedLoanAmount() {
        return approvedLoanAmount;
    }

    public void setApprovedLoanAmount(long approvedLoanAmount) {
        this.approvedLoanAmount = approvedLoanAmount;
    }
}
