<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Success
    Created on : Nov 8, 2013, 10:42:33 AM
    Author     : Drakthal
--%>

<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
  <f:view>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSF Successfull login</title>
    </head>
    <body> 
        <h:form id="LoginForm">
            
            <h1>Welcome <h:outputText value="#{MyProfile.myUserName}"/>!!</h1>
            <h2>Name: <h:outputText value="#{MyProfile.myName}"/></h2>
            <h3>Address: <h:outputText  value="#{MyProfile.myAdress}"/></h3>
       
                <c:forEach var="listsOfHugs" items="${MyProfile.huggedBy}" varStatus="status">
                    <br/>
                <c:out value="${listsOfHugs.myName}" /><td>
                 <c:out value="${listsOfHugs.myID}" /><td>   
                 
                 </c:forEach>
                <h:outputText value="Search for user"/>
             <%--   <h:inputText id="search for user" value="#{Register.name}"/> --%>
            </h:form>
                
        
    </body>
   </f:view> 
</html>