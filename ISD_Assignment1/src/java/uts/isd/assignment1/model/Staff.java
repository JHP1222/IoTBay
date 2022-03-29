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
public class Staff {
   
   private int staffID;
   private String fName;
   private String lName;
   private String dOB;
   private String gender;
   private String email;
   private int phoneNum;
   private String empolyment_date;
   private String password;

    public Staff(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Staff(int staffID, String fName, String lName, String dOB, String gender, 
           String email, int phoneNum, String empolyment_date, String password) {
        this.staffID = staffID;
        this.fName = fName;
        this.lName = lName;
        this.dOB = dOB;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.empolyment_date = empolyment_date;
        this.password = password;
    }

    //Getter
    public int getStaffID() {
        return staffID;
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

    public String getEmail() {
        return email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getEmpolyment_date() {
        return empolyment_date;
    }

    public String getPassword() {
        return password;
    }
    
    
    //Setter
    public void setStaffID(int staffID) {
        this.staffID = staffID;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmpolyment_date(String empolyment_date) {
        this.empolyment_date = empolyment_date;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    
    
    
}
