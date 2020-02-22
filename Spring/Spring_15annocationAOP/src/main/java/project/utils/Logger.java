package project.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author:profiteur
 * @create 2020-02-14 16:05
 * @description 用于记录日志的类，提供公共记录日志的方法
 **/
@Component("logger")
@Aspect//表示当前类是个切面
public class Logger {
    @Pointcut("execution(* project.service.Impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知log类中的beforePrintLog方法开始记录日志");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知log类中的afterReturnPrintLog方法开始记录日志");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知log类中的afterThrowingPrintLog方法开始记录日志");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知log类中的print方法开始记录日志");
    }

    /**
     * 环绕通知
     */
    //@Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需要的参数
            System.out.println("环绕通知log类中的aroundPrintLog方法前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("环绕通知log类中的aroundPrintLog方法后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("环绕通知log类中的aroundPrintLog方法异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("环绕通知log类中的aroundPrintLog方法最终");
        }
    }
}
