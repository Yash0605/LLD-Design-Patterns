public class DellDesktopBuilder extends DesktopBuilder {

    @Override
    public void buildCPU() {
        desktop.setCpu("Dell CPU");
    }

    @Override
    public void buildRAM() {
        desktop.setRam("DELL RAM");
    }

    @Override
    public void buildKeyboard() {
        desktop.setKeyboard("DELL keyboard");
    }

    @Override
    public void buildMonitor() {
        desktop.setMonitor("Dell monitor");

    }
}
