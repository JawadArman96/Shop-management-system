/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;
import database.DataAccess;
import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.taglibs.standard.tag.common.core.OutSupport.out;
import static sun.misc.MessageUtils.out;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "SerachPurchase", urlPatterns = {"/SerachPurchase.do"})
public class SerachPurchase extends HttpServlet {

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
        String first_date=request.getParameter("first_date");
        String second_date=request.getParameter("second_date");
        DataAccess db=new DataAccess();
        List<Purchase> SelectedRows=db.searchpurchase(first_date,second_date);
        int i=0;
        for(Purchase x: SelectedRows) {
            SelectedRows.get(i).purchaseName=db.getProductName(x.productId);
            i++;
        }
        int amount= db.getamount(first_date,second_date);
        if(SelectedRows!=null) {
        HttpSession session = request.getSession();
        session.setAttribute("SelectedRows",SelectedRows);
        session.setAttribute("amount",amount);
        RequestDispatcher rd = request.getRequestDispatcher("ShowStatement_1.jsp");
        rd.forward(request,response);
        }
        else {
            HttpSession session = request.getSession();
            RequestDispatcher rd = request.getRequestDispatcher("searchpurchase.jsp");
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
