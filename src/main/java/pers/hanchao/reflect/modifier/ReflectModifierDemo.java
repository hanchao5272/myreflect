package pers.hanchao.reflect.modifier;

import org.apache.log4j.Logger;

import java.lang.reflect.Modifier;

/**
 * <p>java.lang.reflect.Modifier示例</p>
 *
 * @author hanchao 2018/2/27 21:19
 **/
public class ReflectModifierDemo {
    private static final Logger LOGGER = Logger.getLogger(ReflectModifierDemo.class);

    /**
     * <p>java反射-修饰符 示例</p>
     *
     * @author hanchao 2018/2/27 21:19
     **/
    public static void main(String[] args) {
        //通过Modifier.toString(modifier)可以将十进制值解析成对应的修饰符
        LOGGER.info("通过Modifier.toString(modifier)可以将十进制值解析成对应的修饰符");
        LOGGER.info("Modifier.toString(1) = " + Modifier.toString(1));
        LOGGER.info("Modifier.toString(2) = " + Modifier.toString(2) + "\n");

        //通过Modifier.isZzzz(1)[Zzzz=全部修饰符]判断是否为某个修饰符
        LOGGER.info("通过Modifier.isZzzz(1)[Zzzz=全部修饰符]判断是否为某个修饰符");
        LOGGER.info("Modifier.isPublic(1) = " + Modifier.isPublic(1));
        LOGGER.info("Modifier.isPublic(2) = " + Modifier.isPublic(2) + "\n");

        //通过Modifier.xxxModifiers可以获取某项目（interface/class/constructor/field/method/）对应的所有修饰符
        LOGGER.info("通过Modifier.xxxModifiers可以获取某项目（interface/class/constructor/field/method/）对应的所有修饰符");
        LOGGER.info("Modifier.toString(Modifier.interfaceModifiers()) = " + Modifier.toString(Modifier.interfaceModifiers()));
        LOGGER.info("Modifier.toString(Modifier.classModifiers()) = " + Modifier.toString(Modifier.classModifiers()));
        LOGGER.info("Modifier.toString(Modifier.constructorModifiers()) = " + Modifier.toString(Modifier.constructorModifiers()));
        LOGGER.info("Modifier.toString(Modifier.fieldModifiers()) = " + Modifier.toString(Modifier.fieldModifiers()));
        LOGGER.info("Modifier.toString(Modifier.methodModifiers()) = " + Modifier.toString(Modifier.methodModifiers()) + "\n");

        //通过Modifier.FIELD可以获取每个修饰符对应的十进制值和十六进制值
        LOGGER.info("通过Modifier.FIELD可以获取每个修饰符对应的十进制值和十六进制值");
        LOGGER.info("Modifier.PUBLIC = " + Modifier.PUBLIC + " = 0x" +String.format("%08x",Modifier.PUBLIC));
        LOGGER.info("Modifier.PRIVATE = " + Modifier.PRIVATE + " = 0x" +String.format("%08x",Modifier.PRIVATE));
        LOGGER.info("Modifier.PROTECTED = " + Modifier.PROTECTED + " = 0x" +String.format("%08x",Modifier.PROTECTED));
        LOGGER.info("Modifier.STATIC = " + Modifier.STATIC + " = 0x" +String.format("%08x",Modifier.STATIC));
        LOGGER.info("Modifier.FINAL = " + Modifier.FINAL + " = 0x" +String.format("%08x",Modifier.FINAL));
        LOGGER.info("Modifier.SYNCHRONIZED = " + Modifier.SYNCHRONIZED + " = 0x" +String.format("%08x",Modifier.SYNCHRONIZED));
        LOGGER.info("Modifier.VOLATILE = " + Modifier.VOLATILE + " = 0x" +String.format("%08x",Modifier.VOLATILE));
        LOGGER.info("Modifier.TRANSIENT = " + Modifier.TRANSIENT + " = 0x" +String.format("%08x",Modifier.TRANSIENT));
        LOGGER.info("Modifier.NATIVE = " + Modifier.NATIVE + " = 0x" +String.format("%08x",Modifier.NATIVE));
        LOGGER.info("Modifier.INTERFACE = " + Modifier.INTERFACE + " = 0x" +String.format("%08x",Modifier.INTERFACE));
        LOGGER.info("Modifier.ABSTRACT = " + Modifier.ABSTRACT + " = 0x" +String.format("%08x",Modifier.ABSTRACT));
        LOGGER.info("Modifier.STRICT = " + Modifier.STRICT + " = 0x" +String.format("%08x",Modifier.STRICT) + "\n");
        //一个由十六进制（取值范围：001~800）值组合的值，可以代表多个修饰符
        LOGGER.info("一个由十六进制（取值范围：001~800）值组合的值，可以代表多个修饰符");
        LOGGER.info("Modifier.toString(1 + 4 + 512) = " + Modifier.toString(1 + 4 + 512));
        LOGGER.info("Modifier.constructorModifiers() = " + Modifier.constructorModifiers() + " = " + Modifier.toString(Modifier.constructorModifiers()));
    }
}
