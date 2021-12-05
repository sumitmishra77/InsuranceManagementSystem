/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.controllers;

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
import my.models.Failed;
import my.services.Product;
import my.services.Products;
import my.services.ProductsService;
import my.services.Users;
import my.services.UsersService;

/**
 *
 * @author mishr
 */
@WebServlet(name = "LoginControllerServlet", urlPatterns = {"/LoginControllerServlet"})
public class LoginControllerServlet extends HttpServlet {

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
        Failed fail = new Failed();
        String name = "invalid";
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (!request.getParameter("username").trim().isEmpty() && !request.getParameter("password").trim().isEmpty()) {
            UsersService usersService = new UsersService();
            Users uPort = usersService.getUsersPort();

            name = uPort.authenticate(request.getParameter("username"), request.getParameter("password"));

        }
        if (!(name.equalsIgnoreCase("invalid"))) {
            String url = "/productregistration.jsp";
            ProductsService pService = new ProductsService();
            Products pPort = pService.getProductsPort();
            List<Product> list = pPort.getAllProduct();
            request.setAttribute("availableProducts", list);
            // request.setAttribute("user", name);
            session.setAttribute("user", name);

            if (name.equalsIgnoreCase("ABCadmin")) {
                url = "/admin_users.jsp";

                //  request.setAttribute("user",name);
            }
            // url = "/productregistration.jsp";

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        }

        if (name.equalsIgnoreCase("invalid")) {
            fail.username = "invalid";
            fail.password = "invalid";
            fail.email = "";
            fail.name = "";
            fail.phonenumber = "";
            request.setAttribute("failures", fail);
            String url = "/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(url);
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
