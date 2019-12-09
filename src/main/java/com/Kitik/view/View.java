package com.Kitik.view;

import com.Kitik.model.Network.*;
import com.Kitik.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;


public class View {
    private Controller controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input;
    private static Logger logger = LogManager.getLogger(View.class);

    public View() {
        controller = new Controller();
        input = new Scanner(System.in);
        menu = new LinkedHashMap<>();
        menu.put("1", "  1 - readFromTheFile");
        menu.put("2", "  2 - showClients");
        menu.put("3", "  3 - showMobileOperator");
        menu.put("4", "  4 - getCountofClientAll");
        menu.put("5", "  5 - getCountByOperator");
        menu.put("6", "  6 - showMobileOperator");
        menu.put("7", "  7 - showAndSortTariffByCostOperator");
        menu.put("8", "  8 - showAndSortTariffByCostOperator");
        menu.put("9", "  9 - toTheFile");
        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("1", this::pressButton1);
        methodsMenu.put("2", this::pressButton2);
        methodsMenu.put("3", this::pressButton3);
        methodsMenu.put("4", this::pressButton4);
        methodsMenu.put("5", this::pressButton5);
        methodsMenu.put("6", this::pressButton6);
        methodsMenu.put("7", this::pressButton7);
        methodsMenu.put("8", this::pressButton8);
        methodsMenu.put("9", this::pressButton9);


    }

    private void pressButton1() {
        logger.info(controller.getFromFile());
    }

    private void pressButton2() {
        logger.info(controller.showCellPhones());
    }

    private void pressButton3() {
        logger.info(controller.showMobileOperator());
    }

    private void pressButton4() throws MyException {
        logger.info(controller.showCountClient());

    }

    private void pressButton5() {
        String name = input.nextLine();
        logger.info(controller.showCountClientInMobileOperator(name));
    }
    private void pressButton6() {
        String name = input.nextLine();
        controller.showMobileOperatorByName(name);
    }

    private void pressButton7() {
        logger.trace("Enter name operator");
        String name = input.nextLine();
        logger.info(controller.sortByCostOperator(name));
    }

    private void pressButton8() {
        logger.trace("Enter name operator");
        String name = input.nextLine();
        logger.trace("Enter tariff cost");
        int cost = input.nextInt();
        controller.searchTariff(cost, name);
        input.nextLine();
    }

    private void pressButton9() {
        List<CellPhone> cellPhoneList = new ArrayList<>();
        MobileOperator mobileOperator;
        logger.trace("Enter name operator: ");
        String nameOperator = input.nextLine();
        logger.trace("Enter name client: ");
        String nameClient = input.nextLine();
        logger.trace("Enter surname client: ");
        String surnameClient = input.nextLine();
        logger.trace("Enter tariff client: ");
        String nameTariff = input.nextLine();
        logger.trace("Enter number client: ");
        int numberClient = input.nextInt();
        input.nextLine();
        cellPhoneList.add(new CellPhone(nameClient,surnameClient,numberClient,nameTariff));
        mobileOperator = new MobileOperator(nameOperator,cellPhoneList);
        logger.info(controller.writeToTheFile(mobileOperator));
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

