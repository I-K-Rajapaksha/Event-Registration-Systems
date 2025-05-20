<%-- 
    Document   : eventForm
    Created on : Apr 9, 2025, 7:23:15?PM
    Author     : IsuruKumara
--%>

<%@ page language="java" %>
<html>
<head><title>Register for Event</title></head>
<body>
    <h2>Event Registration Form</h2>
    <form action="ParticipantServlet" method="post">
        Name: <input type="text" name="name" required/><br/>
        Email: <input type="email" name="email" required/><br/>
        Event: <input type="text" name="event" required/><br/>
        <input type="submit" value="Register"/>
    </form>
    <a href="ParticipantServlet">View All Participants</a>
</body>
</html>
