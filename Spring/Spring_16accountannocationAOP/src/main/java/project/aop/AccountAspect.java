package project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import project.utils.TransactionManager;

import javax.annotation.Resource;

/**
 * @author:profiteur
 * @create 2020-02-16 19:59
 * @description
 **/
@Component
@Aspect
public class AccountAspect {
    @Resource(name = "transactionManager")
    private TransactionManager txManager;

    @Pointcut("execution(* project.service.impl.*.*(..))")
    private void pt1(){}

    @Before("pt1()")
    public void begin(){
        System.out.println("开启事务");
        txManager.begin();
    }

    @AfterReturning("pt1()")
    public void commit(){
        System.out.println("提交事务");
        txManager.commit();
    }

    @AfterThrowing("pt1()")
    public void rollback(){
        System.out.println("回滚");
        txManager.rollback();
    }

    @After("pt1()")
    public void release(){
        System.out.println("释放资源");
        txManager.release();
    }

    //@Around("pt1()")
    public Object around(ProceedingJoinPoint pjp){
        Object rtValue = null;
        Object[] args = pjp.getArgs();//获取方法执行所需参数
        System.out.println("开启事务");
        txManager.begin();
        try {
            rtValue = pjp.proceed(args);
            System.out.println("提交事务");
            txManager.commit();
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("回滚");
            txManager.rollback();
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("释放资源");
            txManager.release();
        }
    }
}
