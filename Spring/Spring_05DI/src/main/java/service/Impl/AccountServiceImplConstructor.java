package service.Impl;

import service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImplConstructor implements IAccountService {
    //如果是经常变化的数据，并不适合注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImplConstructor(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("save方法执行了" + name + age + birthday);
    }
}
