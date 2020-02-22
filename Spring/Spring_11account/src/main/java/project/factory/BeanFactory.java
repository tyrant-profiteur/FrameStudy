package project.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import project.service.IAccountService;
import project.utils.TransactionManager;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:profiteur
 * @create 2020-02-14 11:08
 * @description
 **/
@Component
public class BeanFactory {
    @Resource(name = "accountService")
    private IAccountService accountService;
    @Resource
    private TransactionManager txManager;


    @Bean("proxyAccountService")
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("test".equals(method.getName())) {
                            return method.invoke(accountService, args);
                        }

                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.begin();
                            //2.执行操作
                            rtValue = method.invoke(accountService, args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
