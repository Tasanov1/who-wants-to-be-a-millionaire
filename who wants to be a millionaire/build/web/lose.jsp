<%-- 
    Document   : lose
    Created on : 24.09.2017, 8:05:46
    Author     : tassa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Конец игры</title>
    </head>
    <body>
        <% HttpSession ses = request.getSession(); %>
        <% String login = (String)ses.getAttribute("login"); %>
        <h1><%= login %>, Вы проиграли!</h1>
        
        <form action="rating" method="POST">
            <input type="submit" value="рейтинг">
        </form>
        
        
    </body>
</html>

