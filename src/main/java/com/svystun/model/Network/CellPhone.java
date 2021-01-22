package com.svystun.model.Network;

import java.io.Serializable;

public class CellPhone implements Serializable {
    private String name;
    private String surname;
    private int number;
    private String tariff;


    public CellPhone(String name, String surname, int number, String tariff) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.tariff = tariff;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumber() {
        return number;
    }

    public String getTariff() {
        return tariff;
    }

    @Override
    public String toString() {
        return "\nClient" +
                "name: " + name  +
                ", surname: " + surname +
                ", number: " + number +
                ", tariff: " + tariff;
    }
}
