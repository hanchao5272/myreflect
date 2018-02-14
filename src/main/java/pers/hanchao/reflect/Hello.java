package pers.hanchao.reflect;

import org.apache.log4j.Logger;

/**
* <p>Junit4测试</p>
* @author hanchao 2018/2/14 22:17
*/
public class Hello {
    private static final Logger LOGGER = Logger.getLogger(Hello.class);
    public static int getOne(){
        LOGGER.info(1);
        return 1;
    }
}
