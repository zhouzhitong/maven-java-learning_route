package com.zzt.spring.selfEditor;

import java.beans.PropertyEditorSupport;
import java.util.logging.Logger;

/**
 * 描述：<br>将 属性编辑器 注册进spring容器的方式：
 * </>
 * <p>
 * 第一种方式：在 selfEditor.xml 配置文件中配置文件。
 * {@link org.springframework.beans.factory.config.CustomEditorConfigurer#propertyEditorRegistrars}
 * <p>
 * 第二种方式：在 selfEditor.xml 配置文件中配置文件。
 * {@link org.springframework.beans.factory.config.CustomEditorConfigurer#customEditors}
 * <p>
 * 第三种方式：
 * {@link com.zzt.spring.context.MyClassPathXmlApplicationContext}
 * （可以在任意扩展的地方添加，但要在创建 bean 对象之前添加有效）
 * <p>
 * 第二种
 */
public class AddressPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] infos = text.split("_");
        if (infos.length > 2) {
            Address address = new Address();
            address.setProvince(infos[0]);
            address.setCity(infos[1]);
            address.setTown(infos[2]);
            super.setValue(address);
        } else {
            System.out.println(Address.class + "解析失败！！！");
//            super.setValue(null);
            throw new RuntimeException(Address.class + "解析失败！！！");
        }


    }
}
