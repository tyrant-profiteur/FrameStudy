package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.service.IAccountService;

/**
 * @author:profiteur
 * @create 2020-02-14 16:54
 * @description
 **/
public class AOPtest {
    public static void main(String[] args){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        accountService.saveAccount();
     }
}
