public class DesktopDirector {

    public Desktop constructDesktop(DesktopBuilder desktopBuilder) {
        desktopBuilder.buildCPU();
        desktopBuilder.buildRAM();
        desktopBuilder.buildKeyboard();
        desktopBuilder.buildMonitor();

        return desktopBuilder.getDesktop();
    }
}
