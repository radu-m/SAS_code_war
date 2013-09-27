/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miul
 */
public class User {
    private String name;
    private String cpr;
    private String address;
    private String email;
    private String passsword;
    private String phone;
        
    private List<User> contacts = new ArrayList<User>();
    private List<Message> inbox = new ArrayList<Message>();
    private List<Message> outbox = new ArrayList<Message>();
    
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.passsword = password;
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cpr
     */
    public String getCpr() {
        return cpr;
    }

    /**
     * @param cpr the cpr to set
     */
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the passsword
     */
    public String getPasssword() {
        return passsword;
    }

    /**
     * @param passsword the passsword to set
     */
    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the contacts
     */
    public List<User> getContacts() {
        return contacts;
    }

    /**
     * @param contacts the contacts to set
     */
    public void setContacts(List<User> contacts) {
        this.contacts = contacts;
    }

    /**
     * @return the inbox
     */
    public List<Message> getInbox() {
        return inbox;
    }

    /**
     * @param inbox the inbox to set
     */
    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }

    /**
     * @return the outbox
     */
    public List<Message> getOutbox() {
        return outbox;
    }

    /**
     * @param outbox the outbox to set
     */
    public void setOutbox(List<Message> outbox) {
        this.outbox = outbox;
    }

    public String toString(){
        return "name: " + name + " email: " + email;
    }
}

