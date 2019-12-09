package com.Kitik.model;

import com.Kitik.model.Network.CellPhone;
import com.Kitik.model.Network.GetFromFile;
import com.Kitik.model.Network.MobileOperator;
import com.Kitik.model.Network.Tariff;
import com.Kitik.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

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
                    "C:\\Users\\MyFantasy\\IdeaProjects\\Kolya_Task\\data.txt");
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
            mobileOperatorList.add(mobileOperator);
            FileOutputStream fo = new FileOutputStream(
                    "C:\\Users\\MyFantasy\\IdeaProjects\\Kolya_Task\\data.txt");
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
        for (MobileOperator m : mobileOperatorList){
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
                count++;
            }
        }
        return count;
    }



    public List<Tariff> returnAllTariff(){
        List<Tariff> tariffList = new ArrayList<>();
        for (MobileOperator m : mobileOperatorList){
            tariffList.addAll(m.getTariff());
        }
        return tariffList;
    }


    public final void sortByCost() {
        Collections.sort(tariffList = returnAllTariff(), new Comparator<Tariff>() {
            @Override
            public int compare(final Tariff lhs, final Tariff rhs) {
                return lhs.getPrice() > rhs.getPrice() ? -1
                        : (lhs.getPrice() < rhs.getPrice()) ? 1 : 0;
            }
        });
    }


    public final List<Tariff> sortByCostOperator(String nameOperator) {
        List<Tariff> tariffListByOperator = new ArrayList<>();
        boolean flag = true;
        for (MobileOperator m : mobileOperatorList) {
            if ((m.getName().equals(nameOperator)) && flag) {
                tariffListByOperator = returnAllTariff();
                flag = false;
            }
            Collections.sort(tariffListByOperator, new Comparator<Tariff>() {
                @Override
                public int compare(final Tariff lhs, final Tariff rhs) {
                    return lhs.getPrice() > rhs.getPrice() ? -1
                            : (lhs.getPrice() < rhs.getPrice()) ? 1 : 0;
                }
            });
        }
        return tariffListByOperator;
    }

    public void searchTariffByCost(int cost) {

        boolean flag = true;
        boolean flagok = false;
        for (Tariff tariff : tariffList) {
            if ((tariff.getPrice() < 50)) {
                logger.info(tariff);
                flagok = true;
            }

        }
        if (!flagok) {
            logger.error("Tariff not found");
        }
    }

    public void searchTariffByCostOperator(int cost, String nameOperator) {
        //renewTariffList();
        boolean flag = true;
        List<Tariff> tariffListByOperator = new ArrayList<>();
        for (MobileOperator m : mobileOperatorList) {
            if ((m.getName().equals(nameOperator)) && flag) {
                tariffListByOperator.addAll(mobileOperator.getTariff());
                flag = false;
            }
        }
        flag = true;
        for (Tariff tariff : tariffListByOperator) {
            if (tariff.getPrice() < cost) {
                logger.info(tariff);
                flag = false;
            }
        }
        if (flag) {
            logger.error("Tariff not found");
        }
    }
}

