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
 * @author peddy
 */
public class friendProfile {
    String myUserName="Jonatan";
    String friendName="testName";
    String friendAddress;
    ArrayList listOfNames; 
    boolean HugSent;
    String ConnectionPath ;// "jdbc:mysql://localhost:3306/demodb";// 
    String ConnectionUser ;
    String ConnectionPW ;
    public friendProfile(){
     /*   friendName= getNameByUser(myUserName);
        friendAddress= getAdressByUser(friendAddress);
        ConnectionInfo info = new ConnectionInfo();
        ConnectionPath= info.ConnectionPath;
        ConnectionUser = info.ConnectionUser;
        ConnectionPW = info.ConnectionPW;*/
    }
   
    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendAddress() {
        return friendAddress;
    }

    public void setFriendAddress(String friendAddress) {
        this.friendAddress = friendAddress;
    }

    public ArrayList getListOfNames() {
        return listOfNames;
    }

    public void setListOfNames(ArrayList listOfNames) {
        this.listOfNames = listOfNames;
    }

    public boolean isHugSent() {
        return HugSent;
    }

    public void setHugSent(boolean HugSent) {
        this.HugSent = HugSent;
    }
    public String getAdressByUser(String myUserName){
        String adress = "";
        
        try{
          //  Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
           
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select Adress from Person WHERE Username=?");
            inserter.setString(1, myUserName);
           
            ResultSet rs=inserter.executeQuery();
            while(rs.next()){
                 adress = rs.getString("Adress");
           
            
            }
           
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
              

            }
        return adress;
        
    }
    public String getNameByUser(String myUserName){
        String myName = "";
        
        try{
          //  Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
           
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select Name from Person WHERE Username=?");
            inserter.setString(1, myUserName);
           
            ResultSet rs=inserter.executeQuery();
            while(rs.next()){
                 myName = rs.getString("Name");
           
            
            }
           
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
              

            }
        return myName;
        
    }
}
