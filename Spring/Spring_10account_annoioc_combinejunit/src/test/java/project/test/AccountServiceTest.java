package project.test;

import config.JdbcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.SpringConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import project.domain.Account;
import project.service.IAccountService;

import java.util.List;

/**
 * @author:profiteur
 * @create 2020-02-08 16:04
 * 使用Junit测试配置文件
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //3.执行方法
        Account account = new Account();
        account.setMoney(2000f);
        account.setName("老王");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //3.执行方法
        Account account = new Account();
        account.setId(4);
        account.setMoney(4000F);
        account.setName("老王");
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        //3.执行方法
        as.deleteAccount(5);
    }
}
