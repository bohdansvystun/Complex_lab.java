package com.Kitik.model.Network;

public enum TariffVodafone {
    SUPERNET(90, 7, 90), UNLIM4G(150, 20, 60), UKNOWN(0, 0 ,0 );
    private int price;
    private int volumeInternet;
    private int countMinutes;

    TariffVodafone(int price, int volumeInternet, int countMinutes) {
        this.price = price;
        this.volumeInternet = volumeInternet;
        this.countMinutes = countMinutes;
    }
}
