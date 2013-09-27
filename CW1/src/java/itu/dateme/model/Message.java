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
public class Message {
    private List<User> recipients = new ArrayList<User>();
    private User from;
    private String body;
    private String title;
    
    
    public Message(User fromUser, User toUser, String title, String body){
        this.title = title;
        this.body = body;
        this.from = fromUser;
        this.recipients.add(toUser);
        
        fromUser.getOutbox().add(this);
        toUser.getInbox().add(this);
    }

    public Message(User fromUser, List<User> toUsers, String title, String body){
        this.title = title;
        this.body = body;
        this.from = fromUser;
        this.recipients.addAll(toUsers);
        
        fromUser.getOutbox().add(this);
        
        for(User u : toUsers){
            u.getInbox().add(this);
        }
    }

    
    /**
     * @return the recipients
     */
    public List<User> getRecipients() {
        return recipients;
    }

    /**
     * @param recipients the recipients to set
     */
    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }

    /**
     * @return the from
     */
    public User getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    

}
