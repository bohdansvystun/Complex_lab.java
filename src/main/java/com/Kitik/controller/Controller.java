package com.Kitik.controller;

import com.Kitik.model.Model;
import com.Kitik.model.Network.MobileOperator;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<MobileOperator> list = new ArrayList<>();
    Model model = new Model();

    public final void getFromFile(){
        model.getFromFile();
    }

    public final void writeToTheFile(MobileOperator mobileOperator){
        model.writeToTheFile(mobileOperator);
    }

    public final void showMobileOperator() {
        model.showMobileOperator();
    }

    public final void showCellPhones(){
        model.showCellPhones();
    }

    public final int showCountClient(){
       return model.showCountClient();
    }

    public final int showCountClientInMobileOperator(String nameOperator){
        return model.showCountClientInMobileOperator(nameOperator);
    }

    public final void addTarifftoTheOperator(String nameTariff, int priceTariff, int volumeInternet, int countMinutes){
        model.addTarifftoTheOperator(nameTariff, priceTariff, volumeInternet, countMinutes);
    }
}
