//package taest.thread.t20230604;
//
//import java.lang.invoke.MethodHandle;
//import java.lang.invoke.MethodHandles;
//import java.lang.invoke.VarHandle;
//
//public class VarHandleTest {
//
//    private int x = 8;
//
//    private static VarHandle varHandle;
//
//    static {
//        try {
//            varHandle = MethodHandles.lookup().findVarHandle(VarHandleTest.class, "x", int.class);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        VarHandleTest varHandleTest = new VarHandleTest();
//        System.out.println(varHandle.get(varHandleTest));
//        varHandle.set(varHandleTest,9);
//        System.out.println("varHandleTest = " + varHandle.get(varHandleTest));
//        varHandle.compareAndSet(varHandleTest,9,10);
//        System.out.println("varHandleTest = " + varHandleTest.x);
//        varHandle.getAndAdd(varHandleTest,10);
//        System.out.println("varHandleTest = " + varHandleTest.x);
//        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
//        ThreadLocal<Object> objectThreadLocal1 = new ThreadLocal<>();
//        objectThreadLocal.set(1);
//        System.out.println("objectThreadLocal.get() = " + objectThreadLocal.get());
//        objectThreadLocal1.set(2);
//        System.out.println("objectThreadLocal.get() = " + objectThreadLocal1.get());
//
//    }
//}
