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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSF Successfull login</title>
    </head>
    <body>
        <f:view>
 
        <h:form id="LoginForm">
 
            <h1>Welcome <h:outputText value="#{JsfLogin.loggedInUserName}"/>!!</h1>
            <h2>Name: <h:outputText value="#{JsfLogin.loggedInName}"/></h2>
            <h3>Address: <h:outputText value="#{JsfLogin.loggedInAdress}"/></h3>
                <h:outputText value="Search for user"/>
             <%--   <h:inputText id="search for user" value="#{Register.name}"/> --%>
            </h:form>
        </f:view>
        
    </body>
</html>