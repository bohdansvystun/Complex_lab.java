package com.Kitik.model;

import com.Kitik.model.Network.CellPhone;
import com.Kitik.model.Network.GetFromFile;
import com.Kitik.model.Network.MobileOperator;
import com.Kitik.model.Network.Tariff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<MobileOperator> mobileOperatorList;
    private List<CellPhone> cellPhoneList;
    private List<Tariff> tariffList;

    public Model() {
        mobileOperatorList = new ArrayList<>();
        cellPhoneList = new ArrayList<>();
        tariffList = new ArrayList<>(tariffList);
    }

    public final void addTarifftoTheOperator(String nameTariff, int priceTariff, int volumeInternet, int countMinutes){
        tariffList.add(new Tariff(nameTariff, priceTariff, volumeInternet, countMinutes));
    }

    public final void getFromFile() {
        try {
            FileInputStream fin = new FileInputStream(
                    "C:\\Users\\MyFantasy\\IdeaProjects"
                            + "\\task3_oop\\data.txt\\");
            ObjectInputStream ois = new ObjectInputStream(fin);
            GetFromFile get = (GetFromFile) ois.readObject();

            mobileOperatorList = get.getForFile();
            fin.close();
            System.out.println("Success!");
            initCellPhoneList();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public final void writeToTheFile(MobileOperator mobileOperator) {
        try {
            mobileOperatorList.add(mobileOperator);
            FileOutputStream fo = new FileOutputStream(
                    "C:\\Users\\MyFantasy\\IdeaProjects"
                            + "\\task3_oop\\data.txt\\");
            GetFromFile get = new GetFromFile(mobileOperatorList);
            ObjectOutputStream serial = new ObjectOutputStream(fo);
            serial.writeObject(get);
            fo.close();
            System.out.println("You wrote to the file");
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }

    }

    public final void showMobileOperator() {
        System.out.println(mobileOperatorList);
        System.out.println(" ");
    }

    public final void initCellPhoneList() {
        for (MobileOperator m : mobileOperatorList) {
            for (CellPhone s : m.getClient()) {
                cellPhoneList.add(s);
            }

        }
    }

    public final void showCellPhones() {
        System.out.println(cellPhoneList);
    }

    public int showCountClient() {
        return cellPhoneList.size();
    }

    public int showCountClientInMobileOperator(String nameMobileOpeator) {
        int count = 0;
        for (MobileOperator m : mobileOperatorList){
            if (m.getName().equals(nameMobileOpeator)){
               count++;
            }
        }
        return count;
    }
}

