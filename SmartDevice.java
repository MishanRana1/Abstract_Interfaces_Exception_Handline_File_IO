
package Devices;

public interface SmartDevice {
    public void connectWifi(String ssid, String password) throws NetworkException; // (D) checked exception type
    public void disconnectWifi();
    default String ping() { return "pong"; }
}
