package com.zzt.creation.singletion;

/**
 * 描述：<br>单例设计模式：
 * 实现方式：(8种)
 *      1. 饿汉式： 静态常量 、 静态代码块【不推荐使用】
 *      2. 懒汉式： 线程不安全的、线程安全的【同步方法、同步代码块（双重检查）】
 *      3. 静态内部类
 *      4. 枚举
 * 总结：
 *
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/5 10:10
 **/
public class ClientSingleton {

    public static void main(String[] args) {
//        singletonTest1();
        singletonTest4() ;
    }

    private static void singletonTest1(){
        SingletonDemo01 singleton1 = SingletonDemo01.getInstance1() ;
        SingletonDemo01 singleton2 = SingletonDemo01.getInstance2() ;
        System.out.println(singleton1==singleton2);
    }

    private static void singletonTest4(){
        SingletonDemo04 instance = SingletonDemo04.INSTANCE ;
        instance.setName("张三");
        instance.sayok();
        System.out.println(instance.name());
    }

}

/**
 * 1. 饿汉式【静态常量、静态代码块】
 *
 * 优点：
 *      (1) 线程安全，类在被加载时就会启动。
 *      (2) 这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *
 * 缺点：
 *      (1) 浪费资源
 *      (2) 在类装载的时候就完成实例化，没有达到 Lazy Loading 的效果。
 *          如果从始至终从未使用过这个实例，则会造成内存的浪费
 *
 */
class SingletonDemo01 {
    /**
     * 1.1 静态常量
     */
    private static SingletonDemo01 instance1 = new SingletonDemo01();

    /**
     * 1.2 静态代码块
     */
    private static SingletonDemo01 instance2;
    static {
        System.out.println("123");
        instance2 = new SingletonDemo01();
    }

    public SingletonDemo01() {
    }

    public static SingletonDemo01 getInstance1(){
        return instance1 ;
    }

    public static SingletonDemo01 getInstance2(){
        return instance2 ;
    }
}
/**
 * 2. 懒汉式【线程不安全，线程安全、双重检查】
 *
 * 特点：
 *      (1) 懒汉式创建对象，线程不安全【不推荐】
 *      (2) 同步方法，实现创建对象，方法进行同步效率太低【不推荐】
 *      (3) 同步代码块，实现创建对象，可能出现线程不安全【不推荐】
 *      (4) 同步代码块+双重检查，实现创建对象，延迟加载； 效率较高【推荐使用】
 * 总结：
 *      (1) <br>推荐使用:</> 同步代码块+双重检查
 */
class SingletonDemo02{

    private static SingletonDemo02 instance ;
    private static final Object object = new Object() ;
    public SingletonDemo02() {}

    /**
     * 2.1 线程不安全
     * @return {@link SingletonDemo02} 实例化对象
     */
    public static SingletonDemo02 getInstance1(){
        if (instance == null){
            instance = new SingletonDemo02() ;
        }
        return instance ;
    }

    /**
     * 2.2 线程安全【同步代码块】
     * @return {@link SingletonDemo02} 实例化对象
     */
    public static synchronized SingletonDemo02 getInstance2(){
        if (instance == null){
            instance = new SingletonDemo02() ;
        }
        return instance ;
    }

    /**
     * 2.2 线程安全【同步方法】
     * @return {@link SingletonDemo02} 实例化对象
     */
    public static SingletonDemo02 getInstance3(){
        synchronized (object){
            if (instance == null){
                instance = new SingletonDemo02() ;
            }
        }
        return instance ;
    }

    /**
     * 2.3 线程安全【同步方法、双重检查】
     * @return {@link SingletonDemo02} 实例化对象
     */
    public static synchronized SingletonDemo02 getInstance4(){
        if (instance == null){
            synchronized (object){
                if (instance == null){
                    instance = new SingletonDemo02() ;
                }
            }
        }

        return instance ;
    }

}
/**
 * 3. 静态内部类：【推荐使用】
 * 知识点补充：
 *     1. 静态内部类特点：
 *          （1）
 * 特点：
 *      (1) 这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
 *      (2) 静态内部类方式在 Singleton 类被装载时并不会立即实例化，而是在需要实例化时，
 *          调用 getInstance 方法，才会装载 SingletonInstance 类，从而完成 Singleton 的实例化。.
 *      (3) 类的静态属性只会在第一次加载类的时候初始化，所以在这里，
 *          JVM 帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。.
 * 优点：
 *      (1) 避免了线程不安全，利用 静态内部类特点实现延迟加载，效率高
 */
class SingletonDemo03{
    // private static volatile SingletonDemo03 instance ;

    private static class SingletonInstance{
        private static final SingletonDemo03 INSTANCE = new SingletonDemo03() ;
    }

    public static SingletonDemo03 getInstance() {
        return SingletonInstance.INSTANCE;
    }


}
/**
 * 4. 枚举：【推荐使用】
 *
 */
enum SingletonDemo04{
    /**
     * 属性
     */
    INSTANCE("RED") ;

    SingletonDemo04(){
        System.out.println("调用构造方法---");
    }
    private String name ;

    SingletonDemo04(String name){
        this.name = name ;
    }

    /**
     * 行为方法
     */
    public void sayok(){
        System.out.println("OK~~~" + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}