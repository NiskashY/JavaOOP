package com.company;

import java.io.*;
import java.util.Random;
import exceptions.InvalidPositionException;

import static validation_and_output.output.*;
import static validation_and_output.validation.*;


public class Main {

    public static void main(String[] args) {
        Admin admin = readAdminInfo();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mods = {"1 - admin", "2 - client", "else - exit"};

        boolean isNeedToExit = false;
        while (!isNeedToExit) {
            printMenu(mods);
            int mode = 0;
            try {
                mode = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println(GetNumberFormatMessage());
                continue;
            }

            switch (mode) {
                case 1 -> adminSection(reader, admin);
                case 2 -> clientSection(reader, admin);
                default -> isNeedToExit = true;
            }
        }

        writeAdminInfo(admin);
    }

    public static Admin readAdminInfo() {
        Admin admin = new Admin();
        try {
            final String fileName = "admin.txt";
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("admin.txt")
            );
            admin = (Admin) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
            admin = new Admin();
        }
        return admin;
    }

    public static void writeAdminInfo(Admin admin) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("admin.txt"));
            objectOutputStream.writeObject(admin);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public static void adminSection(BufferedReader reader, Admin admin) {
        String[] options = {
                "\n0 - Approve Requests", "1 - Add car",
                "2 - Add Client", "3 - Add Request",
                "4 - Print all cars", "5 - Print all Clients",
                "6 - Print all Requests", "else - exit"
        };

        int option = 0;
        boolean isNeedToExit = false;
        try {
            while (!isNeedToExit) {
                printMenu(options);
                option = Integer.parseInt(reader.readLine());

                try {
                    switch (option) {
                        case 0 -> approveRequests(reader, admin);
                        case 1 -> admin.addCar(createCar(reader));
                        case 2 -> admin.addClient(createClient(reader));
                        case 3 -> admin.addRequest(createRequest(reader, admin));
                        case 4 -> printAllCars(admin, true);
                        case 5 -> printAllClients(admin);
                        case 6 -> printAllRequests(admin);
                        default -> isNeedToExit = true;
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(GetNumberFormatMessage());
        }
    }

    public static void clientSection(BufferedReader reader, Admin admin ) {
        String[] options = {"1 - Add Request", "else - exit"};

        int option = 0;
        boolean isNeedToExit = false;

        try {
            while (!isNeedToExit) {
                printAllCars(admin, false);

                printMenu(options);
                option = Integer.parseInt(reader.readLine());

                try {
                    if (option == 1) {
                        admin.addRequest(createRequest(reader, admin));
                    } else {
                        isNeedToExit = true;
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.toString());
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(GetNumberFormatMessage());
        }
    }

    public static Car createCar(BufferedReader reader) {
        String model = "";
        try {
            System.out.print("Enter car model: ");
            model = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return new Car(model);
    }
    public static Car chooseCar(BufferedReader reader, Admin admin) {
        var cars = admin.getCarList();
        int position = -1;

        boolean isInputOk = false;
        while (!isInputOk) {
            try {
                System.out.println("Enter position( [0;" + cars.size() + ") ) of car you want to book: ");
                position = Integer.parseInt(reader.readLine());
                if (!isPositionCorrect(position, 0, cars.size())) {
                    throw new InvalidPositionException("Position out of bounds");
                }

                if (cars.get(position).isBooked()) {
                    System.out.println("This car already booked! ReEnter!");
                }
                isInputOk = true;
            } catch (IOException | InvalidPositionException e) {
                System.out.println(e.getLocalizedMessage());
                isInputOk = false;
            }
        }

        return cars.get(position);
    }

    public static Client createClient(BufferedReader reader) {
        String name = "";
        String email = "";
        int number = 0;
        try {
            System.out.print("Enter client name: ");
            name = reader.readLine();
            System.out.print("Enter client number: ");
            number = Integer.parseInt(reader.readLine());
            System.out.print("Enter client email: ");
            email = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return (new Client(name, number, email));
    }
    public static Request createRequest(BufferedReader reader, Admin admin) {
        var client = createClient(reader);

        if (admin.getCarList().size() == 0) {
            throw new RuntimeException("no cars in garage *_*");
        }

        var car = chooseCar(reader, admin);
        int leaseTerm = 0;

        try {
            System.out.print("Enter lease term: ");
            leaseTerm = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return new Request(car, client, leaseTerm, false);
    }

    public static void approveRequests(BufferedReader reader, Admin admin) {
        var requests = admin.getRequestList();

        for (var item : requests) {
            if (item.isStatus()) {
                continue;
            }

            System.out.print("\nWant to approve?\n" + item.toString() + "\n1 - yes, else - no\nYour choice: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (choice == 1) {
                item.setStatus(true);
                Random random = new Random();
                System.out.println(item.getClient().toString() + " pay " + (random.nextInt(90) + 10) + "$$$");
                item.getCar().setBooked(true);
            } else {
                System.out.println("Enter why you decline request:");
                try {
                    String declineMessage = reader.readLine();
                    item.setDeclineMessage(declineMessage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
