package factory;

import java.beans.Beans;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂
 *
 * Bean：
 *  计算机英语中：可重用组件
 * JavaBean：用java语言编写的可重用组件
 *   ≠实体类，大于实体类
 *
 *   创建service和dao对象
 *
 *   1.配置文件，配置service和dao
 *      包含：（key=value）
 *          全限定类名
 *          全限定类名的唯一标志
 *   2.读取配置文件的内容，反射创建对象
 *
 *   两种配置方式：
 *      xml
 *      properties
 */
public class BeanFactory {
    //定义properties对象
    private static Properties props;

    //4.定义一个Map，用于存放我们要创建的对象，我们称之为容器,来实现单例而不是多例
    private static Map<String,Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        //实例化对象
        props = new Properties();
        //获取properties流对象
        try {
            /**注意此时不能使用 InputStream i = new FileInputStream("")来创建流对象
             * 写绝对路径，不能保证工程部署环境都有c盘D盘
             * 写相对路径src，web工程部署后src就没了，用不了
            */
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //去除配置文件所有的key
            Enumeration keys= props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //存入容器
                beans.put(key,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**根据Bean名称，获取Bean对象
    public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        //01jdbc代码里的class反射
        try {
            //通过反射的方式来创建
            bean = Class.forName(beanPath).newInstance();//每次都调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
    //在工厂加载的时候，static方法中，所有的对象都已经准备就绪，不需要每次都创建一个实例对象
    //根据名称获取bean对象
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
