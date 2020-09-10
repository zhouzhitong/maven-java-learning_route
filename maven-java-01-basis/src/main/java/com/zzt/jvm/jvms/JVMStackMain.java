package com.zzt.jvm.jvms;

/**
 * 描述：<br>2. 虚拟机栈讲解：
 * 具体网址：https://blog.csdn.net/First_Bal/article/details/108498517
 * <p>
 * 1. '栈' 基本定义：- 每个线程只能有一个活动栈帧，对应着当前正在执行的方法
 * '栈帧'定义： --- 每个方法体对应一个栈帧。
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/10 14:36
 */
public class JVMStackMain {
    public static void main(String[] args) {
        stackTest01();  // 测试：栈 和 栈帧 结构
//        stackTest02();    // 测试： 栈内存溢出
    }

    private static void stackTest01() {
        Thread thread1 = new Thread(Demo::stackDemo01);
        Thread thread2 =new Thread(Demo::stackDemo01);
        thread1.start();
        thread2.start();
    }

    private static void stackTest02() {
        stackTest03();
    }

    private static void stackTest03() {
        stackTest02();
    }

    private static class Demo {
        private static void stackDemo01() {
            stackDemo02();
        }
        private static String stackDemo02() {
            return "byte";
        }
    }
}
