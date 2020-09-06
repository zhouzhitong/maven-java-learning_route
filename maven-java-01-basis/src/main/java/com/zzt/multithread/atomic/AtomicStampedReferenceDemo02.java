package com.zzt.multithread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/5 23:26
 **/
public class AtomicStampedReferenceDemo02 {
    static AtomicStampedReference<Integer> n;
    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        while(j<100){
            n = new AtomicStampedReference<>(0, 0);
            Thread t1 = new Thread(() -> {
                for(int i=0; i<1000; i++){
                    int stamp;
                    Integer reference;
                    do{
                        stamp = n.getStamp();
                        reference = n.getReference();
                    } while(!n.compareAndSet(reference, reference+1, stamp, stamp+1));
                }
            });
            Thread t2 = new Thread(() -> {
                for(int i=0; i<1000; i++){
                    int stamp;
                    Integer reference;
                    do{
                        stamp = n.getStamp();
                        reference = n.getReference();

                    } while(!n.compareAndSet(reference, reference+1, stamp, stamp+1));
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("n的最终值是："+n.getReference());
            j++;
        }

    }
}
