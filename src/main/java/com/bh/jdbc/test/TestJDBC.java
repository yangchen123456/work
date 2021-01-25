package com.bh.jdbc.test;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 * 加载驱动
 * 获取连接
 * 生成发送器
 * 发送sql语句
 * 关闭数据库
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/branch")

public class TestJDBC {
    //定义静态变量
    private static Connection connection;

    //定义静态代码块，当类加载的时候就会调用数据库连接池返回连接对象
    static {
        try {
            connection = TestC3P0.getConnection();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("获取连接失败");
        }
    }

    /**
     * 查询数据
     *
     * @throws Exception
     */
    @Test
    public void test() {
        System.out.println(connection);
        //获取连接
        Statement statement = null;
        try {
            //通过connection创建statement对象
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            System.out.println("创建statement失败");
        }

        //发送sql语句
        String sql = "select * from branch";
        ResultSet rs = null;

        try {
            //获取结果集
            rs = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            System.out.println("获取结果失败");
        }

        //遍历结果集
        try {
            while (rs.next()) {
                int id = rs.getInt(1);//通过列编号来获取该列的值！
                String branchName = rs.getString("branch_name");//通过列名称来获取该列的值
                String location = rs.getString("location");//通过列名称来获取该列的值
                System.out.println(id + ", " + branchName + ", " + location);
            }
        } catch (SQLException e) {
            System.out.println("解析结果集失败");
        }

        //关闭资源
        TestC3P0.close(connection, statement, rs);

    }

    /**
     * 插入数据
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        //通过connection创建statement对象
        Statement stmt = connection.createStatement();
        //创建sql语句
        String sql = "INSERT INTO branch (branch_name,location)VALUES ( '上海科技', 'Beijing')";

        // 调用它的executeUpdate(String sql)
        int i = stmt.executeUpdate(sql);
        System.out.println(i);

        //关闭资源
        TestC3P0.close(connection, stmt);
    }


    /**
     * 删除和修改
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        //获取连接
        //Connection connection = JdbcUtil.getConnection();
        //通过数据库连接池获取连接
        /*
         * 二、对数据库做增、删、改
         * 1. 通过Connection对象创建Statement
         *     > Statement语句的发送器，它的功能就是向数据库发送sql语句！
         * 2. 调用它的int executeUpdate(String sql)，它可以发送DML、DDL
         */

        //1.通过Connection对象创建Statement
        Statement stmt = connection.createStatement();

        //创建sql语句
        String sql = "update branch set branch_name = '武汉' where id = 1 ";
        String sql2 = "delete from branch where id =4 ";

        //2. 调用它的int executeUpdate(String sql)，它可以发送DML、DDL
        int i1 = stmt.executeUpdate(sql2);
        System.out.println(i1);

        int i = stmt.executeUpdate(sql);
        System.out.println(i);

        //关闭资源
        TestC3P0.close(connection, stmt);
    }

    /**
     * 将mp3文件存入数据库
     */
    @Test
    public void test3() throws IOException {
        //封装目的地
        FileOutputStream fos = new FileOutputStream("丢了你.mp3");

        // 创建字节输入流对象
        InputStream fis = new FileInputStream("D:\\CloudMusic\\丢了你.mp3");

        //sql语句
        String sql = "insert into Mp3 (mp3) values(?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            //传递sql的值
            pstmt.setBinaryStream(1, fis);
            //执行sql
            pstmt.executeUpdate();
            //关闭资源
            TestC3P0.close(connection, pstmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        /**
         * 查询取出mp3
         */
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //发送sql语句
        String sql1 = "select mp3 from Mp3 where id=1 ";
        ResultSet rs = null;

        try {
            rs = statement.executeQuery(sql1);
        } catch (SQLException throwables) {
            System.out.println("获取结果失败");
        }

        //遍历结果集
        String SS = "";
        try {
            while (rs.next()) {
                SS = rs.getString(1);
            }
            //关闭
            TestC3P0.close(connection, statement, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将查询的数据封装到目的地文件中
        byte[] bytes1 = SS.getBytes();
        fos.write(bytes1, 0, bytes1.length);
    }

    /**
     * 将图片二进制存入数据库
     *
     * @throws IOException
     */
    @Test
    public void insertJpg() throws IOException {
        //封装目的地
        FileOutputStream fos = new FileOutputStream("1.jpg");
        // 创建字节输入流对象
        InputStream fis = new FileInputStream("C:\\txt\\1.jpg");

        //创建sql语句
        String sql = "insert into tab_bin(filename,data) values(?, ?)";
        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, "1.jpg");//插入数据
            psmt.setBinaryStream(2, fis);//插入数据
            int i = psmt.executeUpdate();//执行sql语句
            if (i == 1) {
                System.out.println("插入数据成功");
            }
            fis.close();
            //关闭
            TestC3P0.close(connection, psmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 获取数据库的图片
     *
     * @throws IOException
     */
    @Test
    public void getJpg() throws IOException {
        //获取连接
//        Connection conn = JdbcUtil.getConnection();
        //封装目的地
        FileOutputStream fos = new FileOutputStream("1.jpg");
        //创建对象
        PreparedStatement psmt = null;
        try {
            String sql = "select filename,data from tab_bin where id=?";
            psmt = connection.prepareStatement(sql);
            psmt.setInt(1, 2);
            //执行sql语句
            ResultSet rs = psmt.executeQuery();
            //获取二进制结果
            rs.next();
            InputStream is = rs.getBinaryStream("data");
            IOUtils.copy(is, fos);

            //关闭
            TestC3P0.close(connection, psmt);
            //关闭流
            fos.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
