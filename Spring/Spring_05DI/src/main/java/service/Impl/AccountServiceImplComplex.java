package service.Impl;

import service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImplComplex implements IAccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties properties;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void save() {
        System.out.println(Arrays.toString(myStrs) + "," + myList + "," + mySet + "," + myMap + "," + properties);
    }
}
