package com.xinyang.dao;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseTraversers;
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
        try {
            String sql = "INSERT INTO ARTICLE (TITLE, CONTENT) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, content);

            ps.executeUpdate();

            ps.close();
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

            ps.close();
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

            rs.close();
            ps.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }

        return null;
    }

    /**
     * 搜索文章
     *
     * by xinyang
     */
    public List<Article> searchArticle(String title) {
        if (null == title) {
            return null;
        }

        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Article> list = new ArrayList<Article>();

        try {
            String sql = "SELECT ID, TITLE, CONTENT FROM ARTICLE WHERE TITLE LIKE '%" + title + "%'";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));

                list.add(article);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }

        return list;
    }

    /**
     * 根据id提取文章
     *
     * by xinyang
     */
    public Article getArticleById(int id) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = new Article();

        try {
            String sql = "SELECT ID, TITLE, CONTENT FROM ARTICLE WHERE ID = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            rs.next();
            article.setId(rs.getInt("id"));
            article.setTitle(rs.getString("title"));
            article.setContent(rs.getString("content"));

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }

        return article;
    }

    /**
     * 修改文章
     *
     * by xinyang
     */
    public void modifyArticle(Article article) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE ARTICLE SET TITLE = ?, CONTENT = ? WHERE ID = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }
    }

}
