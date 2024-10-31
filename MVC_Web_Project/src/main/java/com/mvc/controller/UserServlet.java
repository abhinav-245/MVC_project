package com.mvc.controller;

import com.mvc.service.UserService;
import com.mvc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet 
{
    private UserService userService;

    public void init() 
    {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
		try 
		{
			user = userService.validateUser(username, password);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}

        if (user != null) 
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("webseries");
        } 
        else 
        {
            request.setAttribute("errorMessage", "Invalid credentials");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
