package com.company;

import java.io.*;
import java.util.Random;
import exceptions.InvalidPositionException;


public class Main {

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    static Admin admin;

    public static void readAdminInfo() {
        try {
            final String fileName = "admin.txt";
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileName)
            );
            admin = (Admin) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
            admin = new Admin();
        }
    }

    public static void writeAdminInfo() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("admin.txt"));
            objectOutputStream.writeObject(admin);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public static void adminSection(BufferedReader reader) {
        String[] options = {"0 - Approve Requests", "1 - Add car", "2 - Add Client", "3 - Add Request","4 - Print all cars", "5 - Print all Clients", "6 - Print all Requests", "7 - exit"};

        int option = 0;
        try {
            while (option != 7) {
                printMenu(options);
                option = Integer.parseInt(reader.readLine());

                try {
                    switch (option) {
                        case 0 -> approveRequests(reader);
                        case 1 -> admin.addCar(createCar(reader));
                        case 2 -> admin.addClient(createClient(reader));
                        case 3 -> admin.addRequest(createRequest(reader));
                        case 4 -> printAllCars();
                        case 5 -> printAllClients();
                        case 6 -> printAllRequests();
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Please enter an integer value between 1 and " + options.length);
        }
    }

    public static void clientSection(BufferedReader reader) {
        String[] options = {"1 - Add Request","2 - Print all cars", "3 - exit"};

        int option = 0;
        try {
            while (option != 3) {
                printMenu(options);
                option = Integer.parseInt(reader.readLine());

                try {
                    switch (option) {
                        case 1 -> admin.addRequest(createRequest(reader));
                        case 2 -> printAllCars();
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Please enter an integer value between 1 and " + options.length);
        }
    }

    public static void main(String[] args) {
        // write your code here

        readAdminInfo();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mods = {"1 - admin", "2 - client", "else - exit"};

        while (true) {
            printMenu(mods);
            int mode = 0;
            try {
                mode = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            if (mode == 1) {
                adminSection(reader);
            } else if (mode == 2) {
                clientSection(reader);
            } else {
                break;
            }
        }

        writeAdminInfo();
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
    public static Car chooseCar(BufferedReader reader) {
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
    public static Request createRequest(BufferedReader reader) {
        var client = createClient(reader);

        if (admin.getCarList().size() == 0) {
            throw new RuntimeException("no cars in garage *_*");
        }

        var car = chooseCar(reader);
        int leaseTerm = 0;

        try {
            System.out.print("Enter lease term: ");
            leaseTerm = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return new Request(car, client, leaseTerm, false);
    }

    public static void printAllCars() {
        var cars = admin.getCarList();
        for (var item : cars) {
            System.out.println(item.toString());
        }
    }

    public static void printAllClients() {
        var clients = admin.getClientsList();
        for (var item : clients) {
            System.out.println(item.toString());
        }
    }

    public static void printAllRequests() {
        var requests = admin.getRequestList();
        for (var item : requests) {
            System.out.println(item.toString());
        }
    }

    public static void approveRequests(BufferedReader reader) {
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
                // TODO: if car was already booked do not show this in menu
                //       create admin method, that delete car from list and than
                //       push changes into file
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

    public static boolean isPositionCorrect(final int pos, final int lowest_pos, final int highest_pos) {
        // [lowest_pos; highest_pos);
        return (pos >= lowest_pos && pos < highest_pos);
    }
}
