/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.models.Failed;
import my.services.Users;
import my.services.UsersService;

/**
 *
 * @author mishr
 */
@WebServlet(name = "RegisterControllerServlet", urlPatterns = {"/RegisterControllerServlet"})
public class RegisterControllerServlet extends HttpServlet {

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
        String result = "failed";
        boolean flagemail = true;
        boolean flagphone = true;
        String uname;
        String pswd;
        String phoneNumber;
        String emailAddress;
        String user;
        Failed fail = new Failed();
        fail.email = "";
        fail.name = "";
        fail.password = "";
        fail.phonenumber = "";
        fail.username = "";

        if (!request.getParameter("username").trim().isEmpty() && !request.getParameter("password").trim().isEmpty() && !request.getParameter("email").trim().isEmpty() && !request.getParameter("phone").trim().isEmpty() && !request.getParameter("name").trim().isEmpty()) {
            uname = request.getParameter("username").trim();
            pswd = request.getParameter("password").trim();
            phoneNumber = request.getParameter("phone").trim();
            emailAddress = request.getParameter("email").trim();
            user = request.getParameter("name").trim();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            String phoneRegex = "^\\d{10}$";

            if (!emailAddress.matches(regex)) {
                fail.email = "incorrect";
                flagemail = false;
            }
            if (!phoneNumber.matches(phoneRegex)) {
                fail.phonenumber = "incorrect";
                flagphone = false;
            }
            if (flagemail && flagphone) {
                UsersService usersService = new UsersService();
                Users port = usersService.getUsersPort();
                result = port.register(uname, pswd, phoneNumber, emailAddress, user);

            }

            System.out.println(uname + " " + pswd + " " + phoneNumber + " " + emailAddress + " " + user + " " + result);

        }

        if (request.getParameter("username").trim().isEmpty()) {
            fail.username = "empty";
        }
        if (request.getParameter("password").trim().isEmpty()) {
            fail.password = "empty";
        }
        if (request.getParameter("email").trim().isEmpty()) {
            fail.email = "empty";
        }
        if (request.getParameter("phone").trim().isEmpty()) {
            fail.phonenumber = "empty";
        }
        if (request.getParameter("name").trim().isEmpty()) {
            fail.name = "empty";
        }

        if (result.equalsIgnoreCase("success")) {

            String url = "/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        }

        if (result.equalsIgnoreCase("failed")) {

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
