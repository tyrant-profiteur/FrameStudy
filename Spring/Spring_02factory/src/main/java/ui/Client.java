package ui;

import factory.BeanFactory;
import service.IAccountService;
import service.Impl.AccountServiceImpl;

/**
 * 模拟表现层，调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //阶段1.和AccountServiceImpl类强耦合，如果没有这个类，就会编译错误
        //IAccountService as = new AccountServiceImpl();
        //阶段2.使用反射的方法创建
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.save();
        }
    }
}
