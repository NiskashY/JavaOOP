import Devices.*;
import com.sun.management.HotSpotDiagnosticMXBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

class Choice {
    static public int InputOptional(String[] menu) {
        System.out.println("Your Choice: ");
        // menu - last element should be 'else - exit'

        int choice = 0;
        boolean isInputOk = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return choice;
    }

    static public int InputIndexDevice(ArrayList<ElectricDevices> devices) {
        int index = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min_index = 1, max_index = devices.size();
        System.out.println("Input index between " + min_index + " and " + max_index + ": ");

        boolean isInputOk = false;
        do {
            try {
                index = Integer.parseInt(reader.readLine());
                isInputOk = (index >= min_index && index <= max_index);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            if (!isInputOk) {
                System.out.print("Wrong index. ReEnter: ");
            }
        } while (!isInputOk);

        return index - 1;
    }
}

public class Room {
    ArrayList<ElectricDevices> devicesList;

    public Room() {
        devicesList = new ArrayList<>();
    }

    public void AddNewDevice(ElectricDevices new_device) {
        if (new_device == null) {
            return;
        }
        devicesList.add(new_device);
    }

    public void RemoveDevice(int index) {
        devicesList.remove(index);
    }

    public void ShowAllDevices() {
        if (devicesList.isEmpty()) {
            System.out.println("no available devices!");
        }
        for (final var item : devicesList) {
            System.out.print(item);
            System.out.println(' ');
        }
        System.out.println();
    }

    private void InputPortableCharacteristics(Integer capacity, Integer percentage, ChargerType chargerType) {

    }

    private void InputPluggableDevice(int power, int size) {

    }
    private ElectricDevices CreateNewDevice() {
        boolean isPlugged = ElectricDevices.InputIsPlugged();
        String modelName = ElectricDevices.InputModelName();
        Date releaseDate = Date.InputDate();

        String[] types = {"1 - Portable", "2 - Only Plug", "else - exit"};
        for (var item : types) {
            System.out.println(item);
        }
        int choice = Choice.InputOptional(types);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (choice == 1) {
            int capacity = 0, percentage = 0;
            ChargerType chargerType = ChargerType.Others;
            try {
                System.out.println("Input capacity: ");
                capacity = Integer.parseInt(reader.readLine());
                System.out.println("Input percentage: ");
                percentage = Integer.parseInt(reader.readLine());
                String[] menu = {
                        "1 - TypeC", "2 - mini_USB", "3 - lightning", "else - Others"
                };
                for (var item : menu) {
                    System.out.println(item);
                }
                int type_choice = Choice.InputOptional(menu);
                switch (type_choice) {
                    case 1 -> chargerType = ChargerType.TypeC;
                    case 2 -> chargerType = ChargerType.mini_USB;
                    case 3 -> chargerType = ChargerType.lightning;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new PortableDevices(isPlugged, modelName, releaseDate, capacity, chargerType, percentage);
        } else if (choice == 2) {
            int requiredPower = 0, deviceSize = 0;
            try {
                System.out.println("Input required device power: ");
                requiredPower = Integer.parseInt(reader.readLine());
                System.out.println("Input device Height: ");
                deviceSize = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }            return new PluggableDevices(isPlugged, modelName, releaseDate, requiredPower, deviceSize);
        }
        return null;
    }


    public boolean PrintMenu() {
        String[] functions = {"1 - Add New Device", "2 - Remove Device",
                "3 - Show All devices", "4 - Calculate Energy Cost", "else - exit"};

        for (var item : functions) {
            System.out.println(item);
        }
        int choice = Choice.InputOptional(functions);

        switch (choice) {
            case 1 -> AddNewDevice(CreateNewDevice());
            case 2 -> {
                if (devicesList.isEmpty()) {
                    System.out.println("no available devices");
                    break;
                }
                RemoveDevice(Choice.InputIndexDevice(devicesList));
            }
            case 3 -> ShowAllDevices();
            case 4 -> {
                final int[] energy_cost = {0};
                devicesList.forEach(
                        (item) -> {
                            energy_cost[0] += item.getPower();
                        }
                );
                System.out.println("Energy cost = " + energy_cost[0]);
            }
            default -> {
                return false;
            }
        }
        return true;
    }
}
