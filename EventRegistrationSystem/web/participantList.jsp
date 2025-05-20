<%-- 
    Document   : participantList
    Created on : Apr 9, 2025, 7:23:38 PM
    Author     : IsuruKumara
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Participants List</title></head>
<body>
    <h2>List of Participants</h2>
    <c:forEach var="participant" items="${participantList}">
        <p>
            ${participant.name} - ${participant.email} - ${participant.event}
        </p>
    </c:forEach>
    <br/>
    <a href="eventForm.jsp">Back to Registration</a>
</body>
</html>
