package com.zzt.io.ioStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/4 9:52
 */
public class IOStreamTest {

    private static String filePath = "C:\\Users\\Admin\\Desktop\\test.txt";

    // 字节输入流
    private static void byteInputStream() throws Exception {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream stream = new BufferedInputStream(inputStream);

        byte[] bytes = new byte[1024];
        int count = 1;
        while (stream.read(bytes) != -1) {
            System.out.println("第 " + (count++) + " 次 " + "10个字节长度：" + new String(bytes, StandardCharsets.UTF_8));
        }
        stream.close();
    }

    // 字节输出流
    private static void byteOutput() throws Exception {
        File file = new File(filePath);
        FileOutputStream stream = new FileOutputStream(file);
        String s = "测试输入流!!!";
        stream.write(s.getBytes(StandardCharsets.UTF_8), 0, 15);  // 输出：测试输入流
//        stream.write(s.getBytes(StandardCharsets.UTF_8),15,2);  // 输出：!!
        stream.close();
    }

    // 字符输入流
    private static void reader() throws Exception {
        FileReader fileReader = new FileReader(new File(filePath));

        BufferedReader reader = new BufferedReader(fileReader);

        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(" --- " + s);
        }
    }

    public static void main(String[] args) throws Exception {

//        byteOutput();
        byteInputStream();
//        reader();
    }

}
