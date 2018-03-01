package pers.hanchao.reflect.fields;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.MyAnnotationA;
import pers.hanchao.reflect.common.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * <p>java.lang.reflect.Field学习示例</p>
 *
 * @author hanchao 2018/2/26 21:23
 */
public class ReflectFieldDemo {
    /**
     * log4j
     */
    private static final Logger LOGGER = Logger.getLogger(ReflectFieldDemo.class);

    /**
     * <p>Java反射Field示例</p>
     *
     * @author hanchao 2018/2/26 21:26
     */
    public static void main(String[] args) throws Exception {
        LOGGER.info("Java反射-Field示例");
        //首先获取Class的对象
        Class userClass = User.class;
        LOGGER.info("首先获取Class的对象：" + userClass + "\n");

        LOGGER.info("//////////////////////////////////////////////// Class对象与Field对象的相互获取 //////////////////////////////////////");
        //////////////////////////////////////////////// Class对象与Field对象的相互获取 //////////////////////////////////////
        //通过Class.getDeclaredField对象获取指定的Field对象
        LOGGER.info("通过Class.getDeclaredField对象获取指定的Field对象");
        Field usrFiled = userClass.getDeclaredField("username");
        Field pwdFiled = userClass.getDeclaredField("password");
        LOGGER.info("username的Field： " + usrFiled);
        LOGGER.info("password的Field： " + pwdFiled + "\n");

        //通过Class.getFields()获取所有的字段对象
        LOGGER.info("通过Class.getFields()获取所有的字段对象");
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            LOGGER.info("User的字段：" + field);
        }
        System.out.println();

        //通过通过Field.getDeclaredClass获取定义这个字段的的Class对象
        LOGGER.info("通过Field.getDeclaredClass获取定义这个字段的的Class对象");
        Class usrClass1 = usrFiled.getDeclaringClass();
        LOGGER.info("定义" + usrFiled + "字段的类是" + usrClass1 + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field信息 //////////////////////////////////////");
        //////////////////////////////////////////////// Field信息 //////////////////////////////////////
        LOGGER.info("通过Field.getName()获取字段名");
        String username = usrFiled.getName();
        LOGGER.info("username的字段名：" + username + "\n");

        //通过Field.getGenericType()和Field..getType()获取当前字段的类型和类
        LOGGER.info("通过Field.getGenericType()和Field..getType()获取当前字段的类型和类");
        Type usrFiledType = usrFiled.getGenericType();
        Class usrFieldClass = usrFiled.getType();
        LOGGER.info("username的类型是：" + usrFiledType);
        LOGGER.info("username的类是：" + usrFieldClass + "\n");

        //通过Field.toGenericString()和Field.toString()获取描述当前字段的字符串
        LOGGER.info("通过Field.toGenericString()和Field.toString()获取描述当前字段的字符串");
        String usrGenericString = usrFiled.toGenericString();
        String usrString = usrFiled.toString();
        LOGGER.info("username的字符串描述（包括通用类型）：" + usrGenericString);
        LOGGER.info("username的字符串描述：" + usrString + "\n");

        //通过Field.equals方法判断两个Field是否相等
        LOGGER.info("通过Field.equals方法判断两个Field是否相等");
        LOGGER.info("usrFiled equals pwdFiled :" + usrFiled.equals(pwdFiled) + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field 获取注解信息 //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取注解信息 //////////////////////////////////////
        //通过Field.getAnnotation(Class <T> annotationClass) 获取指定的注解
        LOGGER.info("通过Field.getAnnotation(Class <T> annotationClass) 获取指定的注解");
        Annotation annotation = usrFiled.getAnnotation(MyAnnotationA.class);
        LOGGER.info("User.username 的 MyAnnotationA注解：" + annotation);

        //通过Field.getDeclaredAnnotations() 获取所有的注解
        LOGGER.info("通过Field.getDeclaredAnnotations() 获取所有的注解");
        Annotation[] annotations = usrFiled.getDeclaredAnnotations();
        for (Annotation annotation1 : annotations) {
            LOGGER.info("User.username 的注解：" + annotation1);
        }
        System.out.println();

        LOGGER.info("//////////////////////////////////////////////// Field 获取修饰符信息 //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取修饰符信息 //////////////////////////////////////
        //通过Field.getModifiers()获取字段修饰符
        LOGGER.info("通过Field.getModifiers()获取字段修饰符");
        int modifiers = usrFiled.getModifiers();
        LOGGER.info("username的修饰符：" + Modifier.toString(modifiers) + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field 获取某个对象的字段值（全部类型(基本数据类型自动装箱)） //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取某个对象的字段值（全部类型(基本数据类型自动装箱)） //////////////////////////////////////
        //通过Field.get方法获取某个对象在此字段上的值
        LOGGER.info("通过Field.get(Object obj)和Field.set 为当前字段设置和获取值[全部类型(基本数据类型自动装箱)]");
        User user = new User();
        LOGGER.info("user对象在username字段的值是：" + usrFiled.get(user).getClass() + usrFiled.get(user));
        usrFiled.set(user, "张三丰");
        LOGGER.info("user对象在username字段的值是：" + usrFiled.get(user).getClass() + usrFiled.get(user) + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field 获取和设置某个对象的字段值（基本数据类型） //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取和设置某个对象的字段值（基本数据类型） //////////////////////////////////////
        LOGGER.info("通过Field.getXxxx和Field.setXxxx为当前字段设置和获取基本数据类型的值");
        LOGGER.info("字段类型：" + pwdFiled);
        User user1 = new User("王五", 111111);
        LOGGER.info("user1.password = " + pwdFiled.getInt(user1));
        pwdFiled.setInt(user1, 321);
        LOGGER.info("user1.password = " + pwdFiled.getInt(user1));
    }
}
