package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

/**
 * 模拟表现层，调用业务层
 */
public class Client {

    /**
     * @param args
     *
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象,两种方法
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.save();
        ac.close();
    }
}

