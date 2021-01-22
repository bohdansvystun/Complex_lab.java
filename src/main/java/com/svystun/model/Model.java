package com.svystun.model;

import com.svystun.model.Network.CellPhone;
import com.svystun.model.Network.GetFromFile;
import com.svystun.model.Network.MobileOperator;
import com.svystun.model.Network.Tariff;
import com.svystun.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;


public class Model {
    private List<MobileOperator> mobileOperatorList;
    private List<CellPhone> cellPhoneList;
    public static Logger logger;
    private List<Tariff> tariffList;
    MobileOperator mobileOperator;

    public Model() {
        mobileOperatorList = new ArrayList<>();
        cellPhoneList = new ArrayList<>();
        logger = LogManager.getLogger(View.class);
        tariffList = new ArrayList<>();

    }

    public final String getFromFile() {
        try {
            FileInputStream fin = new FileInputStream(
                    "C:\\Users\\Bogdan\\IdeaProjects\\Complex\\data.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            GetFromFile get = (GetFromFile) ois.readObject();
            mobileOperatorList = get.getForFile();
            fin.close();
            for (MobileOperator m : mobileOperatorList) {
                m.readTariffFromFile();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException e) {
            System.out.println(e);
        }

        return "Success!";
    }

    public final List<Tariff> getTariffList() {
        return mobileOperator.getTariff();
    }

    public final List<CellPhone> getCellPhoneList() {
        return mobileOperator.getClient();
    }


    public final String writeToTheFile(MobileOperator mobileOperator) {
        try {
            int count = 0;
            for (MobileOperator m : mobileOperatorList) {
                if (m.getName().equals(mobileOperator.getName())) {
                    m.addClient(mobileOperator.getClient());
                    count++;
                }
            }
            if (count == 0) {
                mobileOperatorList.add(mobileOperator);
            }
            FileOutputStream fo = new FileOutputStream(
                    "C:\\Users\\Bogdan\\IdeaProjects\\Complex\\data.txt");
            GetFromFile get = new GetFromFile(mobileOperatorList);
            ObjectOutputStream serial = new ObjectOutputStream(fo);
            serial.writeObject(get);
            fo.close();
        } catch (Exception e) {
            logger.trace(e);
            e.printStackTrace();
        }
        return "You wrote to the file";
    }

    public final List<MobileOperator> showMobileOperator() {
        return mobileOperatorList;

    }

    public void showMobileOperatorByName(String name) {
        for (MobileOperator m : mobileOperatorList) {
            if (m.getName().equals(name)) {
                logger.info(m);
            }
        }
    }


    public final List<Tariff> showTariffList() {
        return tariffList;
    }

    public final List<CellPhone> showCellPhones() {
        List<CellPhone> cellPhones = new ArrayList<>();
        for (MobileOperator m : mobileOperatorList) {
            cellPhones.addAll(m.getClient());
        }
        return cellPhones;
    }

    public int showCountClient() {
        return showCellPhones().size();
    }


    public int showCountClientInMobileOperator(String nameMobileOpeator) {
        int count = 0;
        for (MobileOperator m : mobileOperatorList) {
            if (m.getName().equals(nameMobileOpeator)) {
                count = m.getClient().size();
            }
        }

        return count;
    }


    public List<Tariff> returnAllTariff() {
        List<Tariff> tariffList = new ArrayList<>();
        for (MobileOperator m : mobileOperatorList) {
            tariffList.addAll(m.getTariff());
        }
        return tariffList;
    }

    public List<Tariff> returnTariffbyOperator(String name) {
        List<Tariff> tariffList = new ArrayList<>();
        for (MobileOperator m : mobileOperatorList) {
            if (m.getName().equals(name))
                tariffList.addAll(m.getTariff());
        }
        System.out.println(tariffList + "I'm here");
        return tariffList;
    }

    public final List<Tariff> sortByCostOperator(String nameOperator) {
        List<Tariff> tariffListByOperator = returnTariffbyOperator(nameOperator);
        Collections.sort(tariffListByOperator, new Comparator<Tariff>() {

            @Override

            public int compare(final Tariff lhs, final Tariff rhs) {
                return lhs.getPrice() > rhs.getPrice() ? -1
                        : (lhs.getPrice() < rhs.getPrice()) ? 1 : 0;
            }
        });
        return tariffListByOperator;
    }

    public void searchTariffByCostOperator(int cost, String nameOperator) {
        boolean flag = true;
        List<Tariff> tariffListByOperator = returnTariffbyOperator(nameOperator);
        for (Tariff tariff : tariffListByOperator) {
            if ((tariff.getPrice() < cost)) {
                logger.info(tariff);
                flag = true;
            }
        }
        if (!flag) {
            logger.error("Tariff not found");
        }
    }
}



