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
            
            <h1>interest <h:outputText value="#{interestPage.interestName}"/>!!</h1>
           <%-- <h2>interest<h:outputText value="#{MyProfile.myName}"/></h2>
            <h3>Address: <h:outputText  value="#{MyProfile.myAdress}"/></h3>--%>
            <c:forEach var="o" items="${interestPage.peopleList}" varStatus="status">
 
               
                <c:out value="${o.myName}"/>
                <c:set var="myPersonPlace" scope="request" value="${status.count}" />
                <c:set var="thisPersonName" scope="request" value="${o.myName}" />
                <h:commandButton value="go to profile" action="#{interestPage.goToProfile}">
                    <f:param name="pointerPerson" value="#{myPersonPlace}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton><p>
              
 
            </c:forEach> 
                
            
            </h:form>
            
                
        
    </body>
   </f:view> 
</html>