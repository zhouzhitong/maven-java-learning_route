package com.zzt.spring.myTag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/27 9:41
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        super.doParse(element, builder);
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");
        String email = element.getAttribute("email");

        if (StringUtils.hasText(username)){
            builder.addPropertyValue("username",username);
        }
        if (StringUtils.hasText(password)){
            builder.addPropertyValue("password",password);
        }
        if (StringUtils.hasText(email)){
            builder.addPropertyValue("email",email);
        }

    }
}
