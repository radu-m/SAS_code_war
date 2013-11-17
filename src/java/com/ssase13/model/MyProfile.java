package com.ssase13.model;


import com.ssase13.model.ConnectionInfo;
//import static com.ssase13.model.JsfLogin.loggedInID;
import static com.ssase13.model.Register.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import java.util.HashMap; 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peddy
 */
public  class MyProfile {
    
    String ConnectionPath ;// "jdbc:mysql://localhost:3306/demodb";// 
    String ConnectionUser ;
    String ConnectionPW ;
    String javaSQLDriverPath ;
    
    String myName;
    String myAdress;
    String myUserName;
    int myID;
    Integer integerMyID;
    ArrayList<String> HugNames ;
    ArrayList<Integer> HugIDS;
    int currentIndex;
    ArrayList<NameWithID> huggedBy;
    ArrayList<NameWithID> friendList;
    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    public MyProfile(){
        friendList = new ArrayList<NameWithID>();
        HugIDS = new ArrayList<Integer>();
        HugNames = new ArrayList<String>();
        huggedBy = new ArrayList<NameWithID>();
        ConnectionInfo tempConn = new ConnectionInfo();
        ConnectionPath = tempConn.ConnectionPath;
        ConnectionUser = tempConn.ConnectionUser;
        ConnectionPW = tempConn.ConnectionPW;
        javaSQLDriverPath = tempConn.javaSQLDriverPath;
       HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
        
       
       myUserName = (String) session.getAttribute("myLoggedInUserName");
       myID = getIDByUserName(myUserName);
       myName = getNameByUser(myUserName);
       myAdress = getAdressByUser(myUserName);
       getListOfHugNames();
         HashMap<String, Integer> hugList = new HashMap<String, Integer>();
       
    }

    public ArrayList<NameWithID> getHuggedBy() {
        return huggedBy;
    }

    public void setHuggedBy(ArrayList<NameWithID> huggedBy) {
        this.huggedBy = huggedBy;
    }

   

    
    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAdress() {
        return myAdress;
    }

    public void setMyAdress(String myAdress) {
        this.myAdress = myAdress;
    }

    public String getMyUserName() {
        return myUserName;
    }

    public void setMyUserName(String myUserName) {
        this.myUserName = myUserName;
    }

    public int getMyID() {
        return myID;
    }

    public void setMyID(int myID) {
        this.myID = myID;
    }
    
    public String getAdressByUser(String myUserName){
        String adress = "";
        
        try{
            Class.forName(javaSQLDriverPath);
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
        String myTempName = "";
        
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
           
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select Name from Person WHERE Username=?");
            inserter.setString(1, myUserName);
           
            ResultSet rs=inserter.executeQuery();
            while(rs.next()){
                 myTempName = rs.getString("Name");
           
            
            }
           
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){


            }
        return myTempName;
        
    }
    public void getListOfHugNames(){
        log.info("adding hugs for id" +myID);
         HugIDS = new ArrayList<Integer>();
         HugNames = new ArrayList<String>();
         
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from Hugs Where PersonID2=?");
            inserter.setInt(1, myID);
            ResultSet rs=inserter.executeQuery();
            
            while(rs.next()){
                //HugIDS.add(rs.getInt("personID1"));
                HugIDS.add(rs.getInt("personID1"));    
                
                
            }
           
            rs.close();
            st.close();
            conn.close();
            for(int i = 0; i < HugIDS.size();i++){
                int tempIDInt =(int)HugIDS.get(i);
                String tempNameString = getNameByID(tempIDInt);
                NameWithID tempNameID = new NameWithID();
                tempNameID.setMyName(tempNameString);
                tempNameID.setMyID(tempIDInt);
                
                huggedBy.add(tempNameID);
                
                HugNames.add(tempNameString);
                
            }
            }
            catch(Exception e){
            

            }
       // return friendIDS;
    }
    
    public String getNameByID(int thisID){
        String myName = "";
        
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
           
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select Name from Person WHERE PersonID=?");
            inserter.setInt(1, thisID);
           
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
    public int getIDByUserName(String myUserName){
        int myIDgetIDUserName = 0;
        
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
           
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from Person WHERE Username=?");
            inserter.setString(1, myUserName);
           
            ResultSet rs=inserter.executeQuery();
            while(rs.next()){
                 myIDgetIDUserName = rs.getInt("PersonID");
           
            
            }
           
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
              log.info(e.getMessage());

            }
        return myIDgetIDUserName;
        
    }

    public ArrayList<String> getHugNames() {
        return HugNames;
    }

    public void setHugNames(ArrayList<String> HugNames) {
        this.HugNames = HugNames;
    }

    public ArrayList<Integer> getHugIDS() {
        return HugIDS;
    }

    public void setHugIDS(ArrayList<Integer> HugIDS) {
        this.HugIDS = HugIDS;
    }
    public void getListOfFriends(){
        friendList = new ArrayList<NameWithID>();
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from Relation Where PersonID1=? AND Relation=?");
            inserter.setInt(1, myID);
            inserter.setString(2, "friends");


            ResultSet rs=inserter.executeQuery();
            
            while(rs.next()){
                int FriendsIDInt = rs.getInt("personID2");
                 NameWithID tempFriend = new NameWithID();
                 tempFriend.setMyID(FriendsIDInt);
                 friendList.add(tempFriend);
                
//                friendIDS.add(rs.getInt("personID2"));
                 System.out.println("friends with:\t"+rs.getInt("personID2"));
           
            
            }
           
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
           
            }
    }

}
