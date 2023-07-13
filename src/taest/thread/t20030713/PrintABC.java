package taest.thread.t20030713;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    private volatile static int value = 0;

    private int count;

    private ReentrantLock lock = new ReentrantLock();

    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public PrintABC(int count) {
        this.count = count;
    }

    class ThreadA implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (value % 3 != 0) {
                        conditionA.await();
                    }
                    System.out.println("A");
                    conditionB.signal();
                    value ++ ;
                }

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }
    }

    class ThreadB implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (value % 3 != 1) {
                        conditionB.await();
                    }
                    System.out.println("B");
                    conditionC.signal();
                    value ++ ;
                }

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }
    }

    class ThreadC implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (value % 3 != 2) {
                        conditionC.await();
                    }
                    System.out.println("C");
                    conditionA.signal();
                    value ++ ;
                }

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }
    }

    public void printABC() {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadC()).start();
    }


    public static void main(String[] args) {

        PrintABC printABC = new PrintABC(5);
        printABC.printABC();
    }
}
