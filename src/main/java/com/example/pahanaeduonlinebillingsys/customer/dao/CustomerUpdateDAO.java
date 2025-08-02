package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerUpdateDAO {

    public CustomerRegister getCustomerByAccNo(String accno) {
        CustomerRegister customerRegister = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE accno=?");
            ps.setString(1, accno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customerRegister = new CustomerRegister(
                        rs.getString("accno"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("address"),
                        rs.getString("mobileno")
                );
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerRegister;
    }

    public boolean isMobileNoExistsForOtherAccount(String mobileNo, String currentAccNo) {
        boolean exists = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT accno FROM customers WHERE mobileno = ? AND accno <> ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mobileNo);
            ps.setString(2, currentAccNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    public boolean updateCustomer(String originalAccno, CustomerRegister customerRegister) {
        boolean success = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE customers SET accno=?, fname=?, lname=?, address=?, mobileno=? WHERE accno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customerRegister.getAccNo());
            ps.setString(2, customerRegister.getFirstName());
            ps.setString(3, customerRegister.getLastName());
            ps.setString(4, customerRegister.getAddress());
            ps.setString(5, customerRegister.getMobileNo());
            ps.setString(6, originalAccno);

            int updated = ps.executeUpdate();
            success = updated > 0;

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
