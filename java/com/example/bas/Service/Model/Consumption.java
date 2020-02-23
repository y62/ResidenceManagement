package com.example.bas.Service.Model;

/**
 * Basic POJOs med variabler, contructor, getters, setters og toString metoden.
 */
public class Consumption {

    private int consumptionId;
    private int power;
    private int water;
    private int heat;
    private int pricePerUser;
    private String dateRegistered;

    public Consumption(int consumptionId, int power, int water, int heat, int pricePerUser, String dateRegistered) {
        this.consumptionId = consumptionId;
        this.power = power;
        this.water = water;
        this.heat = heat;
        this.pricePerUser = pricePerUser / 4;
        this.dateRegistered = dateRegistered;
    }

    public Consumption() {
    }

    public int getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(int consumptionId) {
        this.consumptionId = consumptionId;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public int getPricePerUser() {
        return pricePerUser;
    }

    public void setPricePerUser(int pricePerUser) {
        this.pricePerUser = pricePerUser;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "consumptionId=" + consumptionId +
                ", power=" + power +
                ", water=" + water +
                ", heat=" + heat +
                ", pricePerUser=" + pricePerUser +
                ", dateRegistered='" + dateRegistered + '\'' +
                '}';
    }
}
