package taest.thread.t20230601;

public class T {

    protected synchronized void m(){
        System.out.println("start TTTT");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end TTTT");
    }

    public static void main(String[] args) {
        new TT().m();
    }

}
class TT extends T{
    @Override
    protected synchronized void m() {
        System.out.println("true = " + true);
        super.m();
        System.out.println("true 11111= " + true);
    }
}