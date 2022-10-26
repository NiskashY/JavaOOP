import Devices.*;
import com.sun.management.HotSpotDiagnosticMXBean;

import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;

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


class SortDevices extends Thread {
    ArrayList<ElectricDevices> devices_local;
    boolean isAscending = true;

    public SortDevices(ArrayList<ElectricDevices> devices, boolean isAsc) {
        devices_local = new ArrayList<>(devices);
        isAscending = isAsc;
    }

    @Override
    public void run() {
        if (isAscending) {
            Comparator<ElectricDevices> compAsc = (lhs, rhs) ->
                    lhs.getModelName().compareTo(rhs.getModelName());

            devices_local.sort(compAsc);
        } else {
            Comparator<ElectricDevices> compDesc = (lhs, rhs) ->
                    (-1) * lhs.getModelName().compareTo(rhs.getModelName());

            devices_local.sort(compDesc);
        }
    }

    public ArrayList<ElectricDevices> getDevices_local() {
        return devices_local;
    }
}


public class Room {
    private ArrayList<ElectricDevices> devicesList;

    public Room() {
        Reader reader = new Reader();
        reader.run();
        devicesList = reader.getDevicesList();
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

    public ArrayList<ElectricDevices> getDevicesList() {
        return devicesList;
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


    private void waitThread(SortDevices sortThread) {
        if (sortThread.isAlive()) {
            System.out.println("Waiting for download");
            do {
                try {
                    sortThread.join(500);
                } catch (InterruptedException e) {
                    System.out.println("Error!");
                }
            } while (sortThread.isAlive());
            System.out.println();
        }
    }
    public void ShowAllDevices() {
        if (devicesList.isEmpty()) {
            System.out.println("no available devices!");
        }

        String[] menu = {"1 - Simple output",
                "2 - Sort",
                "else - back"
        };

//        Operationable show = Operationable();

        Consumer<ArrayList<ElectricDevices>> ShowList = vec -> {
            for (final var item : vec) {
                System.out.print(item);
                System.out.println(' ');
            }
            System.out.println();
        };

        for (var item : menu) {
            System.out.println(item);
        }

        int choice = Choice.InputOptional(menu);
        if (choice == 1) {
            ShowList.accept(devicesList);
        } else if (choice == 2) {
            String[] menu_sort = {"1 - Ascending Sort",
                    "2 - Descending Sort",
                    "else - exit"
            };

            for (var item : menu_sort) {
                System.out.println(item);
            }

            choice = Choice.InputOptional(menu_sort);
            SortDevices sortThread = new SortDevices(devicesList, choice == 1);
            sortThread.start();

            waitThread(sortThread);

            ShowList.accept(sortThread.getDevices_local());
        }
    }

}
