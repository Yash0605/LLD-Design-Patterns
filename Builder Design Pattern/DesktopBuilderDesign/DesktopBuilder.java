public abstract class DesktopBuilder {
    protected Desktop desktop = new Desktop();

    public abstract void buildCPU();

    public abstract void buildRAM();

    public abstract void buildKeyboard();

    public abstract void buildMonitor();

    public Desktop getDesktop() {
        return desktop;
    }
}
