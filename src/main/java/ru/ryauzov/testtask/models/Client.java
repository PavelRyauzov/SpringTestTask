package ru.ryauzov.testtask.models;

public class Client {
    private int id;
    private String fullName;
//    private String passportDetails;
//    private boolean maritalStatus;
//    private String registrationAddress;
//    private String contactNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return id + ", " + fullName;
    }
}
