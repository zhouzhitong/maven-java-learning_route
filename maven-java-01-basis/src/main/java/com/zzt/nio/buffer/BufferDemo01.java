package com.zzt.nio.buffer;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 10:51
 */
public class BufferDemo01 {

    @Test
    public void test() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String str = "6212261001100235339\n" +
                "360425199809012818\n" +
                "1. 基于Java EE技术的学校的问卷调查系统的设计与实现\n" +
                "2. 基于B/S架构的工厂物料管理系统的设计与实现";
        byteBuffer.put(str.getBytes());
        int capacity = byteBuffer.capacity();
        System.out.println(capacity);
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byteBuffer.flip();

        System.out.println(capacity);
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());

        byte[] array = byteBuffer.array();
        String string = new String(array);
        System.out.println(string);
    }


}
