//package com.bh.jdbc.test;
//
//
//
//
//import com.mysql.cj.jdbc.ConnectionWrapper;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class YTFConnection extends ConnectionWrapper {
//    private YTFPool pool;
//
//    public YTFConnection(Connection con, YTFPool pool) {
//        super(con);
//        this.pool = pool;
//    }
//
//    @Override
//    public void close() throws SQLException {
//        pool.add(this);
//        System.out.println("归还");
//    }
//}