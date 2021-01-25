package com.bh.jdbc.test;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCP {
    //定义连接数据库的参数
    private static String Driver;
    private static String URL;
    private static String UserName;
    private static String PassWord;
    //获取连接
    static Connection connection = null;

    static Properties p = new Properties();

    //创建静态代码块读取配置文件
    //当类加载的时候去读取文件
    static {
        //加载配置文件
        try {
            p.load(new FileInputStream("src/main/resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取文件key的值并赋值
        Driver = p.getProperty("driver");
        UserName = p.getProperty("username");
        URL = p.getProperty("url");
        PassWord = p.getProperty("password");
    }
    public static Connection  getConnection(){
        //创建对象
        BasicDataSource ds = new BasicDataSource();
        //设置四大参数
        ds.setUsername(p.getProperty("username"));
        ds.setPassword(p.getProperty("password"));
        ds.setUrl(p.getProperty("url"));
        ds.setDriverClassName(p.getProperty("driver"));
        //设置初始化
        ds.setMaxIdle(10);
        ds.setInitialSize(10);
        ds.setMinIdle(2);
        Connection con = null;
        try {
            //获取connection对象
            con = ds.getConnection();
            System.out.println(con);
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}

