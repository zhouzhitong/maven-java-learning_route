package com.zzt.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 14:10
 */
public class FileChannelDemo01 {

    private String filePath = "C:\\Users\\Admin\\Desktop\\test.txt";
    private String filePath2 = "C:\\Users\\Admin\\Desktop\\aaa.txt";

    @Test
    public void test1() throws IOException {
        File file = new File(filePath);
        File file2 = new File(filePath2);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        FileChannel iChannel = fileInputStream.getChannel();
        FileChannel oChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        while ((iChannel.read(buffer)) != -1) {
            buffer.flip();
            oChannel.write(buffer);
            buffer.clear();
        }

        iChannel.close();
        oChannel.close();
        fileInputStream.close();
        fileOutputStream.close();

    }

}
