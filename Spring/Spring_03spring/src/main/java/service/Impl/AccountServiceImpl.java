package service.Impl;

import dao.IAccountDao;
import dao.Impl.AccountDaoImpl;
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
