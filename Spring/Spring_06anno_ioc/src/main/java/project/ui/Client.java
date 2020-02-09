package project.ui;

import project.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.service.IAccountService;

/**
 * 模拟表现层，调用业务层
 */
public class Client {

    /**
     * 获取Spring的IoC核心容器，并根据id获取对象
     * @param args
     *
     * 读取配置文件，创建对象，存入Map的过程Spring帮我们完成了
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象,两种方法
        IAccountService as = (IAccountService) ac.getBean("accountService");
       System.out.println(as);
        System.out.println("-----------------");
        IAccountDao ad = (IAccountDao)ac.getBean("accountDao1");
        System.out.println(ad);
        as.save();
    }
}

