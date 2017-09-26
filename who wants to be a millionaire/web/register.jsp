<%-- 
    Document   : register
    Created on : 22.09.2017, 12:42:56
    Author     : tassa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация</title>
    </head>
    <body>
        <h1>Регистрация</h1>
        <form action="register" method="POST">
            <input type="text" name="login" placeholder="login">
            <br><br>
            <input type="password" name="password" placeholder="password">
            <br><br>
            <input type="submit" value="Зарегестрироваться">
            <br>
            <br>
        </form>
        <button onclick="goBack()">Go Back</button>
        
        <script>
            function goBack() {
                window.history.back();
            }
            </script>   
    </body>
</html>
