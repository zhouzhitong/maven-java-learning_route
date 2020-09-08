package com.zzt.nio.channel;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 14:10
 */
public class FileChannelDemo01 {

    private String filePath = "D:\\BaiduNetdiskDownload\\尚硅谷JDK8新特性+JUC+NIO\\juc\\juc.zip";
    private String filePath2 = "D:\\aaa.zip";

    private static long start;

    @BeforeAll
    static void init() {
        start = System.currentTimeMillis();
    }

    @AfterAll
    static void destroy() {
        System.out.println("总共耗费时间：--> " + (System.currentTimeMillis() - start));
    }

    @Test
    public void test2() throws IOException {// 1372ms - 1271ms
        FileChannel read = null;
        FileChannel write = null;
        try {
            read = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ);
            write = FileChannel.open(Paths.get(filePath2), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            MappedByteBuffer readMap = read.map(MapMode.READ_ONLY, 0, read.size());
            MappedByteBuffer writeMap = write.map(MapMode.READ_WRITE, 0, read.size());
            byte[] dst = new byte[readMap.limit()];
            readMap.get(dst);
            writeMap.put(dst);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            read.close();
            write.close();
        }


    }

    @Test
    public void test21() throws IOException {
        FileChannel read = null;
        try {
            read = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ);
            MappedByteBuffer map = read.map(MapMode.READ_ONLY, 0, read.size());
            byte[] bytes = new byte[map.limit()];
            map.get(bytes);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            read.close();
        }
    }

    @Test
    public void test1() throws IOException { // 10240ms - 10812ms
        File file = new File(filePath);
        File file2 = new File(filePath2);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        FileChannel iChannel = fileInputStream.getChannel();
        FileChannel oChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
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
