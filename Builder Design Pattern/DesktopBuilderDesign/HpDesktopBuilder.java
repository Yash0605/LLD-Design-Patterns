public class HpDesktopBuilder extends DesktopBuilder {
    @Override
    public void buildCPU() {
        desktop.setCpu("HP CPU");
    }

    @Override
    public void buildRAM() {
        desktop.setRam("HP RAM");
    }

    @Override
    public void buildKeyboard() {
        desktop.setKeyboard("HP keyboard");
    }

    @Override
    public void buildMonitor() {
        desktop.setMonitor("HP monitor");

    }
}
