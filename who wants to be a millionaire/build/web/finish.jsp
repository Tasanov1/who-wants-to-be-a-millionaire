<%-- 
    Document   : finish
    Created on : 24.09.2017, 7:18:58
    Author     : tassa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Миллионер</title>
    </head>
    <body>
        <% HttpSession ses = request.getSession(); %>
        <% String login = (String)ses.getAttribute("login"); %>
        
        <h1><%= login %>, МИЛЛИОН ВАШ!</h1>
        
        <form action="rating" method="POST">
            <input type="submit" value="рейтинг">
        </form>
        
        
    </body>
</html>
