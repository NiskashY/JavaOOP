import Devices.ElectricDevices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Writer {
    ArrayList<ElectricDevices> devicesList;

    public Writer(ArrayList<ElectricDevices> electricDevices) {
        devicesList = electricDevices;
    }

    public void run() {
        try {
            final String kFileName = "devices.txt";
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(kFileName)
            );
            objectOutputStream.writeObject(devicesList);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
