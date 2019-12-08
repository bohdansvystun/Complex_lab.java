package com.Kitik.model;

import com.Kitik.model.Network.CellPhone;
import com.Kitik.model.Network.GetFromFile;
import com.Kitik.model.Network.MobileOperator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<MobileOperator> mobileOperatorList;
    private List<CellPhone> cellPhoneList;

    public Model() {
        mobileOperatorList = new ArrayList<>();
        cellPhoneList = new ArrayList<>();
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

    public final void showCellPhones(){
    }
}

