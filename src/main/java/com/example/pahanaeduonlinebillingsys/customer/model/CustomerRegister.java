package com.example.pahanaeduonlinebillingsys.customer.model;

public class CustomerRegister {

    private String AccNo;
    private String FirstName;
    private String LastName;
    private String Address;
    private String MobileNo;

    public CustomerRegister(String AccNo, String FirstName, String LastName, String Address, String MobileNo) {
        this.AccNo = AccNo;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.MobileNo = MobileNo;
    }

    public String getAccNo() {
        return AccNo;
    }
    public void setAccNo(String AccNo) {
        this.AccNo = AccNo;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getMobileNo() {
        return MobileNo;
    }
    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

}
