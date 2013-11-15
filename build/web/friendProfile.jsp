<%-- 
    Document   : friendProfile
    Created on : 13-11-2013, 19:13:46
    Author     : peddy
--%>

<%@page import="com.jsflogin.friendProfile"%>
<%@page import="com.jsflogin.Success"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>



<!DOCTYPE html>
<jsp:useBean id="test" class="com.jsflogin.JsfLogin" /> 
<%
            friendProfile fp = new friendProfile();
            String getName = (String)session.getAttribute("loggedinName");
           
            String resp = fp.getAdressByUser(getName);
           
            pageContext.setAttribute("resp", resp);
%>
  <%-- </c:set> --%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <p1> My adress is ${resp}</p1>
<br><br>
<%-- c:set example to set variable value --%>

<br><br>

    </body>
</html>
