package ui;

import service.IAccountService;
import service.Impl.AccountServiceImpl;

/**
 * 模拟表现层，调用业务层
 */
public class Client {
    public static void main(String[] args) {
        IAccountService as = new AccountServiceImpl();
        as.save();
    }
}
