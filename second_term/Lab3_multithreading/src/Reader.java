import Devices.ElectricDevices;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Reader {
    ArrayList<ElectricDevices> devicesList;

    public void run() {
        try {
            final String kFileName = "devices.txt";
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(kFileName)
            );
            devicesList = (ArrayList<ElectricDevices>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            devicesList = new ArrayList<>();
        }
    }

    public ArrayList<ElectricDevices> getDevicesList() {
        return devicesList;
    }
}
