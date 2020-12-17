package com.zzt.aop;

import com.zzt.aop.service.Calculator;
import com.zzt.aop.service.MyCalculator;
import com.zzt.aop.service.SecondCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 描述：<br>
 </>
 @author zzt */
public class AopTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aopBean.xml");
        MyCalculator bean = ac.getBean("myCalculator", MyCalculator.class);
        Calculator calculator = (Calculator) ac.getBean("secondCalculator");

        Integer add = bean.add(1, 1);
        System.out.println(add);

        Integer mul = calculator.mul(2, 4);
        System.out.println(mul);
    }
}
