package taest.pattern.factory.simplefactory;

public class MainTest {

    public static void main(String[] args) {
        Food food = new FoodFactory().create(AppleFood.class);
        food.prod();
    }
}
