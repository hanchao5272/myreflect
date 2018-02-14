package pers.hanchao.reflect.clazz;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.User;

/**
* <p>Java获取Class</p>
* @author hanchao 2018/2/14 22:32
*/
public class ReflectClassDemo {
    /** log4j */
    private static final Logger LOGGER = Logger.getLogger(ReflectClassDemo.class);
    /**
    * <p>获取Class的三种方式</p>
    * @author hanchao
    */
    public static void main(String[] args) throws ClassNotFoundException {
        LOGGER.info("获取Class方式01：类的public属性class");
        Class clazz1 = User.class;
        LOGGER.info(clazz1);
        LOGGER.info(clazz1.toString());

        System.out.println();
        LOGGER.info("获取Class方式02：类的public方法getClass()");
        User user = new User();
        Class clazz2 = user.getClass();
        LOGGER.info(clazz2);
        LOGGER.info(clazz2.toString());

        System.out.println();
        LOGGER.info("获取Class方法03：Class.forName（需要抛出异常）");
        Class clazz3 = Class.forName("pers.hanchao.reflect.common.User");
        LOGGER.info(clazz3);
        LOGGER.info(clazz3.toString());
    }
}
