package taest.pattern.builder.chain;

public class Main
{
    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder()
                .addKeyboard("keyboard")
                .addMonitor("monitor")
                .addCpu("cpu")
                .addGpu("gpu")
                .addMouse("mouse");
        System.out.println("builder.builder() = " + builder.builder());
        

    }
}
