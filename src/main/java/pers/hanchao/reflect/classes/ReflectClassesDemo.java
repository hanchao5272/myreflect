package pers.hanchao.reflect.classes;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.MyAnnotationB;
import pers.hanchao.reflect.common.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * <p>java.lang.Class示例</p>
 *
 * @author hanchao 2018/3/3 18:45
 **/
public class ReflectClassesDemo {
    private static final Logger LOGGER = Logger.getLogger(ReflectClassesDemo.class);

    /**
     * <p>Java反射-类Class示例</p>
     *
     * @author hanchao 2018/3/3 18:45
     **/
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获得Class对象
        Class userClass = User.class;

        //获得包信息 Package
        LOGGER.info("通过class.getPackage()获得类的包名：" + userClass.getPackage());

        //获取注解信息
        LOGGER.info("通过class.getDeclaredAnnotation(name)获取指定的注解：" + userClass.getDeclaredAnnotation(MyAnnotationB.class));
        Annotation[] annotations = userClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            LOGGER.info("通过class.getDeclaredAnnotations()获取全部的注解：" + annotation);
        }

        //获取修饰符 Modifier
        LOGGER.info("通过class.getModifiers()获得类的修饰符：" + Modifier.toString(userClass.getModifiers()));

        //获的继承的父类 SuperClass
        LOGGER.info("通过class.getSuperclass()获得类的父类" + userClass.getSuperclass());

        //获取类实现的接口 Interface
        Class[] interfaces = userClass.getInterfaces();
        for (Class inter : interfaces) {
            LOGGER.info("通过class.getInterfaces()获取类实现的接口：" + inter);
        }

        //获取类的名称
        LOGGER.info("通过class.getName()获得类的全名：" + userClass.getName());
        LOGGER.info("通过class.getSimpleName()获得类的简名：" + userClass.getSimpleName());

        //获取字段 Field
        LOGGER.info("通过class.getDeclaredField获取指定的字段：" + userClass.getDeclaredField("username"));
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            LOGGER.info("通过class.getDeclaredFields()获取全部字段：" + field);
        }

        //获取构造器 Constructor
        LOGGER.info("通过class.getDeclaredConstructor(args...)获取指定的构造器：" + userClass.getDeclaredConstructor());
        Constructor[] constructors = userClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            LOGGER.info("通过class.getDeclaredConstructors()获取全部构造器：");
        }
        User user = (User) userClass.getDeclaredConstructor().newInstance();
        LOGGER.info("通过constructor.newInstance(args...)进行对象实例化：" + user.toString());

        //获取方法 Method
        LOGGER.info("通过class.getDeclaredMethod(args...)获取指定的方法：" + userClass.getDeclaredMethod("setPassword", int.class));
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            LOGGER.info("通过class.getDeclaredMethods()获取全部的方法：" + method);
        }
        userClass.getDeclaredMethod("setPassword", int.class).invoke(user, 9999);
        LOGGER.info("通过method.invoke(obj,args...)执行方法：" + user.toString());
    }
}
