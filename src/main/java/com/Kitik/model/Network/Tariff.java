package com.Kitik.model.Network;

public enum Tariff {
    SUPERNET(90, 7, 90), UNLIM4G(150, 20, 60);

    private int price;
    private int volumeInternet;
    private int countMinutes;

    Tariff(int price, int volumeInternet, int countMinutes) {
        this.price = price;
        this.volumeInternet = volumeInternet;
        this.countMinutes = countMinutes;
    }
}
