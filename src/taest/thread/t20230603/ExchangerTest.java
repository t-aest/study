package taest.thread.t20230603;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {

        new Thread(()->{
            String a = "T1";
            try {
                a = exchanger.exchange(a);
                System.out.println("a = " + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            String a = "T2";
            try {
                a = exchanger.exchange(a);
                System.out.println("b = " + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
