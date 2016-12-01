package com.xinyang.dao;

import com.xinyang.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        }

        dbUtil.closeConnection(conn);
    }

}
