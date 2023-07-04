package taest.pattern.singleton.lazy;

/**
 * 内部类方式
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){
        if (Lazy.INSTANCE != null){
            throw new RuntimeException("非法访问");
        }
    }

    private InnerClassSingleton getInstance(){
        return Lazy.INSTANCE;
    }

    private static class Lazy{
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
