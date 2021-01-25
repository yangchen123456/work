package com.bh.jdbc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.*;

public class TestC3P0 {
    /**
     * 配置文件配置数据源
     */
    private static Connection con;

    @Test
    public static Connection getConnection() throws PropertyVetoException, SQLException {
        //创建对象并读取文件
        ComboPooledDataSource ds = new ComboPooledDataSource("c3p0-config.xml");
        //获取connection对象
        con = ds.getConnection();
        System.out.println(con);
        //返回connection对象
        return con;
    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param statement
     * @param rs
     */
    public static void close(Connection conn, Statement statement, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            System.out.println("归还失败");
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                System.out.println("关闭statement失败");
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param statement
     */
    public static void close(Connection conn, Statement statement) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param pstmt
     */
    public static void close(Connection conn, PreparedStatement pstmt) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 原始方法配置数据库连接池
     *
     * @return
     * @throws PropertyVetoException
     * @throws SQLException
     */
    public void test() throws PropertyVetoException, SQLException {
        //创建ComboPooledDataSource对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/user?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
        ds.setUser("root");
        ds.setPassword("123456");
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        //每次增加数量
        ds.setAcquireIncrement(5);
        //初始化
        ds.setInitialPoolSize(20);
        //最小
        ds.setMinPoolSize(2);
        //最大连接数
        ds.setMaxPoolSize(50);
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();
    }
}
