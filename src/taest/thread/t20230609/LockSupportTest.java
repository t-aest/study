package taest.thread.t20230609;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    static Thread t1 = null,t2 = null;


    public static void main(String[] args) {
//        char[] a = new char[]{1,2,3,4,5,6};
        char[] a = "123456".toCharArray();
        char[] b = "ABCDEF".toCharArray();
        t1 = new Thread(()->{
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
//            LockSupport.unpark(t1);
        },"t1");
        t2 = new Thread(()->{
            for (int i = 0; i < b.length; i++) {
                LockSupport.park();
                System.out.println(b[i]);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
//        try {
//            Thread.sleep(1000);
//            LockSupport.unpark(t1);
//            LockSupport.unpark(t2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }
}
