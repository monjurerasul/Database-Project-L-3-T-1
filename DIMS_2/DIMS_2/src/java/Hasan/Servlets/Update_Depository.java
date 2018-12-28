/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hasan.Servlets;

import Hasan.Models.Depository;
import Hasan.Models.Employee;
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
@WebServlet(name = "Update_Depository", urlPatterns = {"/Update_Depository.do"})
public class Update_Depository extends HttpServlet {

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
        String product_id = request.getParameter("product_id");
        String product_name = request.getParameter("product_name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        HttpSession session = request.getSession();
        Employee e = (Employee)session.getAttribute("user");
        
        NewDataAccess db = new NewDataAccess();
        
        boolean success = db.UpdateDepository(Integer.parseInt(product_id),e.employee_id,Integer.parseInt(quantity));
        
        System.out.println(success);
         if(success==true)
        {
            Vector<Depository> obj = (Vector<Depository>)session.getAttribute("depository");
            Vector<Depository> obj1=new Vector<Depository>(2);
            for(Depository objc : obj){
                if(objc.PRODUCT_ID==Integer.parseInt(product_id)){
                    objc.STOCK_AMOUNT=Integer.parseInt(quantity);
                }
                obj1.addElement(objc);
            }
            session.setAttribute("depository",obj1);
            RequestDispatcher rd = request.getRequestDispatcher("depository.jsp");
            rd.forward(request, response);
        }
         else {
             RequestDispatcher rd = request.getRequestDispatcher("depository.jsp");
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
