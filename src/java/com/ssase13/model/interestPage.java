package com.ssase13.model;


import com.ssase13.model.ConnectionInfo;
import com.ssase13.model.NameWithID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.ssase13.model.NameWithID;
import static com.ssase13.model.Register.log;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peddy
 */
public class interestPage {
    String interestName;
    ArrayList<NameWithID> peopleList;
    String ConnectionPath ;// "jdbc:mysql://localhost:3306/demodb";// 
    String ConnectionUser ;
    String ConnectionPW ;
    String javaSQLDriverPath ;
    String myUserName;
    int personPointer = 0;
    int myID;
    public interestPage(){
        //set name to something
        
        ConnectionInfo tempConn = new ConnectionInfo();
        ConnectionPath = tempConn.ConnectionPath;
        ConnectionUser = tempConn.ConnectionUser;
        ConnectionPW = tempConn.ConnectionPW;
        javaSQLDriverPath = tempConn.javaSQLDriverPath;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
        
       
       interestName = (String) session.getAttribute("myInterestProfileName");
        peopleList = new ArrayList<NameWithID>();
        myUserName = (String) session.getAttribute("myLoggedInUserName");
         myID = getIDByUserName(myUserName);
        getListOfNames();
        
    }

    
    public String goToProfile(){
        FacesContext FC = FacesContext.getCurrentInstance();
        personPointer = getPointer(FC)-1;
        return navigateToProfile(peopleList.get(personPointer).myID);
    }
    public String navigateToProfile(int profileID){
        String returnVal = "navigate to id\t"+profileID;
         log.info(returnVal);
        if(profileID == myID){
            return "myProfile";
        }
        else{
            if(isPersonMyFriend(profileID) ){
           return viewFriendProfile(profileID);
            } else{
                return viewNonFriendProfile(profileID);
            }
        }
       
       
    }
    public String viewNonFriendProfile(int profileID){
        //prepare for moving on to profile that is not friend. 
        return "do something sick";
    }
    public String viewFriendProfile(int profileID){
        //prepare for moving on to new profile. 
        return "do something sick";
    }
    
    public boolean isPersonMyFriend(int profileID){
        boolean isMyfriend = false;
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from Relation Where PersonID1=? AND PersonID2=? AND Relation=?");
            inserter.setInt(1, myID);
            inserter.setInt(2, profileID);
            inserter.setString(3, "friends");


            ResultSet rs=inserter.executeQuery();
            
            while(rs.next()){
                isMyfriend = true;           
            }
            
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
                log.info(e.getMessage());
            }
        return isMyfriend;
    }
    public int getPointer(FacesContext fc){
         Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String currentPlace = params.get("pointerPerson");
        
        return Integer.parseInt( currentPlace);
    }

    public int getPersonPointer() {
        return personPointer;
    }

    public void setPersonPointer(int personPointer) {
        this.personPointer = personPointer;
    }
    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public ArrayList<NameWithID> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ArrayList<NameWithID> peopleList) {
        this.peopleList = peopleList;
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
    public void getListOfNames(){
        
            peopleList = new ArrayList<NameWithID>();
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from HasInterest Where Interestname=?");
            inserter.setString(1, interestName);
            ResultSet rs=inserter.executeQuery();
            
            while(rs.next()){
                NameWithID tempGuy = new NameWithID();
                tempGuy.setMyID(rs.getInt("personID"));
                peopleList.add(tempGuy);    
                
                
            }
           
            rs.close();
            st.close();
            conn.close();
            for(int i = 0; i < peopleList.size();i++){
                
                String tempNameString = getNameByID(peopleList.get(i).getMyID());
               
                peopleList.get(i).setMyName(tempNameString);
            }
            }
            catch(Exception e){

            }
       // return friendIDS;
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
}
