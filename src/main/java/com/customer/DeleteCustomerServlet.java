package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the customer ID to be deleted from the request
        String id = request.getParameter("cusid");
        
        boolean isTrue;
        
        // Call the deleteCustomer method to delete the customer
        isTrue = CustomerDBUtil.deleteCustomer(id);
        
        if (isTrue) {
            // If the customer was successfully deleted, forward the request to the login.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            // If the deletion was not successful, retrieve the customer details
            List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
            
            // Set the customer details as an attribute in the request
            request.setAttribute("cusDetails", cusDetails);
            
            // Forward the request to the useraccount.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
            dispatcher.forward(request, response);
        }
    }
}
