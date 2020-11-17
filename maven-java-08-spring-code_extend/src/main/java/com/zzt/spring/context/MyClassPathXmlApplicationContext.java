package com.zzt.spring.context;

import com.zzt.spring.bdrpp.MyUserBeanDefinitionRegistryPostProcessor;
import com.zzt.spring.selfEditor.Address;
import com.zzt.spring.selfEditor.AddressPropertyEditor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/31 23:43
 **/
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        super.postProcessBeanFactory(beanFactory);
//        super.addBeanFactoryPostProcessor(new MyUserBeanDefinitionRegistryPostProcessor());
        // TODO 自定义属性编辑器注册 -- 方式三
        beanFactory.registerCustomEditor(Address.class, AddressPropertyEditor.class);
    }

    @Override
    protected void initPropertySources() {
        super.initPropertySources();
    }

    @Override
    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        super.registerBeanPostProcessors(beanFactory);
        // TODO 自定义属性编辑器注册 -- 方式三
//        beanFactory.registerCustomEditor(Address.class, AddressPropertyEditor.class);
    }
}
