package pers.hanchao.reflect.common;

/**
 * <p>用户表</p>
 *
 * @author hanchao 2018/2/14 22:30
 */
@MyAnnotationA
@MyAnnotationB
public class User extends SuperUser implements InterfaceAAA,InterfaceBBB {
    @MyAnnotationA
    @MyAnnotationB
    public String username = "张三";
    private int password = 123456;

    public User() {
    }

    @MyAnnotationA
    @MyAnnotationB
    public User(@MyAnnotationA @MyAnnotationB String username,@MyAnnotationA int password) throws NullPointerException, ArrayStoreException {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';

    }

    /**
     * <p>Title: 为了测试可变参数</p>
     *
     * @author 韩超 2018/2/28 17:32
     */
    public void demo(String... args) {

    }

    /**
     * <p>Title: 泛型方法：为了测试method.getTypeParameters()参数化类型</p>
     *
     * @author 韩超 2018/2/28 17:30
     */
    public static <T> void test(T t) {
    }

    /**
     * <p>Title: 为了测试注解、异常</p>
     *
     * @author 韩超 2018/2/28 17:31
     */
    @MyAnnotationA
    @MyAnnotationB
    public String getUsername() throws NullPointerException, ArrayStoreException {
        return username;
    }

    /**
     * <p>Title: method.getParameterAnnotations()示例</p>
     *
     * @author 韩超 2018/2/28 16:55
     */
    public static void main(String[] args) {

    }

    public void initUser(@MyAnnotationA @MyAnnotationB String username, @MyAnnotationB String password) {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
