package taest.pattern.builder.chain;

public class ComputerBuilder {

    private Computer computer = new Computer();

    public ComputerBuilder addMonitor(String monitor){
        computer.setMonitor(monitor);
        return this;
    }

    public ComputerBuilder addCpu(String cpu){
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder addGpu(String gpu){
        computer.setGpu(gpu);
        return this;
    }

    public ComputerBuilder addKeyboard(String keyboard){
        computer.setKeyboard(keyboard);
        return this;
    }

    public ComputerBuilder addMouse(String mouse){
        computer.setMouse(mouse);
        return this;
    }

    public Computer builder(){
        return computer;
    }
}
