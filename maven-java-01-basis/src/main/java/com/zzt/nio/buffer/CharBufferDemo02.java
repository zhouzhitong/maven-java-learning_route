package com.zzt.nio.buffer;

import org.junit.jupiter.api.Test;
import java.nio.CharBuffer;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/9 13:06
 */
public class CharBufferDemo02 {

    @Test
    public void test01() {
        CharBuffer buffer = CharBuffer.allocate(1024);
        String str = "架构的工厂物料管理系";
//                + "2. 基于B/S架构的工厂物料管理系统的设计与实现";
        buffer.put(str.toCharArray());
        char[] cs = new char[buffer.limit()];
        System.out.println(buffer.limit());
        buffer.get(cs);
        System.out.println(str.length());
        System.out.println(new String(cs));

    }
}
