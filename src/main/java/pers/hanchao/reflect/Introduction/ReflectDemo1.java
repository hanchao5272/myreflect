package pers.hanchao.reflect.Introduction;

/**
 * 反射入门示例
 * Created by 韩超 on 2018/2/24.
 */
public class ReflectDemo1 {
    public Integer demo;

    public ReflectDemo1(Integer demo) {
        this.demo = demo;
    }

    public Integer getDemo() {
        return demo;
    }

    public void setDemo(Integer demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "ReflectDemo1{" +
                "demo=" + demo +
                '}';
    }
}
