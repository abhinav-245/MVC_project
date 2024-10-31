package com.mvc.controller;

import com.mvc.service.WebSeriesService;
import com.mvc.model.User;
import com.mvc.model.WebSeries;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/webseries")
public class WebSeriesServlet extends HttpServlet 
{    
    private WebSeriesService webSeriesService;
    public void init() 
    {
        webSeriesService = new WebSeriesService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) 
        {
            List<WebSeries> webSeriesList = webSeriesService.selectAllWebSeriesByUser(user.getId());
            request.setAttribute("webSeriesList", webSeriesList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("webseries.jsp");
            dispatcher.forward(request, response);
        } 
        else 
        {
            response.sendRedirect("login.jsp");
        }
    }
}
