package taest.thread.t20230609;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.LockSupport;

public class BlockingQueneTest {

    static BlockingQueue<String> q1 = new ArrayBlockingQueue(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue(1);



    public static void main(String[] args) {
        char[] a = "123456".toCharArray();
        char[] b = "ABCDEF".toCharArray();
       new Thread(()->{
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
                try {
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            LockSupport.unpark(t1);
        },"t1").start();
        new Thread(()->{
            for (int i = 0; i < b.length; i++) {
                try {
                    q2.put("okaaa");
                    q1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(b[i]);
            }
        },"t2").start();
//        try {
//            Thread.sleep(1000);
//            LockSupport.unpark(t1);
//            LockSupport.unpark(t2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
