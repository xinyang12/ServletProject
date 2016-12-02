package com.xinyang.controller;

import com.sun.deploy.nativesandbox.comm.Request;
import com.xinyang.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by car on 2016/12/1.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userDao.ifUserExists(username, password)) {
//            RequestDispatcher view = request.getRequestDispatcher("view/mainPage.jsp");
//            view.forward(request, response);
            response.sendRedirect("getAllArticle");
        } else {
            response.sendRedirect("view/errorPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
