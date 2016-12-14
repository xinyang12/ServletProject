package com.xinyang.controller;

import com.xinyang.dao.ArticleDao;
import com.xinyang.pojo.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by car on 2016/12/14.
 */
public class ModifyArtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Article article = new Article(id, title, content);
        ArticleDao articleDao = new ArticleDao();
        articleDao.modifyArticle(article);

        response.sendRedirect("getAllArticle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticleById(id);
        request.setAttribute("article", article);

        request.getRequestDispatcher("view/addArticle.jsp").forward(request, response);
    }
}
