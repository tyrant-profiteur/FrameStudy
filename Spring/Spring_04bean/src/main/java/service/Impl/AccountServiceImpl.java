package service.Impl;

import service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(){
        System.out.println("对象创建");
    }

    public void save() {
        System.out.println("save方法执行了");
    }

    public void init(){
        System.out.println("初始化");
    }

    public void destroy(){
        System.out.println("销毁");
    }
}
