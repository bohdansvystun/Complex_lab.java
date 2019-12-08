package com.Kitik.view;

import com.Kitik.model.Network.*;
import com.Kitik.controller.Controller;

import java.util.*;

public class View {
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input;

    public View() {
        controller = new Controller();
        input = new Scanner(System.in);
        MobileOperator mobileOperator;
        menu = new LinkedHashMap<>();
        menu.put("1", "  1 - readFromTheFile");
        menu.put("2", "  2 - showClients");
        menu.put("3", "  3 - showMobileOperator");
        menu.put("4", "  4 - getCountofClient");
        menu.put("5", "  5 - getCountByOperator");
        menu.put("9", "  9 - toTheFile");
        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
        methodsMenu.put("5", this::pressButton5);
        methodsMenu.put("9", this::pressButton9);
    }

    private void pressButton1() {
        controller.getFromFile();
    }

    private void pressButton2() {
        controller.showCellPhones();
    }

    private void pressButton3() {
        controller.showMobileOperator();
    }

    private void pressButton4() throws MyException {
        System.out.println(controller.showCountClient());
    }

    private void pressButton5() {
        System.out.println(controller.showCountClientInMobileOperator("VODAFONE"));
    }


    private void pressButton9() {

        System.out.print("Enter name operator: ");
        String nameOperator = input.nextLine();
        System.out.print("Enter name client: ");
        String nameClient = input.nextLine();
        System.out.print("Enter surname client: ");
        String surnameClient = input.nextLine();
        System.out.print("Enter tariff client");
        String nameTariff = input.nextLine();
        System.out.print("Enter number client: ");
        int numberClient = input.nextInt();
        input.nextLine();
        /*TariffVodafone tariffVodafone = TariffVodafone.UKNOWN;
        TariffKiyvstart tariffKiyvstart = TariffKiyvstart.UKNOWN;
        if (nameOperator == "Vodafone") {
            if (nameTariff.equals(TariffVodafone.SUPERNET.name())) {
                tariffVodafone = TariffVodafone.SUPERNET;
            } else if (nameTariff.equals(TariffVodafone.UNLIM4G.name())) {
                tariffVodafone = TariffVodafone.UNLIM4G;
            }
            cellPhoneList.add(new CellPhone(nameClient, surnameClient, numberClient, tariffVodafone));
            MobileOperator mobileOperator = new MobileOperator(nameOperator, cellPhoneList, tariffVodafoneList);
            controller.writeToTheFile(mobileOperator);
        } else if (nameOperator == "Kiyvstar") {
            if (nameTariff.equals(TariffKiyvstart.SUPERNETK.name())) {
                tariffKiyvstart = TariffKiyvstart.SUPERNETK;
            } else if (nameTariff.equals(TariffKiyvstart.UNLIM4GK.name())) {
                tariffKiyvstart = TariffKiyvstart.UNLIM4GK;
            }
            cellPhoneList.add(new CellPhone(nameClient, surnameClient, numberClient, tariffKiyvstart));
            MobileOperator mobileOperator = new MobileOperator(nameOperator, cellPhoneList, tariffKiyvstartList);
            controller.writeToTheFile(mobileOperator);
        }
*/

    }


    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }
}

