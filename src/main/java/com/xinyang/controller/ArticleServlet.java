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
public class ArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticleById(id);
        request.setAttribute("article", article);

        // TODO 获取评论

        request.getRequestDispatcher("view/article.jsp").forward(request, response);
    }
}
