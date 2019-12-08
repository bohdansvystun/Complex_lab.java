package com.Kitik.controller;

import com.Kitik.model.Model;
import com.Kitik.model.Network.CellPhone;
import com.Kitik.model.Network.GetFromFile;
import com.Kitik.model.Network.MobileOperator;
import com.Kitik.model.Network.Tariff;

import java.io.*;
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

}
