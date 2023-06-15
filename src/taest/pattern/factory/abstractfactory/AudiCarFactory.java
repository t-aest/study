package taest.pattern.factory.abstractfactory;

public class AudiCarFactory extends CarFactoray{

    @Override
    protected IChassis createChassis() {
        return new AudiChassis();
    }

    @Override
    protected IBody createBody() {
        return new AudiBody();
    }

    @Override
    protected ITire createTire() {
        return new AudiTire();
    }
}
