package pers.hanchao.reflect.Introduction;

import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by 韩超 on 2018/2/24.
 */
public class ReflectIntroductionDemo {

    private final static Logger LOGGER = Logger.getLogger(ReflectIntroductionDemo.class);

    /**
     * <p>Title: Java反射入门示例</p>
     *
     * @author 韩超 2018/2/24 10:30
     */
    public static void main(String[] args) throws Exception {
        Class dClass = ReflectDemo1.class;
        LOGGER.info("获取类信息Class对象：" + dClass);

        Field field = dClass.getField("demo");
        LOGGER.info("通过Class对象 获取字段信息Field：" + field);

        Constructor constructor = dClass.getDeclaredConstructor(Integer.class);
        LOGGER.info("通过Class对象 获取构造函数Constructor： " + constructor);
        ReflectDemo1 demo1 = (ReflectDemo1) constructor.newInstance(1);
        LOGGER.info("通过Constructor对象 创建对象：" + demo1.toString());

        Method method = dClass.getDeclaredMethod("getDemo");
        LOGGER.info("通过Class对象 获取方法Method：" + method);
        Integer integer = (Integer) method.invoke(demo1);
        LOGGER.info("通过Method对象 操作对象 : public Integer getDemo() = " + integer);

        LOGGER.info("通过Class对象 获取修饰符Modifier：" + Modifier.toString(dClass.getModifiers()));
        LOGGER.info("通过Field对象 获取修饰符Modifier：" + Modifier.toString(field.getModifiers()));
        LOGGER.info("通过Method对象 获取修饰符Modifier：" + Modifier.toString(field.getModifiers()));
        LOGGER.info("通过Constructor对象 获取修饰符Modifier：" + Modifier.toString(constructor.getModifiers()));
    }
}
