package project.service.Impl;

import org.springframework.stereotype.Service;
import project.service.IAccountService;

/**
 * @author:profiteur
 * @create 2020-02-14 16:03
 * @description 账户业务层实现类
 **/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
