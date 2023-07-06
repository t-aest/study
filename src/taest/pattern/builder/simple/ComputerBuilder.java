package taest.pattern.builder.simple;

public class ComputerBuilder {

    private Computer computer = new Computer();

    public void addMonitor(String monitor){
        computer.setMonitor(monitor);
    }

    public void addCpu(String cpu){
        computer.setCpu(cpu);
    }

    public void addGpu(String gpu){
        computer.setGpu(gpu);
    }

    public void addKeyboard(String keyboard){
        computer.setKeyboard(keyboard);
    }

    public void addMouse(String mouse){
        computer.setMouse(mouse);
    }

    public Computer builder(){
        return computer;
    }
}
