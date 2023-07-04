package taest.pattern.singleton.lazy;

/**
 * 懒汉式
 */
public class LazySingleton {

    private LazySingleton(){}

    private volatile static  LazySingleton instance  = null;

    public static LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    return new LazySingleton();
                }
            }
        }
        return instance;
    }
}
