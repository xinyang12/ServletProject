package com.xinyang.controller;

import com.xinyang.dao.ArticleDao;
import com.xinyang.pojo.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by car on 2016/12/14.
 */
public class SearchArtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();
        String title = request.getParameter("title");
        List<Article> list = articleDao.searchArticle(title);

        request.setAttribute("list", list);
        request.setAttribute("title", title);

        request.getRequestDispatcher("view/mainPage.jsp").forward(request, response);
    }
}
