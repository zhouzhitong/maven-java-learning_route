package com.zzt.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 22:21
 **/
public class SocketClientChannelDemo01 {

    private String filePathClient = "D:\\data\\client\\goddess.jpg";

    // 非阻塞式 客户端
    @Test
    public void clientNonBlockingNioTest03() throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));
        channel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("再见了，朋友！！！".getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        byteBuffer.clear();

        channel.close();
    }

    @Test
    public void clientTest02() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));

        FileChannel fileChannel = FileChannel.open(Paths.get(filePathClient), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.shutdownOutput();

        int len;
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(), 0, len));
            byteBuffer.clear();
        }

        fileChannel.close();
        socketChannel.close();
    }

    /*@Test
    public void clientTest01() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9988));

        FileChannel fileChannel = FileChannel.open(Paths.get(filePathClient), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        System.out.println("数据发送完成！！！");
        socketChannel.close();
    }*/

}
