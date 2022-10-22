package Devices;

public class PluggableDevices extends ElectricDevices {
    int requiredPower = 0;
    int deviceSize = 0;

    public PluggableDevices(boolean isPluggedIn, String modelName, Date date, int requiredPower, int deviceSize) {
        super(isPluggedIn, modelName, date);
        this.requiredPower = requiredPower;
        super.power += requiredPower;
        this.deviceSize = deviceSize;
    }

    public int getRequiredPower() {
        return requiredPower;
    }

    public void setRequiredPower(int requiredPower) {
        this.requiredPower = requiredPower;
    }

    public int getDeviceSize() {
        return deviceSize;
    }

    public void setDeviceSize(int deviceSize) {
        this.deviceSize = deviceSize;
    }

    @Override
    public String toString() {
        return "Type: Portable, " + super.toString() +
                ", Required power = " + requiredPower +
                ", Device Size = " + deviceSize;
    }

}
