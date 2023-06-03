package taest.thread.t20230602;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class T01AtomicInteger {

    AtomicInteger count = new AtomicInteger(0);

    public void m(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
            System.out.println("count = " + count);
        }

    }

    public static void main(String[] args) {
        T01AtomicInteger t01AtomicInteger = new T01AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t01AtomicInteger::m,"t1" + i));
        }
        threads.forEach(Thread::start);
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
