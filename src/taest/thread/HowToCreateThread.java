package taest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.LockSupport;

public class HowToCreateThread {
    static class MyThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("true = " + true);
        }
    }

    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("true1 = " + true);
        }
    }

    static class MyThread3 implements Callable {


        @Override
        public Object call() throws Exception {
            return null;
        }
    }
    public static void main(String[] args) {
        new Thread(new MyThread2()).start();
        new Thread(()->{
            System.out.println("args = " + args);
        }).start();


    }

}
