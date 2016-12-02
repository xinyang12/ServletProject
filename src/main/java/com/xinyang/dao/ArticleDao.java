package com.xinyang.dao;

import com.xinyang.pojo.Article;
import com.xinyang.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by car on 2016/12/1.
 */
public class ArticleDao {

    public void addArticle(String title, String content) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();

        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
            String sql = "INSERT INTO ARTICLE (TITLE, CONTENT) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, content);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }
    }

    public List<Article> getAllArticle() {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Article> list = new ArrayList<Article>();
            String sql = "SELECT ID, TITLE, CONTENT FROM ARTICLE";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));

                list.add(article);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }

        return null;
    }

}
