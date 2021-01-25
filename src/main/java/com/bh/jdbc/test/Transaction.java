package com.bh.jdbc.test;

import com.bh.jdbc.util.JdbcUtil;
import org.junit.Test;

import java.sql.*;

public class Transaction {
    public static void main(String[] args) {
        //调用test方法传入true则抛出异常，执行事务回滚
        //传入false,则不抛出异常不执行事务回滚
        test(true);

    }

    /**
     * 测试事务的回滚
     * @param b
     */
    public static void test(boolean b) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.getConnection();
            //手动提交
            con.setAutoCommit(false);
            String sql = "update account set balance=balance+? where id=?";
            pstmt = con.prepareStatement(sql);
            //操作
            pstmt.setDouble(1, -10000);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
            // 在两个操作中抛出异常
            if (b) {
                throw new Exception();
            }
            pstmt.setDouble(1, 10000);
            pstmt.setInt(2, 2);
            pstmt.executeUpdate();
            //提交事务
            con.commit();
        } catch (Exception e) {
            //回滚事务
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new RuntimeException(e);
        } finally {
            //关闭
            JdbcUtil.close(con, pstmt);
        }

    }


    /**
     * 测试设置保存点  当发现错误的时候调用事务回滚
     */
    @Test
    public void test2() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            //调用方法获取对象
            con = JdbcUtil.getConnection();
            //手动提交
            con.setAutoCommit(false);
            String sql = "update account set balance=balance+? where name=?";
            pstmt = con.prepareStatement(sql);
            //操作1（张三减去1W）
            pstmt.setDouble(1, -10000);
            pstmt.setString(2, "zs");
            pstmt.executeUpdate();
            //操作2（李四加上1W）
            pstmt.setDouble(1, 10000);
            pstmt.setString(2, "ls");
            pstmt.executeUpdate();
            // 设置保存点  当发现错误的时候调用事务回滚
            // con.rollback(sp);
            Savepoint sp = con.setSavepoint();
            //操作3（李四减去100W）
            pstmt.setDouble(1, -1000000);
            pstmt.setString(2, "ls");
            pstmt.executeUpdate();
            //操作4（张三加上100W）
            pstmt.setDouble(1, 1000000);
            pstmt.setString(2, "zs");
            pstmt.executeUpdate();
            //操作5（查看李四余额）
            sql = "select balance from account where name=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "ls");
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            double balance = rs.getDouble(1);
            //如果李四余额为负数，那么回滚到指定保存点
            if (balance < 0) {
                con.rollback(sp);
                System.out.println("张三，你上当了！");
            }
            //提交事务
            con.commit();
        } catch (Exception e) {
            //回滚事务
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                }
            }
            throw new RuntimeException(e);
        } finally {
            //关闭
            JdbcUtil.close(con, pstmt);
        }
    }
}

