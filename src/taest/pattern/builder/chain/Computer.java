package taest.pattern.builder.chain;

public class Computer {

    private String monitor;

    private String cpu;

    private String gpu;

    private String keyboard;

    private String mouse;

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "monitor='" + monitor + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
