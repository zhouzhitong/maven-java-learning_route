package com.zzt.nio.channel;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;

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

    // 非阻塞式 服务端
    @Test
    public void serverNonBlockNioTest03() throws Exception {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(9988));

        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                SocketChannel accept;
                if (selectionKey.isAcceptable()) {
                    accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    accept = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    int len;
                    while ((len = accept.read(byteBuffer)) != -1) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }
                }
                iterator.remove();
            }
        }

    }

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

    /*@Test
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
    }*/


}
