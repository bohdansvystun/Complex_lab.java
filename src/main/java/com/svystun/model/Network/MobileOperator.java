package com.svystun.model.Network;

import java.io.*;
import java.util.*;
import java.util.List;


public class MobileOperator implements Serializable {
    private String name;
    private List<CellPhone> client;
    private transient List<Tariff> tariff;

    public MobileOperator(String name, List<CellPhone> client) {
        this.name = name;
        tariff = new ArrayList<>();
        this.client = client;
        readTariffFromFile();
    }

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

    public List<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(List<Tariff> tariff) {
        this.tariff = tariff;
    }

    public int countClients() {
        return client.size();
    }

    public void readTariffFromFile() {
        tariff = new ArrayList<>();
        String path = "C:\\Users\\Bogdan\\IdeaProjects\\Complex\\" + name + ".txt";
        try {
            FileReader fr = new FileReader(path);
            Scanner scan = new Scanner(fr);
            String name;
            int countOfMinutes;
            int price;
            int volumeInternet;
            while (scan.hasNext()) {
                scan.nextLine();
                name = scan.nextLine();
                price = scan.nextInt();
                volumeInternet = scan.nextInt();
                countOfMinutes = scan.nextInt();
                tariff.add(new Tariff(name, price, volumeInternet, countOfMinutes));
            }


        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void addClient(List<CellPhone> cellPhones){
        client.addAll(cellPhones);
    }

    @Override
    public String toString() {
        return "\nMobileOperator: " +
                "name: " + name  +
                "\nclient:" + client +
                "\ntariffs: " + tariff +"\n";
    }
}
