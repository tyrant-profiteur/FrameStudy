package service.Impl;

import service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImplSet implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("save方法执行了" + name + age + birthday);
    }
}
