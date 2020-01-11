package com;

/**
 * @author 喻浩
 * @create 2019-12-23-下午7:36
 */
public class TIcketDemo extends Thread {
    private static int index = 1;
    private static final int Max = 50000;

    @Override
    public void run() {
        synchronized (this){
            while (index < Max){
                System.out.println(Thread.currentThread().getName()+"叫到的号码是"+(index++));
            }
        }
    }

    public static void main(String[] args) {
        TIcketDemo t1 = new TIcketDemo();
        TIcketDemo t2 = new TIcketDemo();
        TIcketDemo t3 = new TIcketDemo();
        TIcketDemo t4 = new TIcketDemo();
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
