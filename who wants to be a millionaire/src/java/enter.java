/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/enter"})
public class enter extends HttpServlet {

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
            String login = request.getParameter("login"); 
            String password = request.getParameter("password"); 
            try{ 
                String db = "jdbc:derby://localhost:1527/tasa"; 
                String user = "root"; 
                String psql = "root"; 
                Class.forName("com.mysql.jdbc.Driver"); 
                
                String sql = "INSERT INTO users VALUES(?,?,?,?)"; 
                
                Connection con = DriverManager.getConnection(db, user, psql); 
                Statement st = con.createStatement(); 
                String sql2 = ("SELECT * FROM users"); 
                ResultSet rs = st.executeQuery(sql2); 
                int i = 0;
                boolean exist = false; 
                boolean tried = false; 
                int count=0;
                while(rs.next()) { 
                    i++; 
                    if(login.equals(rs.getString("ipn"))){ 
                        if(password.equals(rs.getString("password"))){ 
                            count=rs.getInt("count");
                            exist = true; 
                            if(rs.getBoolean("tried")){ 
                                tried = true; 
                            } 
                            break; 
                        } 
                    } 
                } 
                
                if(exist && !tried){ 
                    HttpSession session = request.getSession(); 
                    session.setAttribute("login", login);
                    session.setAttribute("tried", tried);
                    session.setAttribute("count", count);
                    response.sendRedirect("start.jsp"); 
                    out.print("Вы зашли");
                    out.print("<br>");
                    out.print(session.getAttribute("login"));
                    
                }
                else if (tried){ 
                    out.println("Вы уже играли"); 
                    HttpSession session = request.getSession(); 
                    session.setAttribute("login", login);
                    session.setAttribute("tried", tried);
                    session.setAttribute("count", count);
                    out.print("<br>");
                    out.println("<a href='index.html'>Go back</a>"); 
                }
                else{ 
                    out.println("У вас неправильный пароль или логин, попробуйте еще раз");
                    out.print("<br>");
                    out.println("<a href='index.html'>Go back</a>"); 
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
