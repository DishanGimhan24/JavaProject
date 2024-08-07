package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
    private static boolean isSuccess;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    // Validate a user's credentials
    public static List<Customer> validate(String userName, String password) {
        ArrayList<Customer> cus = new ArrayList<>();

        try {
            // Get a database connection
            con = DBConnect.getConnection();
            stmt = con.createStatement();

            // Build the SQL query to check if the provided username and password match
            String sql = "select * from customer where username = '" + userName + "' AND password = '" + password + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // If a match is found, create a Customer object and add it to the list
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String userU = rs.getString(5);
                String passU = rs.getString(6);

                Customer c = new Customer(id, name, email, phone, userU, passU);
                cus.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

    // Insert a new customer into the database
    public static boolean insertcustomer(String name, String email, String phone, String username, String password) {
        boolean isSuccess = false;

        try {
            // Get a database connection
            con = DBConnect.getConnection();
            stmt = con.createStatement();

            // Build the SQL query to insert a new customer
            String sql = "INSERT INTO customer (id, name, email, phone, username, password) " +
                    "VALUES (0, '" + name + "', '" + email + "', '" + phone + "', '" + username + "', '" + password + "')";
            int rs = stmt.executeUpdate(sql);

            isSuccess = (rs > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Update customer information
    public static boolean updatecustomer(String id, String name, String email, String phone, String username, String password) {
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "update customer set name='" + name + "', email='" + email + "', phone='" + phone + "', username='" + username + "', password='" + password + "'" + "where id='" + id + "'";

            int rs = stmt.executeUpdate(sql);

            if (rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Get customer details by ID
    public static List<Customer> getCustomerDetails(String Id) {
        int convertedID = Integer.parseInt(Id);

        ArrayList<Customer> cus = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "select * from customer where id='" + convertedID + "'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String username = rs.getString(5);
                String password = rs.getString(6);

                Customer c = new Customer(id, name, email, phone, username, password);
                cus.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cus;
    }

    // Delete a customer by ID
    public static boolean deleteCustomer(String id) {
        int convId = Integer.parseInt(id);
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "delete from customer  where id='" + convId + "'";
            int r = stmt.executeUpdate(sql);

            if (r > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
