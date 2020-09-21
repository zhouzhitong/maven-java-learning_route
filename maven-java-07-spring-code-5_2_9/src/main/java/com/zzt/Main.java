package com.zzt;

import com.zzt.bean.A;
import com.zzt.bean.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 8:40
 **/
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        B b = applicationContext.getBean(B.class);
        System.out.println(b);
//        A bean = (A) applicationContext.getBean("aFactoryBean");

        A bean = applicationContext.getBean(A.class);
        System.out.println(bean);
        bean.setAge(11);
        System.out.println(bean);

        A bean2 = applicationContext.getBean(A.class);
        A bean3 = applicationContext.getBean(A.class);
        System.out.println(bean2);
        System.out.println(bean3);

    }

}
