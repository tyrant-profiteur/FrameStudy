package project.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project.dao.IAccountDao;
import project.domain.Account;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:profiteur
 * @create 2020-02-17 11:09
 * @description 账户持久层实现类
 **/
@Repository("accountDao")
public class AccountDaoImpl2 extends JdbcSupport implements IAccountDao {
    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = getJt().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts =  getJt().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if (accounts.isEmpty() || accounts.size() == 0){
            return null;
        }
        if (accounts.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void update(Account account) {
        getJt().update("update account set name = ?,money = ? where id = ?",new BeanPropertyRowMapper<Account>(Account.class),account.getName(),account.getMoney(),account.getId());
    }
}
