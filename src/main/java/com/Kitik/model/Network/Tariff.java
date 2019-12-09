package com.Kitik.model.Network;

import java.io.Serializable;

public class Tariff {
    private String nameTariff;
    private int price;
    private int volumeInternet;
    private int countMinutes;

    public Tariff(String nameTariff, int price, int volumeInternet, int countMinutes) {
        this.nameTariff=nameTariff;
        this.price = price;
        this.volumeInternet = volumeInternet;
        this.countMinutes = countMinutes;
    }

    public String getNameTariff() {
        return nameTariff;
    }

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolumeInternet() {
        return volumeInternet;
    }

    public void setVolumeInternet(int volumeInternet) {
        this.volumeInternet = volumeInternet;
    }

    public int getCountMinutes() {
        return countMinutes;
    }

    public void setCountMinutes(int countMinutes) {
        this.countMinutes = countMinutes;
    }

    @Override
    public String toString() {
        return "\nTariff" +
                "nameTariff: " + nameTariff +
                ", price: " + price +
                ", volumeInternet: " + volumeInternet +
                ", countMinutes: " + countMinutes;
    }
}
