package ru.ryauzov.testtask.models;

import javax.persistence.*;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "desired_loan_amount")
    private int desiredLoanAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    //    private boolean decisionStatus;
//    private int loanTerm;
//    private int approvedLoanAmount;
}
