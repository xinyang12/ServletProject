package com.xinyang.dao;



import com.xinyang.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by car on 2016/12/1.
 */
public class UserDao {

    /**
     * 注册用户
     *
     * by xinyang
     */
    public void register(String username, String password) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();

        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
            String sql = "INSERT INTO USER (USERNAME, PASSWORD) VALUES (?, MD5(?))";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }
    }

    /**
     * 判断用户名是否存在
     *
     * by xinyang
     */
    public boolean ifUserExists(String username, String password) {
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT USERNAME FROM USER WHERE USERNAME=? AND PASSWORD=MD5(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(conn);
        }

        return false;
    }

}
