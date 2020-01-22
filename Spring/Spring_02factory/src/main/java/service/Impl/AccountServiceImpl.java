package service.Impl;

import dao.Impl.AccountDaoImpl;
import dao.IAccountDao;
import factory.BeanFactory;
import service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //1.new 创建，耦合度过高
    //private IAccountDao accountDao = new AccountDaoImpl();
    //2.改造为使用Class反射创建
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    //3.多例实验
    private int i =1;
    public void save() {
        accountDao.saveAccount();

        System.out.println(i);
        i++;
    }
}
