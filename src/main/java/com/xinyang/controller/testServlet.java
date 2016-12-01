package com.xinyang.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by car on 2016/12/1.
 */
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

//        PrintWriter out = response.getWriter();
//        out.println("sdfdf");
//
////        RequestDispatcher view = request.getRequestDispatcher("/deal.jsp");
////        view.forward(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        request.setAttribute("username", username);
//        request.setAttribute("password", password);
//
//        RequestDispatcher view = request.getRequestDispatcher()
        PrintWriter out = response.getWriter();
        out.println("The username is " + username);
        out.println("The password is " + password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}