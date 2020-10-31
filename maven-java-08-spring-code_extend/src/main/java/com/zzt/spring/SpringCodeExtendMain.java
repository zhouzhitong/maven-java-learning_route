package com.zzt.spring;

import com.zzt.spring.bean.TestBean;
import com.zzt.spring.myTag.User;
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

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

        User user = applicationContext.getBean("user",User.class);
        System.out.println(user);

//        User testBean = (User) applicationContext.getBean("1108");
//        System.out.println(testBean);

    }
}
