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
 * 文章增删改查操作
 */
public class ArticleDao {


    /**
     * 添加文章
     *
     * by xinyang
     */
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

    /**
     * 删除文章
     *
     * by xinyang
     */
    public void deleteArticle(Integer id) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();

        try {

            String sql = "DELETE FROM ARTICLE WHERE ID=?";
            PreparedStatement ps = null;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }

    }


    /**
     * 提取所有文章
     *
     * by xinyang
     */
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
