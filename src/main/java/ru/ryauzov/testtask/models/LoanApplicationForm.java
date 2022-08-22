package ru.ryauzov.testtask.models;

import ru.ryauzov.testtask.entities.ClientEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LoanApplicationForm {
    private String fullName;

    private String passportSerial;

    private String passportNumber;

    private boolean maritalStatus;

    private String registrationAddress;

    private String contactNumber;

    private String companyName;

    private String post;

    private int workPeriod;

    private long desiredLoanAmount;

    public ClientEntity parseEntityFromForm(ClientEntity client) {
        client.setFullName(this.getFullName());
        client.setPassportSerial(this.getPassportSerial());
        client.setPassportNumber(this.getPassportNumber());
        client.setMaritalStatus(this.getMaritalStatus());
        client.setRegistrationAddress(this.getRegistrationAddress());
        client.setContactNumber(this.getContactNumber());
        client.setCompanyName(this.getCompanyName());
        client.setPost(this.getPost());
        client.setWorkPeriod(this.getWorkPeriod());

        return client;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public boolean getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(int workPeriod) {
        this.workPeriod = workPeriod;
    }

    public long getDesiredLoanAmount() {
        return desiredLoanAmount;
    }

    public void setDesiredLoanAmount(long desiredLoanAmount) {
        this.desiredLoanAmount = desiredLoanAmount;
    }
}
