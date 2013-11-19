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
            <c:out value="hugs recieved"/><p>
                
            <c:forEach var="o" items="${MyProfile.huggedBy}" varStatus="status">
                <c:out value="${status.count}" />
                
                <c:out value="from:"/>
                <c:out value="${o.myName}"/>
                <c:set var="salary" scope="request" value="${status.count}" />
                 <c:set var="thisHugName" value="${o.myName}" />
                <h:commandButton value="accept" action="#{MyProfile.acceptHug}">
                    <f:param name="pointerHug" value="#{salary}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton><p>
              <%--  <tr>
		<c:out value="${o.myName}"/><p>
		
                </tr>--%>
 
            </c:forEach>
                
             <c:out value="friend Requests"/><p>    
            <c:forEach var="o" items="${MyProfile.friendRequests}" varStatus="status">
 
               
                <c:out value="${o.myName}"/>
                <c:set var="myFriendRequest" scope="request" value="${status.count}" />
                <c:set var="thisFriendRequestName" scope="request" value="${o.myName}" />
                <h:commandButton value="accept request" action="#{MyProfile.goToAcceptFriendRequest}">
                    <f:param name="pointerFriendRequest" value="#{myFriendRequest}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton>
                <h:commandButton value="reject friend request" action="#{MyProfile.goToRemoveFriendRequest}">
                    <f:param name="pointerFriendRequest" value="#{myFriendRequest}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton><p>
 
            </c:forEach>    
                
            <c:out value="friend list"/><p>    
            <c:forEach var="o" items="${MyProfile.friendList}" varStatus="status">
 
               
                <c:out value="${o.myName}"/>
                <c:set var="myFriend" scope="request" value="${status.count}" />
                <c:set var="thisFriendName" scope="request" value="${o.myName}" />
                <h:commandButton value="go to profile" action="#{MyProfile.goToFriendProfile}">
                    <f:param name="pointerFriend" value="#{myFriend}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton>
                <h:commandButton value="remove friend" action="#{MyProfile.goToRemoveFriend}">
                    <f:param name="pointerFriend" value="#{myFriend}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton><p>
 
            </c:forEach>
                <c:out value="interest list"/><p>
            <c:forEach var="o" items="${MyProfile.interestList}" varStatus="status">
                <c:out value="${o}"/>
                <c:set var="myInterestSpot" scope="request" value="${status.count}" />
                <c:set var="thisInterestName" scope="request" value="${o}" />
                <h:commandButton value="see others with this interest" action="#{MyProfile.goToInterestProfile}">
                    <f:param name="pointerInterest" value="#{myInterestSpot}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton>
                <h:commandButton value="remove interest" action="#{MyProfile.goToRemoveInterest}">
                    <f:param name="pointerInterest" value="#{myInterestSpot}" />
              <%--      <f:setPropertyActionListener target ="#{MyProfile.hugPointer}" value = "#{status.count}"/>
                    <f:actionListener type="MyProfile.removeHug" /> --%>
                </h:commandButton><p>
                <tr>
		
		
                </tr> 
            </c:forEach>
        <h:inputText id="addinterest" value="#{MyProfile.newInterest}"/>
        <h:commandButton value="add new interest" action="#{MyProfile.addToHasInterestTable}"/> <p>
           <h:outputText value="Search for user"/>
             <%--   <h:inputText id="search for user" value="#{Register.name}"/> --%>
            </h:form>
            
                
        
    </body>
   </f:view> 
</html>