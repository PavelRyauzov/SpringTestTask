package ru.ryauzov.testtask.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "loan_agreements")
public class LoanAgreement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "loan_application_id")
    private LoanApplication loanApplication;

    @Column(name = "signing_date")
    private Date signingDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }
}
