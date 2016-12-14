package com.xinyang.controller;

import com.xinyang.dao.CommentDao;
import com.xinyang.pojo.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by car on 2016/12/14.
 */
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String commentTitle = request.getParameter("commentTitle");
        String commentContent = request.getParameter("commentContent");
        int articleId = Integer.valueOf(request.getParameter("articleId"));

        Comment comment = new Comment(commentTitle, commentContent, articleId);
        CommentDao commentDao = new CommentDao();
        commentDao.addComment(comment);

        response.sendRedirect("article");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
