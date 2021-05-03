/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "productoptions", urlPatterns = {"/productoptions.do"})
public class productoptions extends HttpServlet {

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
            PrintWriter ps = new PrintWriter("F:\\some.txt"); 
            ps.write(request.getParameter("select"));
            ps.flush();
            if(request.getParameter("select").equalsIgnoreCase("Product")==true) {
                    
                HttpSession session = request.getSession();
           // session.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("InsertProduct.jsp");
                rd.forward(request, response);
            }
            else if(request.getParameter("select").equalsIgnoreCase("Quantity")==true){
                     DataAccess db=new DataAccess();
                    List<Products> SelectedRows=db.viewProduct();
                    if(SelectedRows!=null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("SelectedRows",SelectedRows); 
                    RequestDispatcher rd = request.getRequestDispatcher("updateproductquantity.jsp");
                    rd.forward(request, response);
                    }
            }
            else if(request.getParameter("select").equalsIgnoreCase("Price")==true) {
                    DataAccess db=new DataAccess();
                    List<Products> SelectedRows=db.viewProduct();
                    if(SelectedRows!=null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("SelectedRows",SelectedRows); 
                    RequestDispatcher rd = request.getRequestDispatcher("updateproductprice.jsp");
                    rd.forward(request, response);
                    }
            else if(request.getParameter("select").equalsIgnoreCase("SeacrhC")==true)   {
                    
                    RequestDispatcher rd = request.getRequestDispatcher("SerachProduct.jsp");
                     rd.forward(request, response);
                    }
            }
            
            else if(request.getParameter("select").equalsIgnoreCase("Report")==true)   {
                    RequestDispatcher rd = request.getRequestDispatcher("searchpurchase.jsp");
                     rd.forward(request, response);
            }
            else if(request.getParameter("select").equalsIgnoreCase("ProductTable")==true){
                    DataAccess db1=new DataAccess();
                    List<Products> SelectedRows1=db1.viewProduct();
                    if(SelectedRows1!=null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("SelectedRows",SelectedRows1);
                    RequestDispatcher rd = request.getRequestDispatcher("ShowStatement.jsp");
                    rd.forward(request,response);
                }
                 else {
                       HttpSession session = request.getSession();
                       RequestDispatcher rd = request.getRequestDispatcher("SerachProduct.jsp");
                       rd.forward(request, response);
                 }
            }
        
       /*
        int productId = Integer.parseInt(request.getParameter("Product"));
        String CATEGORY = request.getParameter("CATEGORY");
        int PRICE = Integer.parseInt(request.getParameter("PRICE"));
        String PRODUCT_NAME = request.getParameter("PRODUCT_NAME");
        int Quantity=Integer.parseInt(request.getParameter("Quantity"));
        DataAccess db = new DataAccess();
        int count = db.createAccount(productId,CATEGORY, PRICE, PRODUCT_NAME,Quantity);
        if(count==1)
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
            rd.forward(request, response); 
        }
        */
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
