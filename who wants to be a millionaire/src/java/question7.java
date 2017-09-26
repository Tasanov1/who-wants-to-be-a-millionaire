/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tassa
 */
@WebServlet(urlPatterns = {"/question7"})
public class question7 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException { 
            response.setContentType("text/html;charset=UTF-8"); 
            PrintWriter out = response.getWriter();
            
            String ans = request.getParameter("checkbox");
            
            try{  
                //Сессия
                HttpSession ses = request.getSession();
                String login = (String)ses.getAttribute("login");
                out.print("Приятной игры "+login + "!" +"<br>");
                out.print("<a href=\"start8.jsp\">следующий вопрос</a>");
                //Сессия
                String db = "jdbc:derby://localhost:1527/tasa"; 
                String user = "root"; 
                String psql = "root"; 
                Class.forName("com.mysql.jdbc.Driver");
                String sql = "INSERT INTO users VALUES(?,?,?,?)"; 
                Connection con = DriverManager.getConnection(db, user, psql); 
                Statement st = con.createStatement(); 
                String sql2 = ("SELECT * FROM users"); 
                ResultSet rs = st.executeQuery(sql2); 
                int count=0;
                int i = 0;  
                while(rs.next()) { 
                    i++; 
                    if(login.equals(rs.getString("IPN"))){ 
                        count=rs.getInt("COUNT"); 
                        break; 
                    } 
                }  
                
                if(ans.equals("c")){
                    String query = ("update users set count=count+100000 where ipn="+"'"+login+"'");
                    st.executeUpdate(query);
                }
                else if(ans.equals("a") || ans.equals("d") || ans.equals("b")){
                    String query = ("update users set tried=true where ipn="+"'"+login+"'");
                    st.executeUpdate(query);
                    response.sendRedirect("index.html");
                }
                
                
            }
            catch(Exception e){ 
                out.print("<br>"); 
                out.print(e); 
            } 
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
 