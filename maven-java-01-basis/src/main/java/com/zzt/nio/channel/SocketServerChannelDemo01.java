package com.zzt.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/8 22:30
 **/
public class SocketServerChannelDemo01 {

    private String filePathServer = "D:\\data\\server\\goddess.jpg";

    @Test
    public void serverSocketTest02() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9988));
        SocketChannel accept = channel.accept();
        System.out.println("收到客户端请求！！！");
        FileChannel fileChannel = FileChannel.open(Paths.get(filePathServer)
                , StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (accept.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        accept.shutdownInput();
        System.out.println("数据接收完成");
        byteBuffer.put("你好，已经数据接收到！！！".getBytes());
        byteBuffer.flip();
        accept.write(byteBuffer);

        accept.close();
        fileChannel.close();
        channel.close();
    }

    @Test
    public void serverSocketTest() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9988));
        SocketChannel accept = channel.accept();

        FileChannel fileChannel = FileChannel.open(Paths.get(filePathServer)
                , StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (accept.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        System.out.println("数据接收完成！！！");

        accept.close();
        channel.close();
    }


}
