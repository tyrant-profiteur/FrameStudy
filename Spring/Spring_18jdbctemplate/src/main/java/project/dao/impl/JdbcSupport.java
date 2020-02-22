package project.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * @author:profiteur
 * @create 2020-02-17 14:18
 * @description 抽取dao中的重复代码
 **/
public class JdbcSupport {
    @Resource
    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }
}
