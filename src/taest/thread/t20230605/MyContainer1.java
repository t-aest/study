package taest.thread.t20230605;

import java.util.LinkedList;

public class MyContainer1<T> {

    final private LinkedList<T> lists = new LinkedList<>();

    final private int MAX = 10;

    private int count = 0;

    public synchronized void put(T t){
        while (lists.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get(){
        while (lists.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = lists.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }
}
