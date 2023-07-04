package taest.pattern.singleton;

/**
 * 防止序列化对象不一致
 */
public class SerializationSingleton {
    private static final SerializationSingleton instance;

    static {
        instance = new SerializationSingleton();
    }

    private SerializationSingleton(){

    }

    public static SerializationSingleton getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}
