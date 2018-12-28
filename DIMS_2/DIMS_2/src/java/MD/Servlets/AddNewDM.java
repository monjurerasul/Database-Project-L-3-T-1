/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.Servlets;

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
@WebServlet(name = "AddNewDM", urlPatterns = {"/AddNewDM.do"})
public class AddNewDM extends HttpServlet {

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
       String first_name = request.getParameter("first_name");
        String password = request.getParameter("password");
        String last_name = request.getParameter("last_name");
        String salary = request.getParameter("salary");
        String area_id = request.getParameter("area_id");
        
        NewDataAccess db = new NewDataAccess();
        System.out.println("hi");
        HttpSession session = request.getSession();
        //Employee e = (Employee)session.getAttribute("user");
        int success = db.InsertEmployeeDM(2,Integer.parseInt(area_id),first_name,last_name,Integer.parseInt(password),Integer.parseInt(salary));
        System.out.println("hi");
        System.out.println(success);
         if(success!=-1)
        {
            Employee e = new Employee();
            e.setArea_id(Integer.parseInt(area_id));
            e.setEmployee_id(success);
            e.setFirst_name(first_name);
            e.setLast_name(last_name);
            e.setPassword(Integer.parseInt(password));
            e.setSalary(Integer.parseInt(salary));
            session.setAttribute("NewDM",e);
            RequestDispatcher rd = request.getRequestDispatcher("SuccessfulCreateNewDMAccount.jsp");
            rd.forward(request, response);
        }
         else {
             RequestDispatcher rd = request.getRequestDispatcher("CreateNewDMAccount.jsp");
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
