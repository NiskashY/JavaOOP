package validation_and_output;

import com.company.Admin;

public class output {

    public static void printAllCars(Admin admin, boolean isAdmin) {
        var cars = admin.getCarList();
        boolean isFoundAtLeastOneCar = false;
        for (var item : cars) {
            if (!isAdmin && !item.isBooked()) {
                continue;
            }
            isFoundAtLeastOneCar = true;
            System.out.println(item.toString());
        }
        if (!isFoundAtLeastOneCar) {
            if (isAdmin) {
                System.out.println("No Cars in Garage!");
            } else {
                System.out.println("No Available Cars!");
            }
        }
    }

    public static void printAllClients(Admin admin) {
        var clients = admin.getClientsList();
        for (var item : clients) {
            System.out.println(item.toString());
        }
    }

    public static void printAllRequests(Admin admin) {
        var requests = admin.getRequestList();
        for (var item : requests) {
            System.out.println(item.toString());
        }
    }
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
}
