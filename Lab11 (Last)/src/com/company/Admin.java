package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin implements Serializable {
    private List<Request> requestList;
    private List<Car> carList;
    private List<Client> clientsList;

    public Admin() {
        requestList = new ArrayList<>();
        carList = new ArrayList<>();
        clientsList = new ArrayList<>();
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public Admin(List<Request> requestList, List<Car> carList, List<Client> clientsList) {
        this.requestList = requestList;
        this.carList = carList;
        this.clientsList = clientsList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }


    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "requestList=" + requestList +
                ", carList=" + carList +
                ", clientsList=" + clientsList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(requestList, admin.requestList) && Objects.equals(carList, admin.carList) && Objects.equals(clientsList, admin.clientsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestList, carList, clientsList);
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void addRequest(Request request) {
        requestList.add(request);
    }

    public void addClient(Client client) {
        clientsList.add(client);
    }
}
