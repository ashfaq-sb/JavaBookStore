package com.ash.ood;

public class Customer {
    private String cName, cAddress, cardNo, expiryDate;

    public Customer() {
        // TODO Auto-generated constructor stub
    }

    public Customer(String cName, String cAddress, String cardNo, String expiryDate) {

        this.setcName(cName);
        this.cAddress = cAddress;
        this.cardNo = cardNo;
        this.expiryDate = expiryDate;
    }


    public String getcName() {
        return cName;
    }


    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCustomerDetails() {
        return this.getcName() + " " + this.getcAddress();

    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }
}
