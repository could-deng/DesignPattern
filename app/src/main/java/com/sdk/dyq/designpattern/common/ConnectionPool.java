package com.sdk.dyq.designpattern.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 享元模式
 * 目的是实现对象的共享，即共享池
 * 运用：jdbc，数据库连接池
 * 通过连接池的管理，实现了数据库连接的共享，不需要每一次都重新创建连接，节省了数据库重新创建的开销，提升了系统的性能！
 */

public class ConnectionPool {
    private Vector<Connection> pool;
    /*公有属性*/
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "root";
    private String driverClassName = "com.mysql.jdbc.Driver";

    private int poolSize = 100;
    private static ConnectionPool instance = null;

    Connection con = null;

    /**
     * 构造，做初始化
     */
    private ConnectionPool(){
        pool = new Vector<>(poolSize);
        for(int i =0;i<poolSize;i++){
            try {
                Class.forName(driverClassName);
                con = DriverManager.getConnection(url,username,password);
                pool.add(con);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /* 返回连接到连接池 */
    public synchronized void release() {
        pool.add(con);
    }

    /* 返回连接池中的一个数据库连接 */
    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        } else {
            return null;
        }
    }

}
