package pers.hanchao.reflect.proxy;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>java.lang.reflect.Proxy示例</p>
 *
 * @author hanchao 2018/2/28 21:45
 **/
public class ReflectProxyDemo {
    private static final Logger LOGGER = Logger.getLogger(ReflectProxyDemo.class);

    /**
     * <p>示例 接口(动态代理只能代理接口)</p>
     *
     * @author hanchao 2018/2/28 22:04
     **/
    interface MyService {
        void print();

        void save();
    }

    /**
     * <p>示例 类</p>
     *
     * @author hanchao 2018/2/28 22:05
     **/
    static class MyServiceImpl implements MyService {

        @Override
        public void print() {
            LOGGER.info("MyServiceImpl打印信息...");
        }

        @Override
        public void save() {
            LOGGER.info("MyServiceImpl保存数据...");
        }
    }

    /**
     * <p>示例 调用处理器</p>
     *
     * @author hanchao 2018/2/28 22:05
     **/
    static class MyInvocationHandler implements InvocationHandler {
        /**
         * 被代理的对象
         */
        private Object proxiedObj;

        public MyInvocationHandler(Object object) {
            this.proxiedObj = object;
        }

        /**
         * 代理类的调用方法
         *
         * @param proxy  代理对象本身，用于反射获取信息或者连续代理
         * @param method 调用的方法
         * @param args   调用方法的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //如果是print方法，则直接打印
            if ("print".equals(method.getName())) {
                LOGGER.info("调用了MyInvocationHandler.invoke(proxy,method,args)...不需要事务控制...");
                method.invoke(proxiedObj, args);
            }
            //如果是save方法，则需要进行事务控制
            if ("save".equals(method.getName())) {
                LOGGER.info("调用了MyInvocationHandler.invoke(proxy,method,args)...需要事务控制...");
                LOGGER.info("~~~~~~~~~~~~~~~~开启事务~~~~~~~~~~~~~~~~");
                method.invoke(proxiedObj, args);
                LOGGER.info("~~~~~~~~~~~~~~~~提交或回滚事务（commit/rollback等）~~~~~~~~~~~~~~~~");
            }
            return proxy;
        }
    }

    /**
     * <p>Java反射-代理Proxy 示例</p>
     *
     * @author hanchao 2018/2/28 21:45
     **/
    public static void main(String[] args) throws Throwable {
        /**
         * 在Proxy类中，有成员变量：protected InvocationHandler h;
         * InvocationHandler是 代理实例 的调用处理程序
         */

        /*创建一个接口的 代理实例*/
        //被代理的接口 指定 实现类
        MyService myService = new MyServiceImpl();
        LOGGER.info("通过类实例调用方法：");
        myService.print();
        myService.save();
        System.out.println();

        LOGGER.info("=======================创建代理实例newProxyInstance=======================");
        //创建一个 调用处理器，并设置代理对象
        InvocationHandler invocationHandler = new MyInvocationHandler(myService);
        //创建代理实例
        LOGGER.info("通过Proxy.newProxyInstance(interface.class.getClassLoader,interface.class[],handler)创建代理实例。");
        MyService proxyInstance = (MyService) Proxy.newProxyInstance(//注意类型转换
                MyService.class.getClassLoader(),//接口的class loader
                new Class[]{MyService.class},//接口的类
                invocationHandler);//调用处理器
        //通过代理调用方法
        LOGGER.info("通过代理调用方法：");
        proxyInstance.print();
        proxyInstance.save();
        System.out.println();

        LOGGER.info("=======================获取调用处理器getInvocationHandler=======================");
        //通过Proxy.getInvocationHandler(proxyInstance)获取指定代理的调用处理器
        InvocationHandler invocationHandler1 = Proxy.getInvocationHandler(proxyInstance);
        LOGGER.info("通过Proxy.getInvocationHandler(proxyInstance)获取指定代理的调用处理器：" + invocationHandler1);
        LOGGER.info("通过代理Proxy的InvocationHandler成员变量执行方法：");
        invocationHandler1.invoke(proxyInstance,MyServiceImpl.class.getDeclaredMethod("save"),null);
        System.out.println();

        LOGGER.info("=======================判断是否代理类isProxyClass=======================");
        //通过Proxy.isProxyClass(clazz)判断是否是代理类
        LOGGER.info("通过Proxy.isProxyClass(clazz)判断是否是代理类 - proxyInstance = " + Proxy.isProxyClass(proxyInstance.getClass()));
        LOGGER.info("通过Proxy.isProxyClass(clazz)判断是否是代理类 - myService = " + Proxy.isProxyClass(myService.getClass()) + "\n");

        LOGGER.info("=======================获取代理类getProxyClass=======================");
        //通过Proxy.getProxyClass(interface.class.getClassLoader(),interface.class)获取代理类的Class对象
        Class proxyClass = Proxy.getProxyClass(MyService.class.getClassLoader(), MyService.class);
        LOGGER.info("通过Proxy.getProxyClass(interface.class.getClassLoader(),interface.class)获取代理类的Class对象:" + proxyClass);
        LOGGER.info("-----------------------通过构造方法创建代理实例getConstructor.newInstance-----------------------");
        //通过代理的构造器创建代理实例
        LOGGER.info("通过proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler)创建代理实例");
        MyService proxyInstance1 = (MyService) proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        proxyInstance1.save();
    }
}
