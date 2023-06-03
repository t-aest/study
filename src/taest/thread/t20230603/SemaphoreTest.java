package taest.thread.t20230603;

import java.util.concurrent.Semaphore;

/**
 * 控制同时能运行的线程数
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("semaphore start");
                Thread.sleep(1000);
                System.out.println("semaphore end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();

        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("semaphore111 start");
                Thread.sleep(1000);
                System.out.println("semaphore111 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }).start();
    }
}
