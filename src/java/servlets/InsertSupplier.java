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
@WebServlet(name = "InsertSupplier", urlPatterns = {"/InsertSupplier.do"})
public class InsertSupplier extends HttpServlet {

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
        DataAccess db=new DataAccess();
        //Integer.parseInt(request.getParameter("supplierId"));
        String name=request.getParameter("name");
        int supplierId=db.getSupplier(name);
        String location=request.getParameter("location");
        int branchId=Integer.parseInt(request.getParameter("branchId"));
        int productId=db.getLatestProduct();
        if(supplierId==0) {
            supplierId=db.getLatestSupplier()+1;
            int count=db.CreateSupplier(supplierId,name,location,branchId,productId);
        }
        PrintWriter pq = new PrintWriter("F:\\some.txt"); 
        pq.write(productId);
        pq.flush();
        pq.close();
        if(true){
            HttpSession session = request.getSession();
           // session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("DonePage.jsp");
            rd.forward(request, response);
        }
        else{
                HttpSession session = request.getSession();
           // session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("InsertSupplier.jsp");
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
