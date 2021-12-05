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
import my.models.Claim;
import my.models.Product;

/**
 *
 * @author mishr
 */
@WebService
public class Claims {

    @WebMethod

    public String addClaim(Claim c) {
        int i = 0;
        String result = "failure";

        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("insert into claims (username,claimdate,description,serialnumber,productname,status)"
                    + "values(?,?,?,?,?,?)");
            pstmt.setString(1, c.getUserName());
            pstmt.setString(2, c.getClaimDate());
            pstmt.setString(3, c.getDescription());
            pstmt.setString(4, c.getSerialNumber());
            pstmt.setString(5, c.getProductName());
            pstmt.setString(6, "Pending");
            i = pstmt.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            result = "success";
        }
        return result;
    }

    @WebMethod
    public boolean canClaim(String serialNumber) {
        int i = 1;
        boolean claim = false;
        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("select * from  claims where status='Approved' and serialnumber=?");

            pstmt.setString(1, serialNumber);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                i++;
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i < 4) {
            claim = true;
        }

        return claim;
    }

    @WebMethod
    public int approvedClaimCount(String serialNumber) {
        int approvedClaims = 0;

        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("select * from  claims where status='Approved' and serialnumber=?");

            pstmt.setString(1, serialNumber);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                approvedClaims++;
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }

        return approvedClaims;
    }

    @WebMethod
    public String updateStatus(String id, String status) {
        int i = 0;
        String result = "failure";

        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("update  claims set status =? where  id=?");
            pstmt.setString(1, status);
            pstmt.setString(2, id);

            i = pstmt.executeUpdate();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (i > 0) {
            result = "success";
        }
        return result;
    }

    @WebMethod
    public List<Claim> getClaim(String serialNumber) {
        int i = 0;
        List<Claim> claimList = new ArrayList<>();

        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("select * from  claims where  serialnumber=?");

            pstmt.setString(1, serialNumber);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Claim c = new Claim();
                c.setProductName(rs.getString("productname"));
                c.setClaimDate(rs.getString("claimdate"));
                c.setDescription(rs.getString("description"));
                c.setSerialNumber(rs.getString("serialnumber"));
                c.setStatus(rs.getString("status"));
                claimList.add(c);
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }

        return claimList;
    }

    @WebMethod
    public List<Claim> getAllClaim() {
        int i = 0;
        List<Claim> claimList = new ArrayList<>();

        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("select * from  claims ");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Claim c = new Claim();
                c.setId(rs.getInt("id"));
                c.setUserName(rs.getString("username"));
                c.setProductName(rs.getString("productname"));
                c.setClaimDate(rs.getString("claimdate"));
                c.setDescription(rs.getString("description"));
                c.setSerialNumber(rs.getString("serialnumber"));
                c.setStatus(rs.getString("status"));
                claimList.add(c);
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }

        return claimList;
    }

    public Claim getClaimByID(String id) {
        int i = 0;
        Claim claim = new Claim();

        try {
            Connection con = getConnection();

            PreparedStatement pstmt = con.prepareStatement("select * from  claims  where id=?");

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                claim.setId(rs.getInt("id"));
                claim.setUserName(rs.getString("username"));
                claim.setProductName(rs.getString("productname"));
                claim.setClaimDate(rs.getString("claimdate"));
                claim.setDescription(rs.getString("description"));
                claim.setSerialNumber(rs.getString("serialnumber"));
                claim.setStatus(rs.getString("status"));

            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }

        return claim;
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
            Logger.getLogger(Claims.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
