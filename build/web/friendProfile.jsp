<%-- 
    Document   : friendProfile
    Created on : 13-11-2013, 19:13:46
    Author     : peddy
--%>

<%@page import="com.jsflogin.friendProfile"%>
<<<<<<< HEAD
=======
<%@page import="com.jsflogin.Success"%>
>>>>>>> be01eacd6bfa3b906c51fd0f44fbbe76187a4c65
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<<<<<<< HEAD
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<!DOCTYPE html>
=======



<!DOCTYPE html>
<jsp:useBean id="test" class="com.jsflogin.JsfLogin" /> 
<%
            friendProfile fp = new friendProfile();
            String getName = (String)session.getAttribute("loggedinName");
           
            String resp = fp.getAdressByUser(getName);
           
            pageContext.setAttribute("resp", resp);
%>
  <%-- </c:set> --%>

>>>>>>> be01eacd6bfa3b906c51fd0f44fbbe76187a4c65
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<<<<<<< HEAD
        <c:set var="test" value="test1"/>
            <%
            friendProfile fp = new friendProfile();
            String resp = fp.getAdressByUser("Jonatan");
            %>
        <c:out value="${resp}"/>
=======
        
>>>>>>> be01eacd6bfa3b906c51fd0f44fbbe76187a4c65
        <p1> My adress is ${resp}</p1>
<br><br>
<%-- c:set example to set variable value --%>

<br><br>

    </body>
</html>
