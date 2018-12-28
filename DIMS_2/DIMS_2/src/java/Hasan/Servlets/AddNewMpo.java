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
@WebServlet(name = "AddNewMpo", urlPatterns = {"/AddNewMpo.do"})
public class AddNewMpo extends HttpServlet {

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
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(password);
        System.out.println(salary);
        NewDataAccess db = new NewDataAccess();
        System.out.println("hi");
        HttpSession session = request.getSession();
       Employee e = (Employee)session.getAttribute("user");
        System.out.println(e);
       // System.out.println(1);
       // System.out.println(e.area_id);
        System.out.println(e.employee_id);
        System.out.println("hi");
        int  success = db.InsertEmployee(1,e.area_id,e.employee_id,first_name,last_name,Integer.parseInt(password),Integer.parseInt(salary));
        System.out.println("hi");
        System.out.println(success);
         if(success!=-1)
        {
            Employee e1=new Employee();
            e1.area_id=e.area_id;
            e1.first_name=first_name;
            e1.last_name=last_name;
            e1.password=Integer.parseInt(password);
            e1.salary=Integer.parseInt(salary);
            e1.employee_id = success;
            e1.job_id=1;
            e1.job_title="mpo";
            session.setAttribute("newmpo", e1);
             RequestDispatcher rd = request.getRequestDispatcher("SuccessfulCreateNewAccount.jsp");
            rd.forward(request, response);
        }
         else {
             RequestDispatcher rd = request.getRequestDispatcher("CreateNewAccount.jsp");
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
