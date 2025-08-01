package com.example.pahanaeduonlinebillingsys.customer.dao;

import com.example.pahanaeduonlinebillingsys.Util.DBConnection;
import com.example.pahanaeduonlinebillingsys.customer.model.CustomerRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

    public boolean customerExists(int accno) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM customers WHERE accno = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, String.valueOf(accno));
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close(); ps.close(); conn.close();
        return exists;
    }

    public boolean insertCustomer(CustomerRegister customerRegister) throws Exception {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO customers (accno, fname, lname, address, mobileno) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, String.valueOf(customerRegister.getAccNo()));
        ps.setString(2, customerRegister.getFirstName());
        ps.setString(3, customerRegister.getLastName());
        ps.setString(4, customerRegister.getAddress());
        ps.setString(5, customerRegister.getMobileNo());

        int result = ps.executeUpdate();
        ps.close(); conn.close();
        return result > 0;
    }
}
