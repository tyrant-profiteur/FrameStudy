package project.dao;

import project.domain.Account;

/**
 * @author:profiteur
 * @create 2020-02-17 11:09
 * @description 账户的持久层接口
 **/
public interface IAccountDao {
    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void update(Account account);
}
