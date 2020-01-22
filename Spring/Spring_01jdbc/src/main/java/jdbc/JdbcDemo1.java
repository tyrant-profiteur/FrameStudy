package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author:profiteur
 * @create 2020-01-21 21:22
 * 程序的耦合：
 *  耦合：程序间的依赖关系
 *      类之间的依赖
 *      方法间的依赖
 *  解耦：
 *      降低程序间的依赖关系
 *  实际开发中：
 *      做到编译期不依赖，运行时才依赖
 **/
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","123456");
        //获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //得到结果集
        ResultSet rs = pstm.executeQuery();
        //遍历集合
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //关闭集合
        rs.close();
        pstm.close();
        conn.close();
     }
}
