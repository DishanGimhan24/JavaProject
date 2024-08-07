package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uid");
        String password = request.getParameter("pass");

        try {
            List<Customer> cusDetails = CustomerDBUtil.validate(username, password);

            if (cusDetails != null && !cusDetails.isEmpty()) {
                // User was found in the database; proceed to the user's account page
                request.setAttribute("cusDetails", cusDetails);
                RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
                dis.forward(request, response);
            } else {
                // User was not found in the database; show an error message
                String errorMessage = "Invalid username or password. Please try again.";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dis = request.getRequestDispatcher("login.jsp"); 
                dis.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
