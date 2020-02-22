package project.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:profiteur
 * @create 2020-02-10 14:30
 * 和事务相关的工具类，包含开启事务，提交事务，回滚事务和释放连接
 **/
@Component
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;
    /**
     * 开启事务
     */
    public void begin(){
        try {
            System.out.println("开启事务");
            Connection connection = connectionUtils.getThreadConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try {
            //不是真的关闭连接，而是把连接还回连接池中
            connectionUtils.getThreadConnection().close();
            //将线程和连接解绑
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
