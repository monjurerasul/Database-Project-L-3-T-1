/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MPO.Servlets;

import Hasan.Models.Employee;
import Hasan.Models.orderproduct;
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
@WebServlet(name = "DeleteAllComfirmOrder", urlPatterns = {"/DeleteAllComfirmOrder.do"})
public class DeleteAllComfirmOrder extends HttpServlet {

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
        NewDataAccess db = new NewDataAccess();
         HttpSession session = request.getSession();
         Employee e=(Employee)session.getAttribute("user");
         String retailer_id=(String)session.getAttribute("current_retailer_id");
        Vector<orderproduct> exist=db.getorderlist1(e.employee_id,Integer.parseInt(retailer_id));
        for(orderproduct objc: exist){
            if(objc.status!=0){
                boolean success = db.DeleteOrderProductList(objc.EMPLOYEE_ID,objc.RETAILER_ID ,objc.PRODUCT_ID);
            }
        }
         Vector<orderproduct> exist1=db.getorderlist1(e.employee_id,Integer.parseInt(retailer_id));
         session.setAttribute("orderproduct",exist1);
         RequestDispatcher rd = request.getRequestDispatcher("ShowRetailerOrder.jsp");
         rd.forward(request, response);
        
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
