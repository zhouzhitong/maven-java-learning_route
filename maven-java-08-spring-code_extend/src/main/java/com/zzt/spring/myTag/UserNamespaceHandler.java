package com.zzt.spring.myTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 描述：<br>
 * 通过 META-INF/spring.handlers 文件注入 Spring容器中
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 9:41
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
