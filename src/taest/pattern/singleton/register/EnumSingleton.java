package taest.pattern.singleton.register;

public enum EnumSingleton {

    INSTANCE;

    private static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
