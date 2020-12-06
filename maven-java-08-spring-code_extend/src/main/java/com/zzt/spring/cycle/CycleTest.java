package com.zzt.spring.cycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/3 15:16
 */
public class CycleTest {

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("cycleBean.xml");
        AToB a = ac.getBean("a", AToB.class);
        BToA b = ac.getBean("b", BToA.class);
        /*System.out.println(a);
        System.out.println(b);*/

    }

}
