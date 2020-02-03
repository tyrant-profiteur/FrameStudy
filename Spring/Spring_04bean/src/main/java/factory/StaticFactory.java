package factory;

import service.IAccountService;
import service.Impl.AccountServiceImpl;

/**
 * @author:profiteur
 * @create 2020-01-31 18:35
 * 模拟工厂，无法通过修改源码的方式来提供默认构造函数
 **/
public class StaticFactory {
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
