package taest.pattern.factory.abstractfactory;

public class AudiChassis implements IChassis{
    @Override
    public void prodChassis() {
        System.out.println("prod Audi chassis");
    }
}
