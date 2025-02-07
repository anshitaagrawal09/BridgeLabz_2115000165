
// Superclass Device
class Device {
    String deviceId;
    String status;
    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}
// Subclass Thermostat
class Thermostat extends Device {
    double temperatureSetting;
    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
// Main class to test the system
public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH123", "Online", 20.5);
        thermostat.displayStatus();
    }
}

