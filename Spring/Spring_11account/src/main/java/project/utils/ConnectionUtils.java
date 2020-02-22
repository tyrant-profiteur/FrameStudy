package project.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:profiteur
 * @create 2020-02-10 11:46
 * 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 **/
@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    //获取数据源
    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程的连接
     *
     * @return
     */
    public Connection getThreadConnection() {
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        //2.判断线程上是否有连接
        if (conn == null) {
            //3.从数据源中获取一个连接，并存入ThreadLocal中
            try {
                conn = dataSource.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        tl.remove();
    }
}
