package pers.hanchao.reflect.create;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.User;

import java.lang.reflect.Constructor;

/**
 * 通过反射创建对象的两种方式
 * Created by 韩超 on 2018/2/24.
 */
public class CreateObjectDemo {
    private final static Logger LOGGER = Logger.getLogger(CreateObjectDemo.class);

    /**
     * <p>Title: 通过反射创建对象的两种方式</p>
     * @author 韩超 2018/2/24 14:11
     */
    public static void main(String[] args) throws Exception {
        //通过new实例化对象
        User user = new User();
        LOGGER.info("通过new实例化对象：" + user.toString());

        //通过反射实例化对象
        Class userClass = User.class;
        //通过反射实例化对象01-Class.newInstance()（需要强制类型转换[无参构造]）
        User user1 = (User) userClass.newInstance();
        LOGGER.info("通过反射实例化对象01-Class.newInstance()（需要强制类型转换[无参构造]）：" + user1.toString());
        //通过反射实例化对象02-Constructor.newInstance()（需要强制类型转换[可带参数]）
        Constructor constructor = userClass.getDeclaredConstructor();
        User user2 = (User) constructor.newInstance();
        LOGGER.info("通过反射实例化对象02-Constructor.newInstance()（需要强制类型转换[无参构造]）：" + user2.toString());
        Constructor constructor1 = userClass.getDeclaredConstructor(String.class,String.class);
        User user3 = (User) constructor1.newInstance("李四","000000");
        LOGGER.info("通过反射实例化对象02-Constructor.newInstance()（需要强制类型转换[有参构造]）：" + user3.toString());
    }
}
