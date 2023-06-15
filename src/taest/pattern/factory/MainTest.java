package taest.pattern.factory;

public class MainTest {

    public static void main(String[] args) {
        IFoodFactory factory = new BananaFactory();
        Food food = factory.create();
        food.prod();
    }
}
