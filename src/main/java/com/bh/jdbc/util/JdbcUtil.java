package com.bh.jdbc.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    //获取连接
    static Connection connection = null;
    static Properties p = new Properties();
    //数据源
    private static DataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");
    //定义连接数据库的参数
    private static String Driver;
    private static String URL;
    private static String UserName;
    private static String PassWord;

    //创建静态代码块读取配置文件
    //当类加载的时候去读取文件
    static {

        //加载配置文件
        try {
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
//            p.load(new FileInputStream("src/main/resources/db.properties"));
            p.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取文件key的值并赋值
        Driver = p.getProperty("driver");
        UserName = p.getProperty("username");
        URL = p.getProperty("url");
        PassWord = p.getProperty("password");
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection1() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        //加载驱动
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
        }


        try {
            connection = DriverManager.getConnection(URL, UserName, PassWord);
        } catch (SQLException throwables) {
            System.out.println("获取数据库连接失败");
        }

        // 关闭连接
        if (connection != null) {
            return connection;
        } else {
            return null;
        }
    }

    public static void close(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
