package pers.hanchao.reflect.common;
/**
* <p>用户表</p>
* @author hanchao 2018/2/14 22:30
*/
public class User {
    @MyAnnotationA
    @MyAnnotationB
    public String username = "张三";
    public int password = 123456;

    public User() {
    }

    public User(String username, int password) {
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

    public String getUsername() {
        return username;
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
