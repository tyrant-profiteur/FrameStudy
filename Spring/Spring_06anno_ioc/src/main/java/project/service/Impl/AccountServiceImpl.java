package project.service.Impl;

import org.springframework.beans.factory.annotation.Qualifier;
import project.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.service.IAccountService;

import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name="accountDao1")
    private IAccountDao accountDao;

    /*public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }*/

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void save() {
        accountDao.saveAccount();
    }
}
