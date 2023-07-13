package taest.thread.t20030713;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProviderConsumer<T> {

    private int length;

    private Queue<T> queue;

    private ReentrantLock lock = new ReentrantLock();

    private Condition provide = lock.newCondition();
    private Condition consume = lock.newCondition();

    public ProviderConsumer(int length) {
        this.length = length;
        this.queue = new LinkedList<T>();
    }

    public void provide(T product) {
        lock.lock();
        try {
            while (queue.size() >= length) {
                provide.await();
                System.out.println("装满了");
            }
            queue.add(product);
            System.out.println("add queue = " + product);
            consume.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public T consume() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                consume.await();
                System.out.println("消费完了");
            }
            T result = queue.remove();
            System.out.println("消费了 = " + result);
            provide.signal();
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            lock.unlock();
    }
}
}
