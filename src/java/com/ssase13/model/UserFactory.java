/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssase13.model;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

import com.ssase13.model.Person;

/**
 *
 * @author miul
 */
public class UserFactory {
    String ConnectionPath ;// "jdbc:mysql://localhost:3306/demodb";// 
    String ConnectionUser ;
    String ConnectionPW ;
    String javaSQLDriverPath ;
    public UserFactory(){
        ConnectionInfo info     = new ConnectionInfo();
        ConnectionPath          = info.ConnectionPath;
        ConnectionUser          = info.ConnectionUser;
        ConnectionPW            = info.ConnectionPW;
        javaSQLDriverPath       = info.javaSQLDriverPath;
    }
    
    public ArrayList<Person> listByName(String name){
        ArrayList ppl = new ArrayList();
        
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st = conn.createStatement();
            
            String sql = "SELECT * FROM Person WHERE Username = ?  ";
            
            PreparedStatement prep = (PreparedStatement) conn.prepareStatement(sql);
            prep.setString(1, name);
            ResultSet result = prep.executeQuery();
            
            while(result.next()){
 
                Person p = new Person();
                System.out.print("\n //////////");
                System.out.print(p.toString());
                System.out.print("///////// \n");        
                
                p.setFullName(result.getString("Name"));
                p.setUsername(result.getString("Username"));                
                p.setAddress(result.getString("Adress"));
                p.setPersonId(result.getInt("PersonID"));
//                p.setPersonId(2);
                
                
                ppl.add(p);
            }
            result.close();
            st.close();
            conn.close();

        }
        catch(Exception e){
            System.out.print("\n ...");
            System.out.print(e.getMessage());
        }
        return ppl;
    }
    
}
