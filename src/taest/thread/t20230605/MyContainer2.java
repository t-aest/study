package taest.thread.t20230605;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer2<T> {

    final private LinkedList<T> lists = new LinkedList<>();

    private Lock lock = new ReentrantLock();

    private Condition producer  = lock.newCondition();

    private Condition customer  = lock.newCondition();
    final private int MAX = 10;

    private int count = 0;

    public void put(T t){
        try {
            lock.lock();
            while (lists.size() == MAX){
                producer.wait();
            }
            lists.add(t);
            ++count;
            customer.signalAll();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        try {
            lock.lock();
            while (lists.size() == 0){
                customer.wait();
            }
            T t = lists.removeFirst();
            count--;
            producer.signalAll();
            return t;
        } catch (InterruptedException e){
            e.printStackTrace();
            return null;
        }finally {
            lock.unlock();
        }
    }
}
