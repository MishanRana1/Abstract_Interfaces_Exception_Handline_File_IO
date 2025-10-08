package Devices;
import java.awt.Color;

abstract class Appliance implements Powerable, MeasurableEnergy {
    protected final String model;
    protected final Color color;
    protected boolean on = false;
    protected int voltage; // 110 or 220

    protected Appliance(String model, Color color, int voltage) {
        if (model == null || model.isBlank()) throw new IllegalArgumentException("model required");
        if (voltage != 110 && voltage != 220) throw new InvalidSetting("Voltage must be 110 or 220");
        this.model = model;
        this.color = color;
        this.voltage = voltage;
    }

    public void powerOn() throws PowerException{
        this.on = true;
    }

    @Override
    public void powerOff() { this.on = false; }

    @Override
    public boolean isOn() { return on; }

    public abstract void runCycle() throws PowerException;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + model + ", " + voltage + "V)";
    }
}