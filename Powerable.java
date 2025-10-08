public interface Powerable {
    public void powerOn() throws PowerException;   // (A) checked exception type
    public void powerOff();
    public boolean isOn();

    default String powerStatus() {
        return isOn() ? "ON" : "OFF";
    }

    public static void safeShutdownAll(java.util.Collection<? extends Powerable> items) {
        for (Powerable p : items) {
            if (p.isOn()) {
                p.powerOff();
            }
        }
    }
}