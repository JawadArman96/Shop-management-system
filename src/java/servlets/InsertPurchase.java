/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DataAccess;
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
 * @author ASUS
 */
@WebServlet(name = "InsertPurchase", urlPatterns = {"/InsertPurchase.do"})
public class InsertPurchase extends HttpServlet {

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
       //Integer.parseInt(request.getParameter("purchaseId"));
        String name = request.getParameter("productName");
        int quantity=Integer.parseInt(request.getParameter("PQUANTITY"));
        String purchaseDate=request.getParameter("PURCHASE_DATE");
        DataAccess db=new DataAccess();
        int purchaseId=db.getLatestPurchase()+1;
        int customerId= db.getLatestCustomer();
        int productId=db.getProduct(name);
        int count=db.CreatePurchase(purchaseId,productId,quantity,purchaseDate,customerId);
        
        if(count!=0) {
            HttpSession session = request.getSession();
           // session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("DonePage.jsp");
            rd.forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
           // session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("InsertPurchase.jsp");
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
