package pers.hanchao.reflect.array;

import org.apache.log4j.Logger;

import java.lang.reflect.Array;

/**
 * java.lang.reflect.Array示例
 * Created by 韩超 on 2018/2/24.
 */
public class ReflectArrayDemo {
    private final static Logger LOGGER = Logger.getLogger(ReflectArrayDemo.class);

    /**
     * <p>Title: java.lang.reflect.Array示例</p>
     *
     * @author 韩超 2018/2/24 15:42
     */
    public static void main(String[] args) {
        /*
        static Object newInstance(Class<?> componentType, int dimensions)
         */
        LOGGER.info("利用Array.newInstance创建一维数组");
        //利用Array.newInstance创建一维数组
        int rows = 3;
        int cols = 2;
        Integer[] array = (Integer[]) Array.newInstance(Integer.class, rows);
        //static void set(Object array, int index, Object value)
        //通过Array.set设置数组的值
        LOGGER.info("通过Array.set设置数组的值");
        Array.set(array, 0, 110);
        Array.set(array, 1, 119);
        Array.set(array, 2, 120);
        /*
        下面语句运行报错IllegalArgumentException: Argument is not an array
        因为array是引用类型的数组
         */
//        Array.setInt(array,2,120);
        //static Object get(Object array, int index)
        //通过Array.get获取数组的值
        LOGGER.info("通过Array.get获取数组的值");
        for (int i = 0; i < 3; i++) {
            LOGGER.info(Array.get(array, i));
        }
        /*
        下面语句运行报错IllegalArgumentException: Argument is not an array
        因为array是引用类型的数组
         */
//        LOGGER.info(Array.getInt(array,2));

        /*
        static Object newInstance(Class<?> componentType, int length)
         */
        LOGGER.info("利用Array.newInstance创建多维数组");
        //利用Array.newInstance创建多维数组
        Double[][] arraymn = (Double[][]) Array.newInstance(Double.class, rows, cols);
        Array.set(arraymn[0], 0, 1D);
        Array.set(arraymn[0], 1, 2D);
        Array.set(arraymn[1], 0, 11D);
        Array.set(arraymn[1], 1, 12D);
        Array.set(arraymn[2], 0, 21D);
        Array.set(arraymn[2], 1, 22D);
        for (Double[] arrayn : arraymn) {
            for (Double item : arrayn) {
                LOGGER.info(item);
            }
        }

        /*
        基本类型数组操作
        static void setInt(Object array, int index, int i)
        static double getDouble(Object array, int index)
        8中基本类型：boolean/char/float/double/byte/int/short/long
         */
        LOGGER.info("Array.setXxxx和Array.getXxxx");
        int[] ints = new int[3];
        LOGGER.info("通过Array.setInt设置int基本数据类型的数据");
        Array.setInt(ints, 0, 110);
        Array.setInt(ints, 1, 110);
        //可以通过Array.set设置double基本数据类型的数据
        LOGGER.info("可以通过Array.set设置double基本数据类型的数据");
        Array.set(ints, 2, 110);
        for (int i = 0; i < 3; i++) {
            LOGGER.info("通过Array.getDouble获取double基本数据类型的数据：" + Array.getDouble(ints, i));
        }
        LOGGER.info("可以通过Array.get获取double基本数据类型的数据：" + Array.get(ints, 0));
    }
}
