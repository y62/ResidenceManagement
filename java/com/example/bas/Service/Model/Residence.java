package com.example.bas.Service.Model;

public class Residence {
    private int residenceId;
    private String username;
    private int rentalNumber;
    private int size;
    private int room;
    private String address;

    public Residence(int residenceId, String username, int rentalNumber, int size, int room, String address) {
        this.residenceId = residenceId;
        this.username = username;
        this.rentalNumber = rentalNumber;
        this.size = size;
        this.room = room;
        this.address = address;
    }

    public Residence() {
    }

    public int getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(int residenceId) {
        this.residenceId = residenceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRentalNumber() {
        return rentalNumber;
    }

    public void setRentalNumber(int rentalNumber) {
        this.rentalNumber = rentalNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Residence{" +
                "residenceId=" + residenceId +
                ", username='" + username + '\'' +
                ", rentalNumber=" + rentalNumber +
                ", size=" + size +
                ", room=" + room +
                ", address='" + address + '\'' +
                '}';
    }
}
