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
     * <p>Java反射-Field成员变量示例</p>
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
        //通过Class.getField对象获取指定的Field
        Field usrFiled = userClass.getField("username");
        LOGGER.info("通过Class.getField(field_name)获取指定的Field： " + usrFiled);

        //通过Class.getDeclaredField对象获取指定的Field
        Field pwdFiled = userClass.getDeclaredField("password");
        LOGGER.info("通过Class.getDeclaredField(field_name)获取指定的Field： " + pwdFiled + "\n");

        //通过Class.getFields()获取所有的成员变量对象
        Field[] fields = userClass.getFields();
        for (Field field : fields) {
            LOGGER.info("通过Class.getFields()获取所有的成员变量对象：" + field);
        }
        //通过Class.getDeclaredFields()获取所有的成员变量对象
        Field[] fields1 = userClass.getDeclaredFields();
        for (Field field : fields1) {
            LOGGER.info("通过Class.getDeclaredFields()获取所有的成员变量对象：" + field);
        }
        System.out.println();

        //通过Field.getDeclaredClass获取定义这个成员变量的的Class对象
        LOGGER.info("通过Field.getDeclaredClass()获取定义这个成员变量的的Class对象");
        Class usrClass1 = usrFiled.getDeclaringClass();
        LOGGER.info("定义" + usrFiled + "成员变量的类是" + usrClass1 + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field信息 //////////////////////////////////////");
        //////////////////////////////////////////////// Field信息 //////////////////////////////////////
        //通过Field.getModifiers()获取成员变量修饰符
        LOGGER.info("通过Field.getModifiers()获取成员变量修饰符");
        int modifiers = usrFiled.getModifiers();
        LOGGER.info("username的修饰符：" + Modifier.toString(modifiers) + "\n");

        //通过Field.getName()获取成员变量名
        LOGGER.info("通过Field.getName()获取成员变量名");
        String username = usrFiled.getName();
        LOGGER.info("username的成员变量名：" + username + "\n");

        //通过Field.getGenericType()和Field.getType()获取当前成员变量的类型和类
        LOGGER.info("通过Field.getGenericType()和Field.getType()获取当前成员变量的类型和类");
        Type usrFiledType = usrFiled.getGenericType();
        Class usrFieldClass = usrFiled.getType();
        LOGGER.info("username的类型是：" + usrFiledType);
        LOGGER.info("username的类是：" + usrFieldClass + "\n");

        //通过Field.toGenericString()和Field.toString()获取描述当前成员变量的字符串
        LOGGER.info("通过Field.toGenericString()和Field.toString()获取描述当前成员变量的字符串");
        String usrGenericString = usrFiled.toGenericString();
        String usrString = usrFiled.toString();
        LOGGER.info("username的字符串描述（包括通用类型）：" + usrGenericString);
        LOGGER.info("username的字符串描述：" + usrString + "\n");

        //通过Field.equals方法判断两个Field是否相等
        LOGGER.info("通过Field.equals方法判断两个Field是否相等");
        LOGGER.info("usrFiled equals pwdFiled :" + usrFiled.equals(pwdFiled) + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field 获取注解信息 //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取注解信息 //////////////////////////////////////
        //通过Field.getAnnotation(Annotation.class) 获取指定的注解
        Annotation annotation = usrFiled.getAnnotation(MyAnnotationA.class);
        LOGGER.info("通过Field.getAnnotation(Annotation.class) 获取指定的注解：" + annotation + "\n");

        //通过Field.getDeclaredAnnotation(Annotation.class) 获取指定的注解
        Annotation annotation1 = usrFiled.getDeclaredAnnotation(MyAnnotationA.class);
        LOGGER.info("通过Field.getDeclaredAnnotation(Annotation.class) 获取指定的注解：" + annotation1 + "\n");

        //通过Field.getAnnotationsByType(Annotation.class)获取一组指定的注解
        Annotation[] annotations = usrFiled.getAnnotationsByType(MyAnnotationA.class);
        for (Annotation anno : annotations){
            LOGGER.info("通过Field.getAnnotationsByType(Annotation.class)获取一组指定的注解:" + anno);
        }
        System.out.println();
        //通过Field.getDeclaredAnnotationsByType(Annotation.class)获取一组指定的注解
        Annotation[] annotations1 = usrFiled.getDeclaredAnnotationsByType(MyAnnotationA.class);
        for (Annotation anno : annotations1){
            LOGGER.info("通过Field.getDeclaredAnnotationsByType(Annotation.class)获取一组指定的注解:" + anno);
        }
        System.out.println();
        //通过Field.getAnnotations() 获取所有的注解
        Annotation[] annotations2 = usrFiled.getAnnotations();
        for (Annotation anno : annotations2) {
            LOGGER.info("通过Field.getAnnotations() 获取所有的注解：" + anno);
        }
        System.out.println();
        //通过Field.getDeclaredAnnotations() 获取所有的注解
        Annotation[] annotations3 = usrFiled.getDeclaredAnnotations();
        for (Annotation anno : annotations3) {
            LOGGER.info("通过Field.getDeclaredAnnotations() 获取所有的注解：" + anno);
        }
        System.out.println();

        LOGGER.info("//////////////////////////////////////////////// Field 获取某个对象的成员变量值（全部类型(基本数据类型自动装箱)） //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取某个对象的成员变量值（全部类型(基本数据类型自动装箱)） //////////////////////////////////////
        //通过Field.get方法获取某个对象在此成员变量上的值
        LOGGER.info("通过Field.get(Object obj)和Field.set 为当前成员变量设置和获取值[全部类型(基本数据类型自动装箱)]");
        User user = new User();
        LOGGER.info("user对象在username成员变量的值是：" + usrFiled.get(user).getClass() + usrFiled.get(user));
        usrFiled.set(user, "张三丰");
        LOGGER.info("user对象在username成员变量的值是：" + usrFiled.get(user).getClass() + usrFiled.get(user) + "\n");

        LOGGER.info("//////////////////////////////////////////////// Field 获取和设置某个对象的成员变量值（基本数据类型） //////////////////////////////////////");
        //////////////////////////////////////////////// Field 获取和设置某个对象的成员变量值（基本数据类型） //////////////////////////////////////
        //通过filed.setAccessible(boolean)设置字段是否可访问
        LOGGER.info("通过filed.setAccessible(boolean)设置字段是否可访问");
        pwdFiled.setAccessible(true);
        //通过Field.getXxxx和Field.setXxxx为当前成员变量设置和获取基本数据类型的值
        LOGGER.info("通过Field.getXxxx和Field.setXxxx为当前成员变量设置和获取基本数据类型的值");
        LOGGER.info("成员变量类型：" + pwdFiled);
        User user1 = new User("王五", 111111);
        LOGGER.info("user1.password = " + pwdFiled.getInt(user1));
        pwdFiled.setInt(user1, 321);
        LOGGER.info("user1.password = " + pwdFiled.getInt(user1));
    }
}
