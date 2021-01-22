package com.svystun.controller;

import com.svystun.model.Model;
import com.svystun.model.Network.CellPhone;
import com.svystun.model.Network.MobileOperator;
import com.svystun.model.Network.Tariff;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<MobileOperator> list = new ArrayList<>();
    Model model = new Model();

    public final String getFromFile() {
        return model.getFromFile();
    }

    public final String writeToTheFile(MobileOperator mobileOperator) {
        return model.writeToTheFile(mobileOperator);
    }

    public final List<MobileOperator> showMobileOperator() {
        return model.showMobileOperator();
    }

    public final void showMobileOperatorByName(String name) {
        model.showMobileOperatorByName(name);
    }

    public final List<CellPhone> showCellPhones() {
        return model.showCellPhones();
    }

    public final int showCountClient() {
        return model.showCountClient();
    }

    public final int showCountClientInMobileOperator(String nameOperator) {
        return model.showCountClientInMobileOperator(nameOperator);
    }

    public final List<Tariff> showTariffList() {
        return model.showTariffList();
    }


    public final List<Tariff> sortByCostOperator(String name) {
        return model.sortByCostOperator(name);
    }

    public final List<Tariff> showTariff(){
        return model.returnAllTariff();
    }
    public final void searchTariff(int cost, String name) {
        model.searchTariffByCostOperator(cost, name);
    }
}
