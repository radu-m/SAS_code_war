/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssase13.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author miul
 */
public class Person {
    protected String fullName     = "";
    protected String email        = "";
    protected String phoneNumber  = "";
    protected String address      = "";
    protected String username     = "";
    protected int personId;
    
    public Person(){
        
    }
    
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String name){
        this.fullName = name;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String usrName){
        this.username = usrName;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String em){
        this.email = em;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String addr){
        this.address = addr;
    }
    
    public int getPersonId(){
        return personId;
    }
    public void setPersonId(int id){
        this.personId = id;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phone){
        this.phoneNumber = phone;
    }
    
    
}
