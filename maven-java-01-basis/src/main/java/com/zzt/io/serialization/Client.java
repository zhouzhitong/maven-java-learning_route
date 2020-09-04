package com.zzt.io.serialization;

import java.io.*;
import java.util.Date;

/**
 * 描述：<br> 序列化测试：
 *      serialVersionUID的作用是，验证 版本号【在JVM底层实现】。当不同时，会出现异常信息：InvalidCastException
 *      1. Serialization：
 * 结论：
 *      1. transient 关键字：让其修饰的属性，不能序列化。
 *      2. 在JVM层面上实现对象的创建
 *      2. Externalizable：
 * 结论：
 * 1.
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/3 14:27
 */
public class Client {
    private static String filePath = "C:\\Users\\Admin\\Desktop\\test.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serialization();
//        antiSerialization();
//        externalizable();
        antiExternalizable();
    }

    // 1.1 序列化 Serialization
    private static void serialization() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);
        Bean bean = new Bean(1L, "张三", new Date());
        stream.writeObject(bean);
    }

    // 1.2 反序列化 Serialization
    private static void antiSerialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream stream = new ObjectInputStream(fileInputStream);
        Bean bean = (Bean) stream.readObject();
        System.out.println(bean);
    }

    // 2.1 序列化 Externalizable
    private static void externalizable() throws IOException {
        Person person = new Person(1L, "张三", "第一个测试用例");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
        out.writeObject(person);
        out.close();
    }

    // 2.1 序列化 Externalizable
    private static void antiExternalizable() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream stream = new ObjectInputStream(fileInputStream);
        Person person = (Person) stream.readObject();
        System.out.println(person);
    }

}
