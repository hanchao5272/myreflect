package pers.hanchao.reflect.constructor;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.MyAnnotationA;
import pers.hanchao.reflect.common.MyAnnotationB;
import pers.hanchao.reflect.common.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * java.lang.reflect.Constructor示例
 * Created by 韩超 on 2018/3/1.
 */
public class ReflectConstructorDemo {
    private final static Logger LOGGER = Logger.getLogger(ReflectConstructorDemo.class);

    static class Demo<T>{
        private T t;

        public Demo(T t) {
            this.t = t;
        }
    }

    /**
     * <p>Title: java反射-构造器Constructor示例</p>
     * @author 韩超 2018/3/1 11:48
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //首先获取Class对象
        Class userClass = User.class;
        //========================================= Class对象与Constructor对象相互获取 =============================
        LOGGER.info("========================================= Class对象与Constructor对象相互获取 =============================");
        //通过class.getConstructor()和class.getDeclaredConstructor获取默认构造函数
        Constructor defaultConstructor = userClass.getConstructor();
        Constructor defaultConstructor1 = userClass.getDeclaredConstructor();
        LOGGER.info("通过class.getConstructor()获取默认构造函数:" + defaultConstructor);
        LOGGER.info("通过class.getDeclaredConstructor获取默认构造函数()获取默认构造函数:" + defaultConstructor1 + "\n");

        //通过class.getConstructor(args...)和class.getDeclaredConstructor(args...)获取带参数的构造器
        Constructor paramConstructor = userClass.getConstructor(String.class,int.class);
        Constructor paramConstructor1 = userClass.getDeclaredConstructor(String.class,int.class);
        LOGGER.info("通过class.getConstructor(args...)获取带参数的构造器:" + paramConstructor);
        LOGGER.info("通过class.getDeclaredConstructor(args...)获取带参数的构造器:" + paramConstructor1 + "\n");

        //通过class.getConstructors()和class.getDeclaredConstructors获取所有构造器
        Constructor[] constructors = userClass.getConstructors();
        Constructor[] constructors1 = userClass.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            LOGGER.info("通过class.getConstructors()获取所有构造器:" + constructor);
        }
        for (Constructor constructor : constructors1){
            LOGGER.info("通过class.getDeclaredConstructors()获取所有构造器:" + constructor);
        }
        System.out.println("");

        //通过constructor.getDeclaringClass()获取构造器所属的类
        Class userClass1 = defaultConstructor.getDeclaringClass();
        LOGGER.info("通过constructor.getDeclaringClass()获取构造器所属的类:" + userClass1 + "\n");

        //========================================= Constructor信息获取 =============================
        LOGGER.info("========================================= Constructor信息获取 =============================");
        //通过constructor.getName()获取构造器方法名
        LOGGER.info("通过constructor.getName()获取构造器方法名：" + defaultConstructor.getName() + "\n");

        //通过constructor.toGenericString()获取构造器的字符串描述（通用类型）
        LOGGER.info("通过constructor.toGenericString()获取构造器的字符串描述（通用类型）:" + defaultConstructor.toGenericString() + "\n");
        //通过constructor.toString()获取构造器的字符串描述
        LOGGER.info("通过constructor.toString()获取构造器的字符串描述:" + defaultConstructor.toString() + "\n");

        //通过constructor.getModifiers()获取构造器的修饰符
        LOGGER.info("通过constructor.getModifiers()获取构造器的修饰符：" + Modifier.toString(defaultConstructor.getModifiers()) + "\n");

        //通过constructor.getParameterCount()获取参数个数
        LOGGER.info("通过constructor.getParameterCount()获取参数个数-defaultConstructor：" + defaultConstructor.getParameterCount());
        LOGGER.info("通过constructor.getParameterCount()获取参数个数-paramConstructor:" + paramConstructor.getParameterCount() + "\n");
        //通过constructor.getParameterTypes()获取参数类数组（Class）
        Class[] paramClasses = paramConstructor.getParameterTypes();
        for(Class paramClass : paramClasses){
            LOGGER.info("通过constructor.getParameterTypes()获取参数类数组（Class）:" + paramClass);
        }
        //通过constructor.getParameterTypes()获取参数类型数组（Type）
        Type[] paramTypes = paramConstructor.getGenericParameterTypes();
        for(Type paramType : paramTypes){
            LOGGER.info("通过constructor.getGenericParameterTypes()获取参数类型数组（Type）:" + paramType);
        }
        System.out.println("");
        //通过constructor.getParameters()获取构造器的参数(Parameter)数组
        Parameter[] parameters = paramConstructor.getParameters();
        for (Parameter parameter : parameters){
            LOGGER.info("通过constructor.getParameters()获取构造器的参数数组:" + parameter);
        }
        System.out.println("");
        //通过constructor.getTypeParameters()获取参数化类型（泛型）
        TypeVariable[] typeVariables = paramConstructor.getTypeParameters();
        LOGGER.info("通过constructor.getTypeParameters()获取参数化类型（泛型）-paramConstructor参数化类型个数:" + typeVariables.length + "\n");

        //通过constructor.getExceptionTypes()获取异常类（Class）
        Class[] exceptionClasses = paramConstructor.getExceptionTypes();
        for (Class exceptionClass : exceptionClasses){
            LOGGER.info("通过const.getExceptionTypes()获取异常类（Class）:" + exceptionClass);
        }
        //通过constructor.getGenericExceptionTypes()获取异常类（Type）
        Class[] exceptionTypes = (Class[]) paramConstructor.getGenericExceptionTypes();
        for (Class exceptionType : exceptionTypes){
            LOGGER.info("通过const.getGenericExceptionTypes()获取异常类（Type）:" + exceptionType);
        }
        System.out.println("");

        //通过equals比较两个构造器是否相同
        LOGGER.info("通过equals比较两个构造器是否相同：" + defaultConstructor.equals(paramConstructor));
        //通过constructor.isSynthetic()判断构造器是否是合成方法
        LOGGER.info("通过constructor.isSynthetic()判断构造器是否是合成方法：" + defaultConstructor.isSynthetic());
        //通过constructor.isVarArgs()判断构造器是否有可变参数
        LOGGER.info("通过constructor.isVarArgs()判断构造器是否有可变参数：" + defaultConstructor.isVarArgs());
        //通过constructor.isAccessible()判断构造器是否可以访问
        LOGGER.info("通过constructor.isAccessible()判断构造器是否可以访问：" + defaultConstructor.isAccessible() + "\n");

        //========================================= Constructor注解信息 =============================
        LOGGER.info("========================================= Constructor注解信息 =============================");
        //通过constructor.getAnnotatedParameterTypes()获取注解的参数类型（组合类型）
        AnnotatedType[] annotatedTypes = paramConstructor.getAnnotatedParameterTypes();
        for (AnnotatedType annotatedType : annotatedTypes){
            LOGGER.info("通过constructor.getAnnotatedParameterTypes()获取注解的参数类型（组合类型）- 参数类型:" + annotatedType.getType());
        }
        System.out.println("");

        //通过constructor.getAnnotation(Annotation.class)和constructor.getDeclaredAnnotation(Annotation.class)获取指定的一个注解Class
        LOGGER.info("通过constructor.getAnnotation(Annotation.class)获取指定的注解Class：" + paramConstructor.getAnnotation(MyAnnotationA.class));
        LOGGER.info("通过constructor.getDeclaredAnnotation(Annotation.class)获取指定的注解Class:" + paramConstructor.getDeclaredAnnotation(MyAnnotationB.class) + "\n");

        //通过constructor.getAnnotationsByType(annotation.cass)和constructor.getDeclaredAnnotationsByType(annotation.cass)获取指定的一类注解Class
        Annotation[] oneTypeAnnotations = paramConstructor.getAnnotationsByType(MyAnnotationB.class);
        for (Annotation annotation : oneTypeAnnotations){
            LOGGER.info("通过constructor.getAnnotationsByType(annotation.cass)获取指定的一类注解Class：" + annotation);
        }
        Annotation[] oneTypeAnnotations1 = paramConstructor.getDeclaredAnnotationsByType(MyAnnotationB.class);
        for (Annotation annotation : oneTypeAnnotations1){
            LOGGER.info("通过constructor.getDeclaredAnnotationsByType(annotation.cass)获取指定的一类注解Class：" + annotation);
        }
        System.out.println("");

        //通过constructor.getAnnotations()和constructor.getDeclaredAnnotations()获取全部注解类
        Annotation[] annotations = paramConstructor.getAnnotations();
        for (Annotation annotation : annotations){
            LOGGER.info("通过constructor.getAnnotations()获取全部的注解类：" + annotation);
        }
        Annotation[] annotations1 = paramConstructor.getDeclaredAnnotations();
        for (Annotation annotation : annotations1){
            LOGGER.info("通过constructor.getDeclaredAnnotations()获取全部的注解类：" + annotation);
        }
        System.out.println("");

        //通过constructor.getParameterAnnotations获取参数和注解的二维矩阵
        Annotation[][] parameterAnnotations = paramConstructor.getParameterAnnotations();
        for(int i = 0; i < parameterAnnotations.length; i++) {
            //第一个维度标识的是第i个参数的所有注解
            for(int j = 0; j < parameterAnnotations[i].length; j++) {
                //第二个维度标识的是第i个参数的第j个注解
                LOGGER.info("第" + (i + 1) + "个参数的第" + (j+1) + "个注解：" + parameterAnnotations[i][j]);
            }
        }
        System.out.println("");

        //========================================= Constructor创建对象实例 =============================
        LOGGER.info("========================================= Constructor创建对象实例 =============================");
        //通过new创建实例化对象
        User user = new User();
        LOGGER.info("通过new创建实例化对象" + user.toString());

        //通过constructor.newInstance()以默认构造器进行对象实例化
        User user1 = (User) defaultConstructor.newInstance();
        LOGGER.info("通过constructor.newInstance()以默认构造器进行对象实例化" + user1.toString());
        //通过constructor.newInstance(args...)以指定构造器进行对象实例化
        User user2 = (User) paramConstructor.newInstance("王文武",19191);
        LOGGER.info("通过constructor.newInstance(args...)以指定构造器进行对象实例化:" + user2.toString());
    }
}
