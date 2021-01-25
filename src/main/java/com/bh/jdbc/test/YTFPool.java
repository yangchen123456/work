//package com.bh.jdbc.test;
//
//import javax.sql.DataSource;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
//public abstract class YTFPool implements DataSource {
//    private static Properties props = new Properties();
//    private List<Connection> list = new ArrayList<Connection>();
//
//    static {
//        try {
//            props.load(new FileInputStream("src/main/resources/db.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            Class.forName(props.getProperty("driver"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//
//    public YTFPool() throws SQLException {
//        for (int i = 0; i < 5; i++) {
//            Connection con = DriverManager.getConnection(
//                    props.getProperty("url"), props.getProperty("username"),
//                    props.getProperty("password"));
//            YTFConnection conWapper = new YTFConnection(con, this);
//            list.add(conWapper);
//        }
//    }
//
//    public void add(Connection con) {
//        list.add(con);
//    }
//
//    public Connection getConnection() throws SQLException {
//        if (list.size() > 0) {
//            return list.remove(0);
//        }
//        throw new SQLException("没连接了");
//    }
//}
