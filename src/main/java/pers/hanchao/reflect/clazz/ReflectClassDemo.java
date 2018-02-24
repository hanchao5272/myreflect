package pers.hanchao.reflect.clazz;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.User;

/**
 * <p>Title: Java获取Class对象的三种方式</p>
 * @author 韩超 2018/2/24 13:56
 */
public class ReflectClassDemo {
    /** log4j */
    private static final Logger LOGGER = Logger.getLogger(ReflectClassDemo.class);
    /**
    * <p>获取Class对象的三种方式</p>
    * @author hanchao
    */
    public static void main(String[] args) throws ClassNotFoundException {
        LOGGER.info("获取Class对象方式01：类的public属性class");
        Class clazz1 = User.class;
        LOGGER.info(clazz1);

        System.out.println();
        LOGGER.info("获取Class对象方式02：类的public方法getClass()");
        User user = new User();
        Class clazz2 = user.getClass();
        LOGGER.info(clazz2);

        System.out.println();
        LOGGER.info("获取Class对象方法03：Class.forName（需要抛出异常）");
        Class clazz3 = Class.forName("pers.hanchao.reflect.common.User");
        LOGGER.info(clazz3);
    }
}
