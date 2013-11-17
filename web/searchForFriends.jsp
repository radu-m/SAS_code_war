<%-- 
    Document   : searchForFriends
    Created on : 13-11-2013, 19:14:08
    Author     : peddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body>
        <h1>Search humans</h1>
        <form action="${pageContext.request.contextPath}/people" method="POST">
            <p>
                <label for="searchName">Name: </label>
                <input name="searchName" type="text" id="searchName" />
            </p>
            <p>
                <input type="submit" value="Go">
            </p>
        </form>   
        <table>
        <tbody>
        <tr><th>ID</th><th>username</th><th>Name</th><th>Address</th></tr>
        <c:forEach items="${requestScope.people}" var="person">
        <tr><td><c:out value="${person.personId}"></c:out></td>
        <td><c:out value="${person.username}"></c:out></td>                    
        <td><c:out value="${person.fullName}"></c:out></td>
        <td><c:out value="${person.address}"></c:out></td></tr>
        </c:forEach>
        </tbody>
        </table>
    </body>
</html>
