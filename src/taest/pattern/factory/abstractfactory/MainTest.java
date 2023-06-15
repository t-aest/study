package taest.pattern.factory.abstractfactory;

public class MainTest {
    public static void main(String[] args) {

        CarFactoray factory = new AudiCarFactory();
        factory.createTire().prodTire();
        factory.createBody().prodBody();
        factory.createChassis().prodChassis();
    }
}
