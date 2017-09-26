<%-- 
    Document   : start7
    Created on : 24.09.2017, 6:45:29
    Author     : tassa
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    </head>
    <body>
        <% HttpSession ses = request.getSession(); %>
        <% String login = (String)ses.getAttribute("login"); %>
        <%= login %>
        <% if(ses.getAttribute("tried").equals(true) || (ses.getAttribute("login").equals(null) && ses.getAttribute("tried").equals(null))){
            response.sendRedirect("index.html"); 
        }%>
        

        <h1>Вы начали игру!</h1>
        <form action="question7" method="POST">
            <h1> 7) Самая большая ягода в мире </h1>				
            <input type="checkbox" name="checkbox" id="1" value="a" checked="true"/> Дриада <br>
            <input type="checkbox" name="checkbox" id="2" value="b" /> Тыква <br>
            <input type="checkbox" name="checkbox" id="3" value="c" /> Арбуз <br>
            <input type="checkbox" name="checkbox" id="4" value="d" /> Клубника <br>
            <input type="submit" value="ответить">
        </form>
        
        
        
        <script type="text/javascript">
            var handler = function ( event ){
              event = event || window.event;
              var target = event.target || event.srcElement;
              if ( target.nodeType == 1 && target.nodeName.toLowerCase() == "input" && target.type == "checkbox" && target.checked ) {
                var inputs = document.getElementsByTagName("input");
                for ( var i = 0; inputs[i]; i++ ) {
                  if ( inputs[i].type == "checkbox" && inputs[i] != target ) {
                    inputs[i].checked = false;
                  }
                }
              }
          }
            if (document.addEventListener){
              document.addEventListener('click', handler, false);
            } else if (document.attachEvent){
              document.attachEvent('onclick', handler);
            }
        </script>
        
    </body>
</html>

