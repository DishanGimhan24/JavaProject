package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the request
        String id = request.getParameter("cusid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");

        boolean isTrue;
        
        // Call the updatecustomer method to update customer information
        isTrue = CustomerDBUtil.updatecustomer(id, name, email, phone, username, password);

        if (isTrue) {
            // If the update was successful, retrieve the updated customer details
            List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
            
            // Set the customer details as an attribute in the request
            request.setAttribute("cusDetails", cusDetails);
            
            // Forward the request to the useraccount.jsp page
            RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
            dis.forward(request, response);
        } else {
            // If the update was not successful, still retrieve the customer details
            List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
            request.setAttribute("cusDetails", cusDetails);
            
            // Forward the request to the useraccount.jsp page
            RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
            dis.forward(request, response);
        }
    }
}
