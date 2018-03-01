package pers.hanchao.reflect.method;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.MyAnnotationA;
import pers.hanchao.reflect.common.MyAnnotationB;
import pers.hanchao.reflect.common.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * java.lang.reflect.Method示例
 * Created by 韩超 on 2018/2/28.
 */
public class ReflectMethodDemo {
    private final static Logger LOGGER = Logger.getLogger(ReflectMethodDemo.class);

    /**
     * <p>Title: java反射-方法Method示例</p>
     *
     * @author 韩超 2018/2/28 14:54
     */
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //首先获取Class对象
        Class userClass = User.class;

        ////////////////////////////////////// Class对象与Method对象的相互转化 /////////////////////////////////////
        LOGGER.info("////////////////////////////////////// Class对象与Method对象的相互转化 /////////////////////////////////////");
        //通过clazz.getDeclaredMethod(name,args)获取CLass对象的指定方法
        LOGGER.info("通过clazz.getDeclaredMethod(name,args)获取CLass对象的指定方法");
        Method getUsrMethod = userClass.getDeclaredMethod("getUsername");
        Method setUsrMethod = userClass.getDeclaredMethod("setUsername", String.class);
        LOGGER.info("通过clazz.getDeclaredMethod(name,args)获取CLass对象的指定方法：" + getUsrMethod);
        LOGGER.info("通过clazz.getDeclaredMethod(name,args)获取CLass对象的指定方法：" + setUsrMethod + "\n");

        //通过clazz.getMethods()获取CLass对象的全部方法
        LOGGER.info("通过clazz.getMethods()获取CLass对象的全部方法");
        Method[] methods = userClass.getMethods();
        for (Method method : methods) {
            LOGGER.info("通过clazz.getMethods()获取CLass对象的全部方法：" + method);
        }
        System.out.println();

        //通过method.getDeclaringClass()获取当前Method对象所属的Class
        Class userClass2 = getUsrMethod.getDeclaringClass();
        LOGGER.info("通过method.getDeclaringClass()获取当前Method对象所属的Class：" + userClass2 + "\n");

        ////////////////////////////////////// Method信息获取 /////////////////////////////////////
        LOGGER.info("////////////////////////////////////// Method信息获取 /////////////////////////////////////");
        //通过method.getName()获取方法名
        LOGGER.info("通过method.getName()获取方法名" + getUsrMethod.getName() + "\n");

        //通过method.getGenericReturnType()获取返回值的类型(Type)
        LOGGER.info("通过method.getGenericReturnType()获取返回值的类型(Type):" + getUsrMethod.getGenericReturnType());
        //通过method.getReturnType()获取返回值的类(Class)
        LOGGER.info("通过method.getReturnType()获取返回值的类(Class):" + getUsrMethod.getReturnType() + "\n");

        //通过method.getGenericParameterTypes()获取参数的类型(Type)
        Type[] paramTypes = setUsrMethod.getGenericParameterTypes();
        for (Type type : paramTypes) {
            LOGGER.info("通过method.getGenericParameterTypes()获取参数的类型(Type):" + type.getTypeName());
        }
        //通过method.getParameterTypes()获取参数的类(Class)
        Class[] paramClasses = setUsrMethod.getParameterTypes();
        for (Class clazz : paramClasses) {
            LOGGER.info("通过method.getParameterTypes()获取参数的类(Class):" + clazz);
        }
        System.out.println();
        //通过method.getGenericExceptionTypes()获取异常的类型(Type)
        Type[] exceptionTypes = getUsrMethod.getGenericExceptionTypes();
        for (Type exception : exceptionTypes) {
            LOGGER.info("通过method.getGenericExceptionTypes()获取异常的类型(Type):" + exception.getTypeName());
        }
        //通过method.getExceptionTypes()获取异常的类(Class)
        Class[] exceptionClasses = getUsrMethod.getExceptionTypes();
        for (Class exception : exceptionClasses) {
            LOGGER.info("通过method.getExceptionTypes()获取异常的类(Class):" + exception);
        }
        System.out.println();

        //通过method.toString()和method.toGenericString()获取方法的字符串描述
        LOGGER.info("通过method.toString()获取方法的字符串描述:" + getUsrMethod.toString());
        LOGGER.info("通过method.toGenericString()获取方法的字符串描述（包括通用类型）:" + getUsrMethod.toGenericString() + "\n");

        //通过equals()比较两个反复是否相同
        LOGGER.info("通过equals()比较两个反复是否相同：" + getUsrMethod.equals(setUsrMethod));
        //通过method.isBridge()判断是否是桥方法
        LOGGER.info("通过method.isBridge()判断是否是桥方法：" + getUsrMethod.isBridge());
        //通过method.isSynthetic()判断是否是合成方法
        LOGGER.info("通过method.isSynthetic()判断是否是合成方法：" + getUsrMethod.isSynthetic());
        //通过method.isDefault()判断是否使用了可变参数：
        Method demoMethod = userClass.getDeclaredMethod("demo", String[].class);
        LOGGER.info("通过method.isDefault()判断是否使用了可变参数：" + demoMethod.isDefault() + "\n");

        //通过method.getParameterCount()获取参数个数
        LOGGER.info("通过method.getParameterCount()获取参数个数，setUsername = " + setUsrMethod.getParameterCount());
        LOGGER.info("通过method.getParameterCount()获取参数个数，getUsername = " + getUsrMethod.getParameterCount() + "\n");

        //通过method.getDefaultValue()获取默认返回值
        System.out.println("通过method.getDefaultValue()获取默认返回值,setUsername = " + setUsrMethod.getDefaultValue());
        System.out.println("通过method.getDefaultValue()获取默认返回值,getUsrMethod = " + getUsrMethod.getDefaultValue() + "\n");

        //通过method.getTypeParameters()获取泛型方法的参数化类型
        TypeVariable[] typeVariables = getUsrMethod.getTypeParameters();
        LOGGER.info("通过method.getTypeParameters()获取泛型方法的参数化类型,getUsrMethod（）的参数化类型个数：" + typeVariables.length);
        Method toArrayMethod = userClass.getDeclaredMethod("test", Object.class);
        TypeVariable[] typeVariables1 = toArrayMethod.getTypeParameters();
        LOGGER.info("通过method.getTypeParameters()获取泛型方法的参数化类型,ReflectMethodDemo.test()的参数化类型：" + typeVariables1[0].getName() + "\n");

        ////////////////////////////////////// Method注解信息获取 /////////////////////////////////////
        LOGGER.info("////////////////////////////////////// Method注解信息获取 /////////////////////////////////////");
        //通过method.getAnnotatedReturnType()获取被注解的返回值类型（组合类型）
        AnnotatedType returnAnnotatedType = getUsrMethod.getAnnotatedReturnType();
        LOGGER.info("通过method.getAnnotatedReturnType()获取被注解的返回值类型（组合类型）:" + returnAnnotatedType);
        //获取被注解的返回值类型中的返回值类型
        LOGGER.info("通过annotatedType.getType()获取被注解的返回值类型中的返回值类型:" + returnAnnotatedType.getType());
        //获取被注解的返回值类型中的注解类型
        Annotation[] annotations = returnAnnotatedType.getAnnotations();
        LOGGER.info("通过annotatedType.getAnnotations()获取被注解的返回值类型中的注解类型");
        setUsrMethod.getAnnotatedParameterTypes();
        setUsrMethod.getAnnotatedExceptionTypes();
        setUsrMethod.getAnnotatedReceiverType();
        LOGGER.info("类似于method.getAnnotatedReturnType()的还有: method.getAnnotatedParameterTypes()");
        LOGGER.info("类似于method.getAnnotatedReturnType()的还有: method.getAnnotatedExceptionTypes()");
        LOGGER.info("类似于method.getAnnotatedReturnType()的还有: method.getAnnotatedReceiverType()" + "\n");

        //获取指定的单个注解
        Annotation annotation = getUsrMethod.getAnnotation(MyAnnotationA.class);
        Annotation annotation1 = getUsrMethod.getDeclaredAnnotation(MyAnnotationB.class);
        LOGGER.info("通过method.getAnnotation(Annotation.class)获取指定的注解: " + annotation);
        LOGGER.info("通过method.getDeclaredAnnotation(Annotation.class)获取指定的注解 :" + annotation1 + "\n");
        //获取指定的一类注解
        Annotation[] annotations1 = getUsrMethod.getAnnotationsByType(MyAnnotationA.class);
        for (Annotation annotation11 : annotations1) {
            LOGGER.info("通过method.getAnnotationsByType(MyAnnotation.class)获取一类注解： " + annotation11);
        }
        Annotation[] annotations2 = getUsrMethod.getDeclaredAnnotationsByType(MyAnnotationA.class);
        for (Annotation annotation22 : annotations2) {
            LOGGER.info("通过method.getDeclaredAnnotationsByType(MyAnnotation.class)获取一类注解： " + annotation22);
        }
        System.out.println("");
        //获取全部的注解
        Annotation[] annotations3 = getUsrMethod.getAnnotations();
        for (Annotation annotation33 : annotations3) {
            LOGGER.info("通过method.getAnnotations()获取全部注解： " + annotation33);
        }
        Annotation[] annotations4 = getUsrMethod.getDeclaredAnnotations();
        for (Annotation annotation44 : annotations4) {
            LOGGER.info("通过method.getDeclaredAnnotations()获取全部注解： " + annotation44);
        }
        System.out.println("");
        //获取参数的注解
        Method initUserMethod = userClass.getDeclaredMethod("initUser", String.class, String.class);

        //通过method.getParameterAnnotations()获取方法的所有参数注解（二维矩阵）
        LOGGER.info("通过method.getParameterAnnotations()获取方法的所有参数注解（二维矩阵）");
        Annotation[][] annotations5 = initUserMethod.getParameterAnnotations();
        for (int i = 0; i < annotations5.length; i++) {
            //第一个维度标识的是第i个参数的所有注解
            Annotation[] paramAnnotations = annotations5[i];
            for (int j = 0; j < paramAnnotations.length; j++) {
                //第二个维度标识的是第i个参数的第j个注解
                Annotation paramAnnotation = paramAnnotations[j];
                LOGGER.info("第" + (i + 1) + "个参数，第" + (j + 1) + "个注解： " + paramAnnotation);
            }
        }
        System.out.println("");

        ////////////////////////////////////// Method 获取修饰符信息  /////////////////////////////////////
        LOGGER.info("////////////////////////////////////// Method 获取修饰符信息  /////////////////////////////////////");
        //通过method.getModifiers()获取方法修饰符的int值
        LOGGER.info("通过method.getModifiers()获取方法修饰符的int值" + Modifier.toString(getUsrMethod.getModifiers()) + "\n");

        LOGGER.info("////////////////////////////// Method 调用方法 ///////////////////////////////");
        ////////////////////////////// Method 调用方法 ///////////////////////////////
        User user = new User();
        LOGGER.info("通过直接方法user.getUsername()获取 user.username = " + user.getUsername());
        //通过method.invoke(user,args...)调用方法
        LOGGER.info("通过反射方法method.invoke(user,args...)设置 user.username");
        setUsrMethod.invoke(user, "张三丰");
        LOGGER.info("通过反射方法method.invoke(user,args...)获取 user.username = " + getUsrMethod.invoke(user));
    }
}
