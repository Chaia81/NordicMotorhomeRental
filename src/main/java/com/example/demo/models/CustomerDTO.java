package com.example.demo.models;

public class CustomerDTO {
    int cusId;
    String cusFirstName;
    String cusLastName;
    int cusPhone;
    String cusAddress;
    int cusZip;
    String cusCity;
    int cusDriversLicense;
    String cusEmail;

    public CustomerDTO() {

    }

    public CustomerDTO(int cusId, String cusFirstName, String cusLastName, int cusPhone, String cusAddress, int cusZip, String cusCity, int cusDriversLicense, String cusEmail) {
        this.cusId = cusId;
        this.cusFirstName = cusFirstName;
        this.cusLastName = cusLastName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
        this.cusZip = cusZip;
        this.cusCity = cusCity;
        this.cusDriversLicense = cusDriversLicense;
        this.cusEmail = cusEmail;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public int getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(int cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public int getCusZip() {
        return cusZip;
    }

    public void setCusZip(int cusZip) {
        this.cusZip = cusZip;
    }

    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    public int getCusDriversLicense() {
        return cusDriversLicense;
    }

    public void setCusDriversLicense(int cusDriversLicense) {
        this.cusDriversLicense = cusDriversLicense;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cusId=" + cusId +
                ", cusFirstName='" + cusFirstName + '\'' +
                ", cusLastName='" + cusLastName + '\'' +
                ", cusPhone=" + cusPhone +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusZip=" + cusZip +
                ", cusCity='" + cusCity + '\'' +
                ", cusDriversLicense=" + cusDriversLicense +
                ", cusEmail='" + cusEmail + '\'' +
                '}';
    }
}