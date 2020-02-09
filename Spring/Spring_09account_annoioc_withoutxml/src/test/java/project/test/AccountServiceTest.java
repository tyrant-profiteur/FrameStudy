package project.test;

import config.JdbcConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.SpringConfiguration;
import project.domain.Account;
import project.service.IAccountService;

import java.util.List;

/**
 * @author:profiteur
 * @create 2020-02-08 16:04
 * 使用Junit测试配置文件
 **/
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfig.class);
        //2.得到业务层对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        Account account = new Account();
        account.setMoney(2000f);
        account.setName("老王");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        Account account = new Account();
        account.setId(4);
        account.setMoney(4000F);
        account.setName("老王");
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //1.获取容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        as.deleteAccount(5);
    }
}
