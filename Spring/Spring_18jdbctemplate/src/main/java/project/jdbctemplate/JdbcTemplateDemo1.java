package project.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author:profiteur
 * @create 2020-02-17 10:49
 * @description JdbcTemplate最基本用法
 **/
public class JdbcTemplateDemo1 {
    public static void main(String[] args){
        //准备数据源，Spring内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/heima_springstudy");
        ds.setUsername("root");
        ds.setPassword("123456");
        //1.创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //设置数据源
        jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert into account(name,money) values('ddd',1000)");
     }
}
