package taest.thread.t20230603;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。
 * 它相当于是一个计数器，这个计数器的初始值就是线程的数量，
 * 每当一个任务完成后，计数器的值就会减一，当计数器的值为 0 时，表示所有的线程都已经任务了，
 * 然后在 CountDownLatch 上等待的线程就可以恢复执行接下来的任务。
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        usingCountDownLatch();
    }

    static void usingCountDownLatch(){
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
                countDownLatch.countDown();
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end ");
    }

    static void usingJoin(){
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for (int j = 0; j < 10000; j++) {
                    result += j;
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
