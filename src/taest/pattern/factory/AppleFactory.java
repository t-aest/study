package taest.pattern.factory;

public class AppleFactory implements IFoodFactory{
    @Override
    public Food create() {
        return new BananaFood();
    }
}