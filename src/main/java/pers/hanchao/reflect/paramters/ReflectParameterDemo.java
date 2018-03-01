package pers.hanchao.reflect.paramters;

import org.apache.log4j.Logger;
import pers.hanchao.reflect.common.MyAnnotationB;
import pers.hanchao.reflect.common.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Created by 韩超 on 2018/3/1.
 */
public class ReflectParameterDemo {
    private final static Logger LOGGER = Logger.getLogger(ReflectParameterDemo.class);

    /**
     * <p>Title: java反射-参数Parameter</p>
     *
     * @author 韩超 2018/3/1 15:56
     */
    public static void main(String[] args) throws NoSuchMethodException {
        //首先获取Class对象
        Class userClass = User.class;
        //然后获取Method（或者Constructor）对象
        Method method = userClass.getDeclaredMethod("initUser", String.class, String.class);
        //然后获取Parameter对象数组
        Parameter[] parameters = method.getParameters();
        //然后获取Parameter对象
        Parameter parameter = parameters[0];

        //===================================== Parameter信息获取 =====================================
        LOGGER.info("===================================== Parameter信息获取 =====================================");
        LOGGER.info("通过parameter.getModifiers()获取参数修饰符:" + Modifier.toString(parameter.getModifiers()));
        LOGGER.info("通过parameter.getName()获取参数名：" + parameter.getName());
        LOGGER.info("通过parameter.getParameterizedType()获取参数化类型：" + parameter.getParameterizedType());
        LOGGER.info("通过parameter.toString()获取参数的字符串描述：" + parameter.toString());
        LOGGER.info("通过parameter.isSynthetic()判断参数是否是合成的：" + parameter.isSynthetic());
        LOGGER.info("通过parameter.isImplicit()判断参数是否是隐式的：" + parameter.isImplicit());
        LOGGER.info("通过parameter.isNamePresent()判断参数是否以类文件名命名：" + parameter.isNamePresent());
        LOGGER.info("通过parameter.isVarArgs()判断参数是否是可变的：" + parameter.isVarArgs() + "\n");

        //===================================== Parameter注解信息 =====================================
        LOGGER.info("===================================== Parameter注解信息 =====================================");
        //通过parameter.getAnnotatedType()获取注解的类型（组合类型）
        AnnotatedType annotatedType = parameter.getAnnotatedType();
        LOGGER.info("通过parameter.getAnnotatedType()获取注解的类型（组合类型）--参数类型：" + annotatedType.getType() + "\n");

        //通过parameter.getAnnotation()和parameter.getDeclaredAnnotation()获取参数的一个注解
        LOGGER.info("通过parameter.getAnnotation()获取参数的一个注解:" + parameter.getAnnotation(MyAnnotationB.class));
        LOGGER.info("通过parameter.getDeclaredAnnotation()获取参数的一个注解:" + parameter.getDeclaredAnnotation(MyAnnotationB.class) + "\n");

        //通过parameter.getAnnotationsByType(annotation.class)获取一类注解
        Annotation[] typeAnnotations = parameter.getAnnotationsByType(MyAnnotationB.class);
        for (Annotation annotation : typeAnnotations) {
            LOGGER.info("通过parameter.getAnnotationsByType(annotation.class)获取一类注解：" + annotation);
        }
        //通过parameter.getDeclaredAnnotationsByType(annotation.class)获取一类注解
        Annotation[] typeAnnotations1 = parameter.getDeclaredAnnotationsByType(MyAnnotationB.class);
        for (Annotation annotation : typeAnnotations1) {
            LOGGER.info("通过parameter.getDeclaredAnnotationsByType(annotation.class)获取一类注解：" + annotation);
        }
        System.out.println("");

        //通过parameter.getAnnotations()获取全部注解
        Annotation[] annotations = parameter.getAnnotations();
        for (Annotation annotation : annotations) {
            LOGGER.info("通过parameter.getAnnotations()获取全部注解:" + annotation);
        }
        //通过parameter.getDeclaredAnnotations()获取全部注解
        Annotation[] annotations1 = parameter.getDeclaredAnnotations();
        for (Annotation annotation : annotations1) {
            LOGGER.info("通过parameter.getDeclaredAnnotations()获取全部注解:" + annotation);
        }
    }
}
