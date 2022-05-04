package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable {
    private Car car;
    private Client client;
    private int leaseTerm; // срок аренды
    private boolean status; // заявка подверждена - да/нет

    private String declineMessage;

    public String getDeclineMessage() {
        return declineMessage;
    }

    public void setDeclineMessage(String declineMessage) {
        this.declineMessage = declineMessage;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Request() {}

    public Request(Car car, Client client, int leaseTerm, boolean status) {
        this.car = car;
        this.client = client;
        this.leaseTerm = leaseTerm;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return leaseTerm == request.leaseTerm && status == request.status && Objects.equals(car, request.car) && Objects.equals(client, request.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, client, leaseTerm, status);
    }

    @Override
    public String toString() {
        return "Request{" +
                "car=" + car +
                ", client=" + client +
                ", leaseTerm=" + leaseTerm +
                ", status=" + status +
                '}';
    }
}
