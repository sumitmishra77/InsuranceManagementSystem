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
import my.services.Product;
import my.services.Products;
import my.services.ProductsService;
import my.services.RegisteredProduct;

/**
 *
 * @author mishr
 */
@WebServlet(name = "ProductRegistrationControllerServlet", urlPatterns = {"/ProductRegistrationControllerServlet"})
public class ProductRegistrationControllerServlet extends HttpServlet {

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
        ProductsService pService = new ProductsService();
        Products pPort = pService.getProductsPort();
        List<Product> productsList = pPort.getAllProduct();

        boolean serialNumberExists = false;
        boolean serialNumberRegistered = false;
        String error = null;
        if (request.getParameter("username") == null && request.getParameter("productname") == null
                && request.getParameter("serialno") == null && request.getParameter("date") == null) {

            request.setAttribute("availableProducts", productsList);

            String url = "/productregistration.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } else {

            String regex = "[0-9]{1,2}(-)[0-9]{1,2}(-)[0-9]{2}";

            if ((request.getParameter("date").trim().matches(regex))) {

                if (!request.getParameter("username").trim().isEmpty() && request.getParameter("productname") != null
                        && !request.getParameter("serialno").trim().isEmpty() && !request.getParameter("date").trim().isEmpty()) {
                    String serialNumber = request.getParameter("serialno").trim();
                    String productName = request.getParameter("productname").trim();

                    one:
                    for (Product p : productsList) {
                        if (serialNumber.equalsIgnoreCase(p.getSerialNumber()) && productName.equalsIgnoreCase(p.getProductName())) {
                            serialNumberExists = true;
                            break one;
                        }

                    }
                    if (serialNumberExists) {
                        List<RegisteredProduct> registeredProduct = pPort.getAllRegisteredProduct();
                        two:
                        for (RegisteredProduct rP : registeredProduct) {
                            if (serialNumber.equalsIgnoreCase(rP.getSerialNumber())) {
                                serialNumberRegistered = true;
                                break two;
                            }
                        }
                    }

                    if (!serialNumberRegistered && serialNumberExists) {

                        RegisteredProduct rP = new RegisteredProduct();
                        rP.setUserName(request.getParameter("username").trim());
                        rP.setProductName(request.getParameter("productname").trim());
                        rP.setSerialNumber(request.getParameter("serialno").trim());
                        rP.setPurchaseDate(request.getParameter("date").trim());

                        pPort.registerProduct(rP);
                    }

                }
            }

            if (!serialNumberExists) {
                error = "Serial Number Invalid";

            }

            if (serialNumberRegistered) {
                error = "Serial Number Already Registered";

            }

            if (!request.getParameter("date").trim().matches(regex)) {
                error = "Incorrect Date Format";
            }

            request.setAttribute("availableProducts", productsList);
            request.setAttribute("error", error);
            String url = "/productregistration.jsp";
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
