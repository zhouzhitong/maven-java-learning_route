package com.zzt.spring.selfEditor;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * 描述：<br>注册进spring容器的方式：
 * </>
 * 第一种：
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#propertyEditorRegistrars
 *
 */
public class AddressPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        registry.registerCustomEditor(Address.class, new AddressPropertyEditor());
    }
}
