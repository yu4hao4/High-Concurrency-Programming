package com;

import java.util.concurrent.TimeUnit;

/**
 * @author 喻浩
 * @create 2020-01-01-下午9:14
 */
public class SynchronizedDemo01 {
    //修饰静态方法
    
    public synchronized static void accessResources0(){
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+" is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //修饰非静态方法
    //代码块１（对象）ｔｈｉｓ　指的是当前对象
    public void accessResources1(){
        synchronized (this) {
            try {
                TimeUnit.MINUTES.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //代码块１（ＣＬＡＳＳ)
    public void accessResources４(){
        synchronized (SynchronizedDemo01.class) {// ClassLoader class --->　堆　Class   所有的对象
            //有 Class 对象的所有的对象都共同使用这一个锁
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static void main(String[] args) {
        SynchronizedDemo01 demo01 = new SynchronizedDemo01();
        for (int i = 0; i < 5; i++) {
            new Thread(demo01::accessResources1).start();
        }
        
        
    }
}
