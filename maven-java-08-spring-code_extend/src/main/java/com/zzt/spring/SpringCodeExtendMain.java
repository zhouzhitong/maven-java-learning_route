package com.zzt.spring;

import com.zzt.spring.bean.TestBean;
import com.zzt.spring.context.MyClassPathXmlApplicationContext;
import com.zzt.spring.myTag.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 9:20
 */
public class SpringCodeExtendMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("application.xml");
//        User testBean = (User) applicationContext.getBean("1108");
//        System.out.println(testBean);
    }

    @Test
    public void selfTagTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/selfTagApplication.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }


}
