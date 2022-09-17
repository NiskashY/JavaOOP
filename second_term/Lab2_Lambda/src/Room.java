import Devices.Date;
import Devices.ElectricDevices;
import Devices.PortableDevices;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

class Choice {
    static public int Input(String[] menu) {
        System.out.println("Your Choice: ");

        // menu - last element should be 'else - exit'
        int max_input = menu.length - 1, min_input = 1;
        int choice = 0;
        boolean isInputOk = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            isInputOk = (choice >= min_input && choice <= max_input);
            if (!isInputOk) {
                System.out.println("Input number between " + min_input + " and " + max_input);
            }
        } while (!isInputOk);

        return choice;
    }
}

public class Room {
    ArrayList<ElectricDevices> devicesList;

    public Room() {
        devicesList = new ArrayList<>();
    }

    public void AddNewDevice(ElectricDevices new_device) {
        devicesList.add(new_device);
    }

    public void RemoveDevice(int index) {
        devicesList.remove(index);
    }

    public void ShowAllDevices() {
        for (final var item : devicesList) {
            System.out.print(item);
            System.out.println(' ');
        }
        System.out.println();
    }


    private ElectricDevices CreateNewDevice() {

        boolean isPlugged = ElectricDevices.InputIsPlugged();
        String modelName = ElectricDevices.InputModelName();
        Date releaseDate = Date.InputDate();

        /* TODO: implement selection by portable/plugged device
                 Check For Correctness of types, when push_back
                 to the end of array_list
        */
        String[] types = {"1 - Portable", "2 - Only Plug", "else - exit"};
        for (var item : types) {
            System.out.println(item);
        }
        int choice = Choice.Input(types);

    }

    private void PrintMenu() {
        String[] functions = {"1 - Add New Device", "2 - Remove Device",
                "3 - Show All devices", "4 - Calculate Energy Cost", "else - exit"};

        for (var item : functions) {
            System.out.println(item);
        }
        int choice = Choice.Input(functions);

        switch (choice) {
             case 1 -> AddNewDevice(CreateNewDevice());
            // case 2 -> RemoveDevice(InputIndexDevice());
            case 3 -> ShowAllDevices();
            //case 4 ->
        }
    }
}
