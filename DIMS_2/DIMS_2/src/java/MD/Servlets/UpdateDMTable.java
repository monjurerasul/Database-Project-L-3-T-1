/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD.Servlets;

import Hasan.Models.Employee;
import Hasan.Models.Products;
import Hasan.db.NewDataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
@WebServlet(name = "UpdateDMTable", urlPatterns = {"/UpdateDMTable.do"})
public class UpdateDMTable extends HttpServlet {

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
        String employee_id=request.getParameter("employee_id");
        String password = request.getParameter("password");
       String first_name=request.getParameter("first_name");
       String last_name=request.getParameter("last_name");
       String salary=request.getParameter("salary");
       String area_id = request.getParameter("area_id");
       
       NewDataAccess db = new NewDataAccess();
        System.out.println(employee_id);
        System.out.println(password);
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(salary);
        System.out.println(area_id);
       boolean exist = db.UpdateDM(Integer.parseInt(employee_id),Integer.parseInt(password),first_name,last_name,Integer.parseInt(area_id),Integer.parseInt(salary));
        
        if(exist==true)
        {
            
          HttpSession session = request.getSession();
          //session.setAttribute("current_retailer_id", retailer_id);
          Vector<Employee> exist1 = db.getDMList();
          session.setAttribute("dmlist", exist1);  
          RequestDispatcher rd = request.getRequestDispatcher("UpdateDMList.jsp");
          rd.forward(request, response); 
        } 
        else {
          //pore
            System.out.println("hi");
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
