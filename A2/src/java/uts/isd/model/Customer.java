/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author jaehyeon
 */
public class Customer implements Serializable{
    private int customerId;
    private String customerfName;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerfName() {
        return customerfName;
    }

    public void setCustomerfName(String customerfName) {
        this.customerfName = customerfName;
    }
    
}
