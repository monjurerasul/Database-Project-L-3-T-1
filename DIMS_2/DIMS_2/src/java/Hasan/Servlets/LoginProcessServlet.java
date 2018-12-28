/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hasan.Servlets;

import Hasan.Models.Employee;
import Hasan.db.NewDataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hasan Murad
 */
@WebServlet(name = "LoginProcessServlet", urlPatterns = {"/LoginProcessServlet.do"})
public class LoginProcessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
        response.setContentType("text/html;charset=UTF-8");
        
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        
        NewDataAccess db = new NewDataAccess();
        System.out.println("hi");
        Employee user = db.existanceOfUser(Integer.parseInt(userid),Integer.parseInt(password));
        System.out.println("hi");
        //System.out.println(user);
        if(user==null)
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginflag","No");
             RequestDispatcher rd = request.getRequestDispatcher("LogInPage.jsp");
             rd.forward(request, response);
        }
        else if(user.job_id==1)
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginflag","Yes");
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("MpoHome.jsp");
            rd.forward(request, response);
        }
        else if(user.job_id==2)
        {
            HttpSession session = request.getSession();
            session.setAttribute("loginflag","Yes");
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("DepoManagerHome.jsp");
            rd.forward(request, response);
        }
        else if(user.job_id==3){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("loginflag","Yes");
            RequestDispatcher rd = request.getRequestDispatcher("MDHome.jsp");
            rd.forward(request, response);
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
