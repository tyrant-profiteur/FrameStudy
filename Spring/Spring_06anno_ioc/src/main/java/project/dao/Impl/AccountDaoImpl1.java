package project.dao.Impl;

import org.springframework.stereotype.Repository;
import project.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl1 implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户11111111");
    }
}
