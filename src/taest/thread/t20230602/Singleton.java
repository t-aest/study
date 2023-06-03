package taest.thread.t20230602;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class){
                if (null == instance){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    instance = new Singleton();
                }

            }
        }
        return instance;
    }

    public static void main(String[] args) {

//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//        System.out.println("singleton2 = " + (singleton1 == singleton2));
//        System.out.println("singleton2 = " + (singleton1.equals(singleton2)));
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton.getInstance().hashCode())).start();
        }
    }
}
