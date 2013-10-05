/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
/**
 *
 * @author miul
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin")})
    

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @Column(name = "Admin")
    private boolean admin;
    private String name;
    private String cpr;
    private String address;
    private String email;
    private String passsword;
    private String phone;

    static Logger logger = Logger.getLogger(User.class.getName());

    private List<User> contacts = new ArrayList<User>();
    private List<Message> inbox = new ArrayList<Message>();
    private List<Message> outbox = new ArrayList<Message>();    
    
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.passsword = password;
        logger.log(Priority.DEBUG, email);
        
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
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
     * @param password the password to set
     */
    public void setPasssword(String password) {
        this.passsword = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itu.dateme.model.User[ username=" + username + " ]";
    }

    public User() {
    }
}

