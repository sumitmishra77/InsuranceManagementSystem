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
import javax.jws.WebParam;
import javax.jws.WebService;
import my.models.User;

/**
 *
 * @author mishr
 */
@WebService
public class Users {

    @WebMethod
    public String register(@WebParam(name = "UserName") String username, @WebParam(name = "Password") String password,
            @WebParam(name = "PhoneNumber") String cellphone, @WebParam(name = "Email") String email, @WebParam(name = "User") String name) {
        int i = 0;
        String value = "failed";
        try {

            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("insert into users (username,password,cellphone,email,name)"
                    + "values(?,?,?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, cellphone);
            pstmt.setString(4, email);
            pstmt.setString(5, name);
            i = pstmt.executeUpdate();

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i == 1) {
            value = "success";
        }

        return value;
    }

    @WebMethod
    public String authenticate(@WebParam(name = "UserName") String username, @WebParam(name = "Password") String password) {
        String name = "invalid";
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement("Select * from users where username=? and password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equalsIgnoreCase(username)) {
                    name = rs.getString("name");

                }
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }

    @WebMethod
    public List<User> getUsers(@WebParam(name = "Users") String username) {
        List<User> userList = new ArrayList();
        try {
            Connection con = getConnection();
            ResultSet rs;
            PreparedStatement pstmt;

            if (username.equals("empty")) {
                pstmt = con.prepareStatement("Select * from users ");
            } else {
                // pstmt= con.prepareStatement("Select * from users where username=?" );
                pstmt = con.prepareStatement("Select * from users where username like ? ");
                pstmt.setString(1, "%" + username + "%");

            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setCellphone(rs.getString("cellphone"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
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
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
