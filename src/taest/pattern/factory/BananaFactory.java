package taest.pattern.factory;

public class BananaFactory implements IFoodFactory{
    @Override
    public Food create() {
        return new BananaFood();
    }
}
