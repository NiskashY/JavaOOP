package Devices;

enum ChargerType {
    TypeC, mini_USB, lightning, Others
}

public class PortableDevices extends ElectricDevices {
    int capacity = 0;
    ChargerType chargerType = ChargerType.Others;
    int percentage = 0;


    public PortableDevices(boolean isPluggedIn, String modelName, Date date, int capacity,
                           ChargerType chargerType, int percentage) {
        super(isPluggedIn, modelName, date);
        this.capacity = capacity;
        this.chargerType = chargerType;
        this.percentage = percentage;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ChargerType getChargerType() {
        return chargerType;
    }

    public void setChargerType(ChargerType chargerType) {
        this.chargerType = chargerType;
    }

    @Override
    public String toString() {
        return "Type: Portable " + super.toString() +
                " Capacity = " + capacity +
                " ChargerType = " + chargerType +
                " Percentage = " + percentage;
    }
}
