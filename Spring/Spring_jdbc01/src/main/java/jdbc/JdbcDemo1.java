package jdbc;

import javax.xml.transform.Source;
import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Spring","root","root");
        //3.获取数据库预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行 SQL,得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name") + ":" + rs.getString("money"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
