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
public class Main {
    public static void main(String[] args){
        User vesco = new User("Vesco", "vesco@khristian.dk", "yum");
        User kristian = new User("Kristian", "kristian@downtown.dk", "stuff");
        User miu = new User("Miul", "miu@miu.ro", "bla");
        
        List<User> toPeople = new ArrayList();
        toPeople.add(kristian);
        toPeople.add(miu);
        
        Message msg = new Message(vesco, toPeople, "good night", "body");
        
        System.out.println(kristian.getInbox().get(0).getTitle());
    }
}
