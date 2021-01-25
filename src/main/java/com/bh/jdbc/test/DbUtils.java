package com.bh.jdbc.test;


import com.bh.jdbc.pojo.Student;
import com.bh.jdbc.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtils {
    /**
     * 测试修改
     */
    @Test
    public void testUpdate() {
        //创建对象
        QueryRunner queryRunner = new QueryRunner();
        //初始化connection
        Connection connection = null;

        try {
            //获取connection对象
            connection = TestC3P0.getconnection1();
        } catch (PropertyVetoException e) {
            System.out.println("获取连接失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //编写sql语句
        String sql = "update branch set branch_name = ? where id = ?";
        try {
            //执行sql
            int i = queryRunner.update(connection, sql, "石家庄", "1");
            System.out.println(i);
        } catch (SQLException throwables) {
            System.out.println("执行sql语句失败");
        }
        //关闭资源
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            System.out.println("关闭connection失败");
        }
    }

    /**
     * 测试查询
     * 多行处理器！把结果集转换成 List<Map<String,Object>>
     */
    @Test
    public void testQuery() {
        //获取数据源
        DataSource ds = JdbcUtil.getDataSource();
        //获取对象
        QueryRunner queryRunner = new QueryRunner(ds);

        //创建sql语句
        String sql = "select * from branch";

        //执行语句
        try {
            List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler());
            for (Map<String, Object> map : list) {
                System.out.println(map);
            }
        } catch (SQLException throwables) {
            System.out.println("执行语句失败");
        }
    }


    /**
     * 测试查询一个
     * 单行处理器！把结果集转换成 Bean，该处理器需要 Class 参数，即 Bean 的类
     * 型；
     */
    @Test
    public void testQuery2() {
        //获取数据源
        DataSource ds = JdbcUtil.getDataSource();
        //生成QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        //编写sql语句
        String sql = "select * from branch where id=?";
        //执行sql语句
        Student stu = null;
        try {
            stu = qr.query(sql, new BeanHandler<Student>(Student.class),
                    "1");
        } catch (SQLException throwables) {
            System.out.println("执行sql语句失败");
        }
        System.out.println(stu);
    }

    /**
     * MapHandler：单行处理器！把结果集转换成 Map<String,Object>，其中列名为键！
     */
    @Test
    public void testQuery3() {
        //获取数据源
        DataSource ds = JdbcUtil.getDataSource();
        //生成QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        //编写sql语句
        String sql = "select * from branch where id=?";
        //执行sql语句
        Map<String,Object> map = null;
        try {
            map = qr.query(sql, new MapHandler(), "1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //打印数据
        System.out.println(map);
    }

    /**
     * 测试查询多个用实体类接受
     *多行处理器！把结果集转换成 List<Bean>；
     */
    @Test
    public void testQuery4() {
        //获取数据源
        DataSource ds = JdbcUtil.getDataSource();
        //获取QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        //编写sql
        String sql = "select * from branch";
        //执行sql
        List<Student> list = null;
        try {
            list = qr.query(sql, new
                    BeanListHandler<Student>(Student.class));
        } catch (SQLException throwables) {
            System.out.println("执行sql失败");
        }
        //for循环打印数据
        for (Student stu : list) {
            System.out.println(stu);
        }

    }

    /**
     * 测试查询多行单列
     * ColumnListHandler：多行单列处理器！把结果集转换成 List<Object>，使用 ColumnListHandler
     * 时需要指定某一列的名称或编号，例如：new ColumListHandler(“name”)表示把 name 列的数
     * 据放到 List 中。
     */
    @Test
    public void testQuery5() {
        //获取数据源
        DataSource ds = JdbcUtil.getDataSource();
        //获取QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        //编写sql
        String sql = "select * from branch ";
        //执行sql
        List<Object> list = null;
        try {
            list = (List<Object>) qr.query(sql, new ColumnListHandler("branch_name"));
        } catch (SQLException throwables) {
            System.out.println("执行sql语句失败");
        }
        //for循环打印数据
        for (Object s : list) {
            System.out.println(s);
        }
    }


    /**
     *
     *查询数据库一共几条数据
     * 单行单列处理器！把结果集转换成 Object。一般用于聚集查询，例如 select
     * count(*) from tab_student。
     */
    @Test
    public void testQuery6() {
        //获取数据源
        DataSource ds = JdbcUtil.getDataSource();
        //获取QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        //编写sql
        String sql = "select count(*) from branch";
        //执行sql
        Number number = null;
        try {
            number = (Number)qr.query(sql, new ScalarHandler());
        } catch (SQLException throwables) {
            System.out.println("执行sql失败");
        }
        //获取结果
        int cnt = number.intValue();
        System.out.println(cnt);
    }
}
