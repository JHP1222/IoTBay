/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.assignment1.model;

/**
 *
 * @author jaehyeon
 */
public class Customer {
    private int customerID;
    private String email;
    private String password;
    private String fName;
    private String lName;
    private String dOB;
    private String gender;
    private int phoneNum;
    private String billing_Address;
    private String address;
    private String city;
    private String region;
    private int postCode;
    private String Country;
    
    //Constructor for login
    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    // Constructor for register
    public Customer(String email, String password, String fName, String lName, String dOB, String gender, 
                    int phoneNum, String billing_Address) {
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.dOB = dOB;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.billing_Address = billing_Address;
    }
    
    //Getter
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getdOB() {
        return dOB;
    }

    public String getGender() {
        return gender;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getBilling_Address() {
        return billing_Address;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return Country;
    }
    
    
    //Setter 
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setBilling_Address(String billing_Address) {
        this.billing_Address = billing_Address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
