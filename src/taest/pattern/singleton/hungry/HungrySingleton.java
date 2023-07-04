package taest.pattern.singleton.hungry;

/**
 * 饿汉式
 */
public class HungrySingleton {

    private static final HungrySingleton instance;

    static {
        instance = new HungrySingleton();
    }

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
