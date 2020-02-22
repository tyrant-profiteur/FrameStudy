package project.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import project.domain.Account;
import project.factory.BeanFactory;
import project.service.IAccountService;
import project.service.impl.AccountServiceImpl;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessControlContext;
import java.util.List;

/**
 * @author:profiteur
 * @create 2020-02-08 16:04
 * 使用Junit测试配置文件
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Resource(name = "proxyAccountService")
    private IAccountService accountService;
    // private IAccountService accountService = new AccountServiceImpl();

    /*@Resource
     private BeanFactory beanFactory;
     IAccountService accountService = beanFactory.getAccountService();*/

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "bbb", 100f);
    }
}

