package taest.pattern.builder.simple;

public class Main
{
    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder();
        builder.addKeyboard("keyboard");
        builder.addMonitor("monitor");
        builder.addCpu("cpu");
        builder.addGpu("gpu");
        builder.addMouse("mouse");
        System.out.println("builder.builder() = " + builder.builder());


    }
}
