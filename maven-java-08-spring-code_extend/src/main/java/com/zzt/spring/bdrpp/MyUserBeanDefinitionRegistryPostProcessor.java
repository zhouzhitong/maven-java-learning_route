package com.zzt.spring.bdrpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;

/**
 * 描述：<br>
 * 注册方式：
 *  - 1. application.xml 配置文件的加入
 *      <bean class="com.zzt.spring.bdrpp.MyUserBeanDefinitionRegistryPostProcessor"/>
 *
 *  - 2. 通过 AbstractApplicationContext 类实现添加功能
 * @see org.springframework.context.support.AbstractApplicationContext#addBeanFactoryPostProcessor(BeanFactoryPostProcessor)
 * @see com.zzt.spring.context.MyClassPathXmlApplicationContext
 *      postProcessBeanFactory(ConfigurableListableBeanFactory) {
 *          super.addBeanFactoryPostProcessor(new MyUserBeanDefinitionRegistryPostProcessor());
 *      }
 *
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/31 23:38
 **/
public class MyUserBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("执行了" + MyUserBeanDefinitionRegistryPostProcessor.class + "类的 postProcessBeanDefinitionRegistry() 方法!!!");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
