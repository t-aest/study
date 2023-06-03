package taest.thread.t20230602;

public class T01 {

    private static volatile boolean running = true;
    void m(){
        System.out.println("start = " + true);
        while (running){

        }
        System.out.println("end = " + true);
    }

    public static void main(String[] args) {
        T01 t01 = new T01();
        new Thread(t01::m,"t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        running = false;
    }
}
