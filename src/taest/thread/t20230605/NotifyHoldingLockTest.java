package taest.thread.t20230605;

import java.util.ArrayList;
import java.util.List;

public class NotifyHoldingLockTest {

    volatile static List<Object> list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }
    public int size(){
        return list.size();
    }


    public static void main(String[] args) {
        NotifyHoldingLockTest notifyHoldingLockTest = new NotifyHoldingLockTest();
        final Object lock = new Object();
        Thread t1 = new Thread(()->{
            synchronized (lock){
                System.out.println("t1  start");
                if (notifyHoldingLockTest.size()!=5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("t1  end");
                lock.notify();
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("i = " + i);
                    notifyHoldingLockTest.add(new Object());
                    if (notifyHoldingLockTest.size() == 5){
                        //并没有释放锁  只是通知
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
        t2.start();
    }
}
