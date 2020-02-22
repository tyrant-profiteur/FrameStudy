package project.utils;

/**
 * @author:profiteur
 * @create 2020-02-14 16:05
 * @description 用于记录日志的类，提供公共记录日志的方法
 **/
public class Logger {
    /**
     * 用于打印日志，在切入点方法（业务层方法）执行之前执行
     */
    public void printLog(){
        System.out.println("log类中的print方法开始记录日志");
    }
}
