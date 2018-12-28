/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hasan.Servlets;

import Hasan.Models.Depository;
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
@WebServlet(name = "UpdateDepositoryOrderProduct", urlPatterns = {"/UpdateDepositoryOrderProduct.do"})
public class UpdateDepositoryOrderProduct extends HttpServlet {

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
        String s=(String)session.getAttribute("current_MPO_id");
        String retailer_id=(String)session.getAttribute("current_retailer_id");
        Vector<orderproduct> obj = (Vector<orderproduct>)session.getAttribute("orderproduct");
        Vector<Depository> depo = (Vector<Depository>)session.getAttribute("depository");
        Employee e = (Employee)session.getAttribute("user");
        for(orderproduct objc : obj){
            //System.out.println("hi");
            boolean exist=db.UpdateStatusOrderProductList(Integer.parseInt(s),Integer.parseInt(retailer_id),objc.PRODUCT_ID,objc.QUANTITY,objc.status);
            ///System.out.println("hi");
            int stock = 0;
            for(Depository temp: depo){if(temp.PRODUCT_ID==objc.PRODUCT_ID)stock=temp.STOCK_AMOUNT;}
            boolean exist1=db.UpdateDepository(objc.PRODUCT_ID,e.employee_id ,stock-objc.QUANTITY );
        }
        Vector<orderproduct> exist2=db.getorderlist1(Integer.parseInt(s),Integer.parseInt(retailer_id)); 
        session.setAttribute("orderproduct",exist2);
         RequestDispatcher rd = request.getRequestDispatcher("ShowMPORetailerOrderList.jsp");
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
