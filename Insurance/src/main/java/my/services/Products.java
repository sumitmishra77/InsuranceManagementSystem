/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;
import my.models.Product;
import my.models.RegisteredProduct;

/**
 *
 * @author mishr
 */
@WebService
public class Products {

    @WebMethod
    public String addProduct(Product p) {
        int i = 0;
        String result = "failure";
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("insert into product (serialnumber,productname,color)"
                    + "values(?,?,?)");
            pstmt.setString(1, p.getSerialNumber());
            pstmt.setString(2, p.getProductName());
            pstmt.setString(3, p.getColor());

            i = pstmt.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            result = "exception";
        }
        if (i > 0) {
            result = "success";
        }
        return result;
    }

    @WebMethod
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from product ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("productname"));
                p.setSerialNumber(rs.getString("serialnumber"));
                p.setColor(rs.getString("color"));
                list.add(p);
            }

            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @WebMethod

    public String registerProduct(RegisteredProduct rP) {

        int i = 0;
        String result = "failure";
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("insert into productregistration (username,productname,serialnumber,purchasedate)"
                    + "values(?,?,?,?)");
            pstmt.setString(1, rP.getUserName());
            pstmt.setString(2, rP.getProductName());
            pstmt.setString(3, rP.getSerialNumber());
            pstmt.setString(4, rP.getPurchaseDate());
            i = pstmt.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            result = "success";
        }
        return result;

    }

    @WebMethod
    public List<RegisteredProduct> getAllRegisteredProduct() {
        List<RegisteredProduct> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from productregistration ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RegisteredProduct p = new RegisteredProduct();
                p.setUserName(rs.getString("username"));
                p.setProductName(rs.getString("productname"));
                p.setSerialNumber(rs.getString("serialnumber"));
                p.setPurchaseDate(rs.getString("purchasedate"));
                list.add(p);
            }

            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @WebMethod
    public List<RegisteredProduct> getRegisteredProduct(String username) {
        List<RegisteredProduct> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from productregistration where username like ? ");
            pstmt.setString(1, "%" + username + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RegisteredProduct p = new RegisteredProduct();
                p.setUserName(rs.getString("username"));
                p.setProductName(rs.getString("productname"));
                p.setSerialNumber(rs.getString("serialnumber"));
                p.setPurchaseDate(rs.getString("purchasedate"));
                list.add(p);
            }

            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @WebMethod
    public List<RegisteredProduct> getRegisteredProductByProductName(String productname) {
        List<RegisteredProduct> list = new ArrayList<>();

        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from productregistration where productname like ? ");
            pstmt.setString(1, "%" + productname + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                RegisteredProduct p = new RegisteredProduct();
                p.setUserName(rs.getString("username"));
                p.setProductName(rs.getString("productname"));
                p.setSerialNumber(rs.getString("serialnumber"));
                p.setPurchaseDate(rs.getString("purchasedate"));
                list.add(p);
            }

            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @WebMethod
    public RegisteredProduct getRegisteredProductBySerialNumner(String serialnumber) {
        List<RegisteredProduct> list = new ArrayList<>();
        RegisteredProduct registeredProduct = new RegisteredProduct();
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("select * from productregistration where serialnumber=? ");
            pstmt.setString(1, serialnumber);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                registeredProduct.setUserName(rs.getString("username"));
                registeredProduct.setProductName(rs.getString("productname"));
                registeredProduct.setSerialNumber(rs.getString("serialnumber"));
                registeredProduct.setPurchaseDate(rs.getString("purchasedate"));

            }

            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registeredProduct;

    }

    private Connection getConnection() {                     //?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false

        Connection con = null;
        System.out.println("Before loading Driver");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db_URL, db_Username, db_Password;
            db_URL = "jdbc:mysql://localhost:3306/insurance?zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";
            db_Username = "root";
            db_Password = "1234";
            con = DriverManager.getConnection(db_URL, db_Username, db_Password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
