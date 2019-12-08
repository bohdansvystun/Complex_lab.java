package com.Kitik.model.Network;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class MobileOperator implements Serializable {
    private String name;
    private List<CellPhone> client = new ArrayList<CellPhone>();
    private List tariff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CellPhone> getClient() {
        return client;
    }

    public void setClient(List<CellPhone> client) {
        this.client = client;
    }

    public List getTariff() {
        return tariff;
    }

    public void setTariff(List tariff) {
        this.tariff = tariff;
    }

    public int countClients() {
        return client.size();
    }

    public MobileOperator(String name, List<CellPhone> client, List tariff) {
        this.name = name;
        this.client = client;
        this.tariff = tariff;
    }

    public void showClient(){
        System.out.println(client);
    }
    @Override
    public String toString() {
        return "MobileOperator{" +
                "name='" + name + '\'' +
                ", client=" + client +
                ", tariff=" + tariff +
                '}';
    }
}
