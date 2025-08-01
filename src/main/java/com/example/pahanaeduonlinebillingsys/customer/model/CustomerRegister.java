package com.example.pahanaeduonlinebillingsys.customer.model;

public class CustomerRegister {

    private int AccNo;
    private String FirstName;
    private String LastName;
    private String Address;
    private String MobileNo;

    public CustomerRegister(int AccNo, String FirstName, String LastName, String Address, String MobileNo) {
        this.AccNo = AccNo;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.MobileNo = MobileNo;
    }

    public int getAccNo() {
        return AccNo;
    }
    public void setAccNo(int AccNo) {
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
