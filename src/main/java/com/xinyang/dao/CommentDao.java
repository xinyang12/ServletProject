package com.xinyang.dao;

import com.xinyang.pojo.Comment;
import com.xinyang.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by car on 2016/12/14.
 */
public class CommentDao {
    /**
     * 添加评论
     *
     * by xinyang
     */
    public void addComment(Comment comment) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO COMMENT(TITLE, CONTENT, ARTICLEID) VALUES (?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, comment.getTitle());
            ps.setString(2, comment.getContent());
            ps.setInt(3,comment.getArticleId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }
    }
}
