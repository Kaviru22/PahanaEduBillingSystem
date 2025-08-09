package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerViewDAO {

    public CustomerRegister getCustomerByAccno(String accno) {
        CustomerRegister customerRegister = null;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE accno=?");
            ps.setString(1, accno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Customer found!");
                customerRegister = new CustomerRegister(
                        rs.getString("accno"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("address"),
                        rs.getString("mobileno")
                );
            }
         else {
            System.out.println("Customer not found in DB."); // 🔍 DEBUG
        }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerRegister;
    }


}
