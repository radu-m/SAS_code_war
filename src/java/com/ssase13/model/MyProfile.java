package com.ssase13.model;



import static com.ssase13.model.JsfLogin.loggedInID;
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
import com.ssase13.model.NameWithID;
import java.util.Map;
import javax.faces.bean.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peddy
 */
@ManagedBean(name="MyProfile")
@RequestScoped
public  class MyProfile {
    
    String ConnectionPath ;// "jdbc:mysql://localhost:3306/demodb";// 
    String ConnectionUser ;
    String ConnectionPW ;
    String javaSQLDriverPath ;
    String newInterest;
    String myName;
    String myAdress;
    String myUserName;
    int myID;
    Integer integerMyID;
    int hugPointer = 0;

    public int getFriendRequestPointer() {
        return friendRequestPointer;
    }

    public void setFriendRequestPointer(int friendRequestPointer) {
        this.friendRequestPointer = friendRequestPointer;
    }
    int friendPointer = 0;
    int friendRequestPointer = 0;

    public int getFriendPointer() {
        return friendPointer;
    }

    public void setFriendPointer(int friendPointer) {
        this.friendPointer = friendPointer;
    }

    public int getInterestPointer() {
        return interestPointer;
    }

    public void setInterestPointer(int interestPointer) {
        this.interestPointer = interestPointer;
    }

    public ArrayList<NameWithID> getFriendRequests() {
        return friendRequests;
    }

    public void setFriendRequests(ArrayList<NameWithID> friendRequests) {
        this.friendRequests = friendRequests;
    }
    int interestPointer = 0;
    ArrayList<String> HugNames ;
    ArrayList<Integer> HugIDS;
    int currentIndex;
    ArrayList<NameWithID> huggedBy;
    ArrayList<NameWithID> friendList;
    ArrayList<NameWithID> friendRequests;
    ArrayList<String> interestList;
    
    public MyProfile(){
        friendList = new ArrayList<NameWithID>();
        friendRequests = new ArrayList<NameWithID>();
        HugIDS = new ArrayList<Integer>();
        HugNames = new ArrayList<String>();
        huggedBy = new ArrayList<NameWithID>();
        interestList = new ArrayList<String>();
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
       getListOfHasInterests();
       getListOfHugNames();
       getListOfFriends();
       getListOfFriendRequests();
       
       
    }
    
    public String getNewInterest() {
        return newInterest;
    }

    public void setNewInterest(String newInterest) {
        this.newInterest = newInterest;
    }
    
    public ArrayList<NameWithID> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<NameWithID> friendList) {
        this.friendList = friendList;
    }

    public int getHugPointer() {
        return hugPointer;
    }

    public void setHugPointer(int hugPointer) {
        this.hugPointer = hugPointer;
    }
    
    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    

    public ArrayList<String> getInterestList() {
        return interestList;
    }

    public void setInterestList(ArrayList<String> interestList) {
        this.interestList = interestList;
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
                  log.info("in friend list\t"+ HugNames.get(i) );
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
    
    public void removeHug(){
        int removingID = huggedBy.get(hugPointer).myID;
        huggedBy.remove(hugPointer);
         try{
       //   Class.forName(javaSQLDriverPath);
          Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);  
       
            
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("DELETE FROM Hugs WHERE PersonID1=? AND PersonID2=?");
            inserter.setInt(2,myID);
            inserter.setInt(1,removingID);
            
            inserter.executeUpdate();;
           
             conn.close();
            inserter.close();
            }
        
            catch(Exception e){                
                log.info(e.getMessage());
        }
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
                int FriendsIDInt = rs.getInt("PersonID2");
                 NameWithID tempFriend = new NameWithID();
                 tempFriend.setMyID(FriendsIDInt);
                 friendList.add(tempFriend);           
            }
            for(int i =0;i < friendList.size();i++){
                friendList.get(i).setMyName(getNameByID(friendList.get(i).myID));
              
            }
            
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
                log.info(e.getMessage());
            }
    }
    public void addToHasInterestTable(){
            int newPersonID = myID;
            String newInterestName = newInterest;
        try{
          Class.forName(javaSQLDriverPath);
          Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);  
       
            
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("INSERT INTO HasInterest(PersonID,InterestName) VALUES(?,?)");
            inserter.setInt(1,newPersonID);
            inserter.setString(2,newInterestName);
           
            inserter.executeUpdate();;
             conn.close();
            inserter.close();
            interestList.add(newInterestName);
            }
        
            catch(Exception e){
            log.info(e.getMessage());

        }
        addToInterestTable(newInterestName);
    }
    public void addToInterestTable(String newName){
       
        try{
          Class.forName(javaSQLDriverPath);
          Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);  
       
            
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("INSERT INTO Interest(Name) VALUES(?)");
            inserter.setString(1,newName);
           
            inserter.executeUpdate();;
             conn.close();
            inserter.close();
            }
        
            catch(Exception e){
            log.info(e.getMessage());

        }
    }
     public void getListOfHasInterests(){
        interestList = new ArrayList();
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from HasInterest Where PersonID=?");
            inserter.setInt(1, myID);
            ResultSet rs=inserter.executeQuery();
            
            while(rs.next()){
                interestList.add(rs.getString("InterestName"));         
            }
           
            rs.close();
            st.close();
            conn.close();
            }
            catch(Exception e){
            log.info(e.getMessage());

            }
       // return friendRequestIDS;
    } 
     public void getListOfFriendRequests(){
         friendRequests = new ArrayList<NameWithID>();
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Select * from Relation Where PersonID2=? AND Relation=?");
            inserter.setInt(1, myID);
            inserter.setString(2, "friendRequest");


            ResultSet rs=inserter.executeQuery();
            
            while(rs.next()){
                int FriendsIDInt = rs.getInt("PersonID1");
                 NameWithID tempFriend = new NameWithID();
                 tempFriend.setMyID(FriendsIDInt);
                 friendRequests.add(tempFriend);           
            }
            
            rs.close();
            st.close();
            conn.close();
            for(int i =0;i < friendRequests.size();i++){
                friendRequests.get(i).setMyName(getNameByID(friendRequests.get(i).myID));
                log.info("infriendrequest: " +friendRequests.get(i).myName);
              
            }
            }
            catch(Exception e){
                log.info(e.getMessage());
            }
       // return friendRequestIDS;
    }
     
     public void acceptFriendRequest(int personID){
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("Update Relation SET Relation=? WHERE PersonID1=? AND PersonID2=?");
            inserter.setString(1, "friends");
            inserter.setInt(2,myID);
            inserter.setInt(3,personID);
            inserter.executeUpdate();
            inserter.setString(1, "friends");
            inserter.setInt(3,myID);
            inserter.setInt(2,personID);
            inserter.executeUpdate();
            conn.close();
            inserter.close();
            
            }
            catch(Exception e){
                    log.info(e.getMessage());

            }
        
    }
    public void removeFriendRequest( int removingID){ // also works for remove friend atm
        try{
          Class.forName(javaSQLDriverPath);
          Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);  
       
            
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("DELETE FROM Relation WHERE PersonID1=? AND PersonID2=?");
            inserter.setInt(2,myID);
            inserter.setInt(1,removingID);
            
            inserter.executeUpdate();
           inserter.setInt(1,myID);
            inserter.setInt(2,removingID);
            
            inserter.executeUpdate();
             conn.close();
            inserter.close();
            }
        
            catch(Exception e){
                
           log.info(e.getMessage());

        }
        
    }
    public void acceptHug(){
        FacesContext FC = FacesContext.getCurrentInstance();
        hugPointer = getPositionForHug(FC)-1;
        removeHug();
         //Map<String,String> params = 
    }
    public int getPositionForHug(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String currentPlace = params.get("pointerHug");
        log.info("currentspot\t"+currentPlace);
        return Integer.parseInt( currentPlace);
         //Map<String,String> params = 
    }
    public void goToFriendProfile(){
        
        FacesContext FC = FacesContext.getCurrentInstance();
        friendPointer = getPositionForFriend(FC)-1;
        goToProfile();
         //Map<String,String> params = 
    }
    public int getPositionForFriend(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String currentPlace = params.get("pointerFriend");
        
        return Integer.parseInt( currentPlace);
         //Map<String,String> params = 
    }
    
    public void goToProfile(){
        int profilesID = friendList.get(friendPointer).myID;
        String profileName = friendList.get(friendPointer).myName;
        log.info(("go to profile with id\t"+profilesID+ "\twith username\t"+profileName));
    
    }
    public void goToRemoveFriend(){
        
        FacesContext FC = FacesContext.getCurrentInstance();
        friendPointer = getPositionForFriend(FC)-1;
        removeFriendRequest(friendList.get(friendPointer).myID);
        friendList.remove(friendPointer);
         //Map<String,String> params = 
    }
    
    public int getPositionForInterest(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String currentPlace = params.get("pointerInterest");
        
        return Integer.parseInt( currentPlace);
         //Map<String,String> params = 
    }
    
    public void goToRemoveInterest(){
        FacesContext FC = FacesContext.getCurrentInstance();
        interestPointer = getPositionForInterest(FC)-1;
        removeFromHasInterestTable(interestList.get(interestPointer));
        interestList.remove(interestPointer);
    }
    
    public void removeFromHasInterestTable(String newInterestName){
       
        try{
       //   Class.forName(javaSQLDriverPath);
          Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);  
       
            
            PreparedStatement inserter = (PreparedStatement) conn.prepareStatement("DELETE FROM HasInterest WHERE PersonID=? AND Interestname=? ");
            inserter.setInt(1,myID);
            inserter.setString(2,newInterestName);
           
            inserter.executeUpdate();;
             conn.close();
            inserter.close();
            }
        
            catch(Exception e){
                
            // do something to catch error

        }
    }
    public String goToInterestProfile(){
        FacesContext FC = FacesContext.getCurrentInstance();
        interestPointer = getPositionForInterest(FC)-1;
       return navigateToInterestProfile();
    }
    
    public int getPositionForFriendRequest(FacesContext fc){
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String currentPlace = params.get("pointerFriendRequest");
        
        return Integer.parseInt( currentPlace);
         //Map<String,String> params = 
    }
    
    public void goToRemoveFriendRequest(){
        FacesContext FC = FacesContext.getCurrentInstance();
        friendRequestPointer = getPositionForFriendRequest(FC)-1;
        removeFriendRequest(friendRequests.get(friendRequestPointer).myID);
        friendRequests.remove(friendRequestPointer);
    }
    public void goToAcceptFriendRequest(){
        FacesContext FC = FacesContext.getCurrentInstance();
        friendRequestPointer = getPositionForFriendRequest(FC)-1;
        acceptFriendRequest(friendRequests.get(friendRequestPointer).myID);
        friendList.add(friendRequests.get(friendRequestPointer));
        friendRequests.remove(friendRequestPointer);
    }
    
    public String navigateToInterestProfile(){
        
        String profileName = interestList.get(interestPointer);
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);  
       
       session.setAttribute("myInterestProfileName", profileName);
        log.info("go to interest profile with id\t"+profileName);
        return "success";
    
    }
    
}

