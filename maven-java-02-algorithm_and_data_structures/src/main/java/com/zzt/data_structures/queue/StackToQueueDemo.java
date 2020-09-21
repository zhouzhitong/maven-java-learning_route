package com.zzt.data_structures.queue;

import java.util.Queue;
import java.util.Stack;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/21 9:47
 **/
public class StackToQueueDemo {

    public static void main(String[] args) {
        QueueByStack<Integer> queue = new QueueByStack<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }

}

class QueueByStack<T> {
    private Stack<T> data;
    private Stack<T> help;

    public QueueByStack() {
        this.data = new Stack<>();
        this.help = new Stack<>();
    }

    public void offer(T t) {
        while (!data.isEmpty()) {
            help.push(data.pop());
        }
        help.push(t);
        while (!help.isEmpty()) {
            data.push(help.pop());
        }
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public T poll() {
        return data.pop();
    }

    public void println(){
        data.forEach(a-> System.out.print(a+" "));
    }

}
