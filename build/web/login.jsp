<%-- 
    Document   : Login
    Created on : Nov 8, 2013, 10:41:32 AM
    Author     : Drakthal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSF Login Application in Netbeans</title>
    </head>
    <body>
      <% HttpSession  s1 = pageContext.getSession();%>
    <f:view>
       <h:form id="loginform">
            <h:panelGrid id="lpg" columns="2">
 
                <h:outputText value="User ID"/>
                <h:inputText id="loginid" value="#{JsfLogin.loginid}"/>
                
                <h:outputText value="Password"/>
                <h:inputSecret id="password" value="#{JsfLogin.password}"/>
                <h:outputText value=""/>
                <h:commandButton value="Login" action="#{JsfLogin.CheckValidUser}"/>
                <h:outputText value=""/>
                
                
            </h:panelGrid>
        </h:form>
        <form action="${pageContext.request.contextPath}/MyProfile.jsp" method="post">
            <input id="clickMe" type="submit" value="Login"  />
        </form>
    </f:view>
</body>
</html>
