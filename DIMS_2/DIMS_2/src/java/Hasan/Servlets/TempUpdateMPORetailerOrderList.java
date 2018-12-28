/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hasan.Servlets;

import Hasan.Models.Depository;
import Hasan.Models.orderproduct;
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
@WebServlet(name = "TempUpdateMPORetailerOrderList", urlPatterns = {"/TempUpdateMPORetailerOrderList.do"})
public class TempUpdateMPORetailerOrderList extends HttpServlet {

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
        Vector<Depository> depo = (Vector<Depository>)session.getAttribute("depository");
        Vector<orderproduct> obj = (Vector<orderproduct>)session.getAttribute("orderproduct");
        Vector<orderproduct> obj1=new Vector<orderproduct>(2);
        for(orderproduct objc : obj){
                if(objc.PRODUCT_ID==Integer.parseInt(product_id)){
                    int stock = 0;
                    for(Depository temp: depo){if(temp.PRODUCT_ID==objc.PRODUCT_ID)stock=temp.STOCK_AMOUNT;}
                    if(stock>Integer.parseInt(quantity)){
                        objc.QUANTITY=Integer.parseInt(quantity);
                        if(objc.QUANTITY==Integer.parseInt(quantity))objc.status=2;
                        else objc.status=1;
                    }
                    System.out.println(stock);
                }
                obj1.addElement(objc);
            }
            session.setAttribute("orderproduct",obj1);
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
