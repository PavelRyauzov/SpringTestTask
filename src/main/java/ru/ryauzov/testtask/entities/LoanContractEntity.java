package ru.ryauzov.testtask.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "loan_contracts")
public class LoanContractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "signing_date")
    private Date signingDate;

    @Column(name = "signing_status")
    private boolean signingStatus;

    @OneToOne
    @JoinColumn(name = "loan_application_id")
    private LoanApplicationEntity loanApplicationEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public boolean isSigningStatus() {
        return signingStatus;
    }

    public void setSigningStatus(boolean signingStatus) {
        this.signingStatus = signingStatus;
    }

    public LoanApplicationEntity getLoanApplicationEntity() {
        return loanApplicationEntity;
    }

    public void setLoanApplicationEntity(LoanApplicationEntity loanApplicationEntity) {
        this.loanApplicationEntity = loanApplicationEntity;
    }
}
