import java.awt.Color;

public class WashingMachine extends Appliance{

    private int rpm = 800;

    public WashingMachine(String model, Color color, int voltage){
        super(model, color, voltage);
    }

    public void setSpinRpm(int rpm){
        if (rpm < 400 || rpm > 1600) {
            throw new InvalidSetting("RPM must be between 400 - 1600.");
        }
        this.rpm = rpm;
    }

    @Override
    public void runCycle() throws PowerException {
        if (!on) throw new PowerException("WashingMachine is OFF");
        System.out.println(model + " spinning at " + rpm + " rpm");
    }

    @Override
    public double watts(){
        return on ? 500 : 1;
    }
}