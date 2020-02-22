package project.service;

/**
 * @author:profiteur
 * @create 2020-02-14 16:01
 * @description 账户的业务层接口
 **/
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return
     */
    int deleteAccount();
}
