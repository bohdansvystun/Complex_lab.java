package com.Kitik;

import com.Kitik.controller.Controller;
import com.Kitik.model.Network.CellPhone;
import com.Kitik.model.Network.MobileOperator;
import com.Kitik.model.Network.Tariff;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<CellPhone> cellPhoneListMTS = new ArrayList<>();
        List<CellPhone> cellPhoneListKYIVSTAR = new ArrayList<>();
        cellPhoneListMTS.add(new CellPhone("A", "B", 22532, Tariff.SUPERNET));
        cellPhoneListKYIVSTAR.add(new CellPhone("D", "C", 22533, Tariff.UNLIM4G));
        List<Tariff> tariffList = new ArrayList<>();
        tariffList.add(Tariff.SUPERNET);
        tariffList.add(Tariff.UNLIM4G);
        Controller controller = new Controller();
        MobileOperator mobileOperator = new MobileOperator("Vodafone", cellPhoneListMTS, tariffList);
        MobileOperator mobileOperator1 = new MobileOperator("KiyvStar", cellPhoneListKYIVSTAR, tariffList);
        controller.writeToTheFile(mobileOperator);
        controller.writeToTheFile(mobileOperator1);

        controller.getFromFile();
        controller.showCellPhones();
        controller.showMobileOperator();
    }


}
