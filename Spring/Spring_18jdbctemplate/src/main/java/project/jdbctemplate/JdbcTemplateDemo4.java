package project.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import project.dao.IAccountDao;
import project.domain.Account;

import javax.annotation.Resource;

/**
 * @author:profiteur
 * @create 2020-02-17 10:49
 * @description JdbcTemplate最基本用法
 **/
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = (IAccountDao)ac.getBean("accountDao");
        //3.执行方法
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
}
