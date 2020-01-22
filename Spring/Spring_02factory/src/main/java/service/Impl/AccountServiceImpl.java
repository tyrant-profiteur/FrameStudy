package service.Impl;

import dao.AccountDaoImpl;
import dao.IAccountDao;
import service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    public void save() {
        accountDao.saveAccount();
    }
}
