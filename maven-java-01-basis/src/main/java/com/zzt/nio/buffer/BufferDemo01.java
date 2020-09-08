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
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byteBuffer.put("张三".getBytes());
        int capacity = byteBuffer.capacity();
        System.out.println(capacity);
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        byteBuffer.flip();
        byte[] array = byteBuffer.array();
        String string = new String(array);
        System.out.println(string);
    }


}
