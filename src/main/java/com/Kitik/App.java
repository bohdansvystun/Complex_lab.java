package com.Kitik;

import com.Kitik.view.View;

public class App {
    public static void main(String[] args) {
      /*  List<CellPhone> cellPhoneListMTS = new ArrayList<>();
        List<CellPhone> cellPhoneListKYIVSTAR = new ArrayList<>();
        cellPhoneListMTS.add(new CellPhone("A", "B", 22532, TariffVodafone.SUPERNET));
        cellPhoneListKYIVSTAR.add(new CellPhone("D", "C", 22533, TariffVodafone.UNLIM4G));
        List<TariffVodafone> tariffList = new ArrayList<>();
        tariffList.add(TariffVodafone.SUPERNET);
        tariffList.add(TariffVodafone.UNLIM4G);
        Controller controller = new Controller();
        MobileOperator mobileOperator = new MobileOperator("Vodafone", cellPhoneListMTS, tariffList);
        MobileOperator mobileOperator1 = new MobileOperator("KiyvStar", cellPhoneListKYIVSTAR, tariffList);
        controller.writeToTheFile(mobileOperator);
        controller.writeToTheFile(mobileOperator1);

        controller.getFromFile();
        controller.showCellPhones();
        controller.showMobileOperator();
        System.out.println("Count client "+ controller.showCountClient());
*/
        new View().show();
    }


}
