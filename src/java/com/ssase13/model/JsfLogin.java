package com.ssase13.model;

import static com.ssase13.model.Register.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.BasicConfigurator;

@SessionScoped
public class JsfLogin {
    String loginid;
    String password;
    String searchName;
    String ConnectionPath ;// "jdbc:mysql://localhost:3306/demodb";// 
    String ConnectionUser ;
    String ConnectionPW ;
    String javaSQLDriverPath ;
    String loggedInName;
    String loggedInUserName;
    String loggedInAdress;
    int loggedInID;
    static Logger log = LogManager.getLogger(JsfLogin.class.getName());
    Register myReg;
    public JsfLogin(){
        log.info("User has entered the slice");
        ConnectionInfo tempConn = new ConnectionInfo();
        ConnectionPath = tempConn.ConnectionPath;
        ConnectionUser = tempConn.ConnectionUser;
        ConnectionPW = tempConn.ConnectionPW;
        javaSQLDriverPath = tempConn.javaSQLDriverPath;
        myReg = new Register();
    }
    public String getLoggedInName() {
        return loggedInName;
    }

    public void setLoggedInName(String loggedInName) {
        this.loggedInName = loggedInName;
    }

    public String getLoggedInUserName() {
        return loggedInUserName;
    }

    public void setLoggedInUserName(String loggedInUserName) {
        this.loggedInUserName = loggedInUserName;
    }

    public String getLoggedInAdress() {
        return loggedInAdress;
    }

    public void setLoggedInAdress(String loggedInAdress) {
        this.loggedInAdress = loggedInAdress;
    }

    public String getLoginid() {
        return loginid;
    }
 
    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public String CheckValidUser(){
        return checkValidLogin(loginid, password);
    }
     public String checkValidLogin(String myUserName, String myPW){
        
        try{
            Class.forName(javaSQLDriverPath);
            Connection conn=(Connection)DriverManager.getConnection(ConnectionPath,ConnectionUser,ConnectionPW);
            Statement st=conn.createStatement();
            String query="Select * from User";
            

            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
               // return rs.getString("Username");
                 if(myUserName.equals(rs.getString("Username"))){
                    if(myPW.equals(rs.getString("Password"))){
                        setUserVariables(myUserName);
                        return "friendProfile";     
                    }
                    else{
                         return "wrongPassword";                
                    }     
                 }  
                 log.info(myUserName +"\t"+rs.getString("Username"));
                
            }
            
            rs.close();
            st.close();
            conn.close();
           
            return "userNotFound";
            }
            catch(Exception e){
                  
                return e.getMessage();

            }
        
    }
    public void setUserVariables(String currentUser){
        loggedInUserName = currentUser;
        loggedInAdress = myReg.getAdressByUser(currentUser);
        loggedInName = myReg.getNameByUser(currentUser);
        loggedInID = myReg.getIDByUserName(currentUser);
        
    } 
    public void searchByName(String searchForThis){
         myReg.findIDbyName(searchForThis);
    }
 
}