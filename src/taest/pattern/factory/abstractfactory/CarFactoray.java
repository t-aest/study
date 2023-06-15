package taest.pattern.factory.abstractfactory;

public abstract class CarFactoray {

    public void init(){
        System.out.println("init");
    }

    protected abstract IChassis createChassis();
    protected abstract IBody createBody();
    protected abstract ITire createTire();

}
