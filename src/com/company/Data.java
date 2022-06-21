package com.company;

import javax.swing.*;
import java.io.*;

public class Data {
    String line;
    String fileCarType = "D:\\CODE\\GUI\\cartypes.txt";
    String fileCarBrands = "D:\\CODE\\GUI\\carbrands.txt";
    String fileCars = "D:\\CODE\\GUI\\cars.txt";

    public void addCars(String transmission, String car, String carType, String carBrands){
        try{
            BufferedWriter bwCarTypes = new BufferedWriter(
                    new FileWriter(fileCars,true));

            bwCarTypes.write(transmission +" - "+ carBrands +" "+ car +" ("+carType+")");
            bwCarTypes.newLine();
            bwCarTypes.close();
        } catch (IOException i){ // handle errors
            i.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Data Added Success!!\n>> " + transmission +" - "+ car +" "+ carBrands +" ("+carType+")");
    }

    public DefaultListModel listDataCars(){
        DefaultListModel<String> dataCars = new DefaultListModel<>();
        try {
            BufferedReader readCarType = new BufferedReader(
                    new FileReader(fileCars));
            while ((line = readCarType.readLine()) != null) {
                dataCars.addElement(line);
            }
        } catch (IOException i) { // handle errors
            i.printStackTrace();
        }
        return dataCars;
    }
    public DefaultListModel listDataCarType(){
        DefaultListModel<String> dataCarType = new DefaultListModel<>();
        try {
            BufferedReader readCarType = new BufferedReader(
                    new FileReader(fileCarType));
            while ((line = readCarType.readLine()) != null) {
                dataCarType.addElement(line);
            }
        } catch (IOException i) { // handle errors
            i.printStackTrace();
        }
        return dataCarType;
    }
    public DefaultListModel listDataCarBrands(){
        DefaultListModel<String> dataCarBrands = new DefaultListModel<>();
        try {
            BufferedReader readCarType = new BufferedReader(
                    new FileReader(fileCarBrands));
            while ((line = readCarType.readLine()) != null) {
                dataCarBrands.addElement(line);
            }
        } catch (IOException i) { // handle errors
            i.printStackTrace();
        }
        return dataCarBrands;
    }

    public void replaceDataCars(String oldData, String newTransmisi, String newCarName, String newCarBrands, String newCarTypes) {
        String replace, forReadData, changeData;
        replace = newTransmisi +" - "+ newCarBrands +" "+ newCarName +" ("+newCarTypes+")";

        if(newCarBrands != null && newCarTypes != null){
            forReadData = "";
            try{
                BufferedReader readCars = new BufferedReader(
                        new FileReader(fileCars));

                line = readCars.readLine();
                while(line != null){
                    forReadData = forReadData + line + System.lineSeparator();
                    line = readCars.readLine();
                }

                changeData = forReadData.replace(oldData, replace);
                BufferedWriter writeCars = new BufferedWriter(
                        new FileWriter(fileCars));
                writeCars.write(changeData);
                writeCars.close();
                readCars.close();
            } catch (IOException i) { // HANDLE errors
                i.printStackTrace();
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Data Edit Successfully !!\n");
        }
        else{
            JOptionPane.showMessageDialog(
                    null,
                    "Edit Failed !! - Try Again");
        }

    }
    public void replaceDataCarType(String oldData, String newReplace){
        String forReadData, changeData;
        forReadData = "";
        try{
            BufferedReader readCarType = new BufferedReader(
                    new FileReader(fileCarType));

            line = readCarType.readLine();
            while(line != null){
                forReadData = forReadData + line + System.lineSeparator();
                line = readCarType.readLine();
            }
            changeData = forReadData.replaceAll(oldData, newReplace);
            BufferedWriter writeCarType = new BufferedWriter(
                    new FileWriter(fileCarType));
            writeCarType.write(changeData);
            writeCarType.close();
            readCarType.close();

        } catch (IOException i) { // HANDLE errors
            i.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Data Edit Successfully !!\n"+ oldData +" -> "+ newReplace);
    }
    public void replaceDataCarBrands(String oldData, String newReplace){
        String forReadData, changeData;
        forReadData = "";
        try{
            BufferedReader readCarBrands = new BufferedReader(
                    new FileReader(fileCarBrands));

            line = readCarBrands.readLine();
            while(line != null){
                forReadData = forReadData + line + System.lineSeparator();
                line = readCarBrands.readLine();
            }
            changeData = forReadData.replaceAll(oldData, newReplace);
            BufferedWriter writeCarBrands = new BufferedWriter(
                    new FileWriter(fileCarBrands));
            writeCarBrands.write(changeData);
            writeCarBrands.close();
            readCarBrands.close();

        } catch (IOException i) { // HANDLE errors
            i.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Data Edit Successfully !!\n"+ oldData +" -> "+ newReplace);
    }

    public void delCarBrands(String selected){
        String forReadData, changeData;
        forReadData = "";
        try{
            BufferedReader readCarBrands = new BufferedReader(
                    new FileReader(fileCarBrands));

            line = readCarBrands.readLine();
            while(line != null){
                forReadData = forReadData + line + System.lineSeparator();
                line = readCarBrands.readLine();
            }
            changeData = forReadData.replaceAll(selected, "");
            BufferedWriter writeCarBrands = new BufferedWriter(
                    new FileWriter(fileCarBrands));
            writeCarBrands.write(changeData);
            writeCarBrands.close();
            readCarBrands.close();

        } catch (IOException i) { // HANDLE errors
            i.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Delete [ Car Brand - " + selected + " ] Success !!");
    }
    public void delCarType(String selected){
        String forReadData, changeData;
        forReadData = "";
        try{
            BufferedReader readCarType = new BufferedReader(
                    new FileReader(fileCarType));

            line = readCarType.readLine();
            while(line != null){
                forReadData = forReadData + line + System.lineSeparator();
                line = readCarType.readLine();
            }
            changeData = forReadData.replaceAll(selected, "");
            BufferedWriter writeCarTypes = new BufferedWriter(
                    new FileWriter(fileCarType));
            writeCarTypes.write(changeData);
            writeCarTypes.close();
            readCarType.close();

        } catch (IOException i) { // HANDLE errors
            i.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Delete [ Type Of Cars - " + selected + " ] Success !!");
    }
    public void delCars(String selected){
        String forReadData, changeData;
        forReadData = "";
        try{
            BufferedReader readCars = new BufferedReader(
                    new FileReader(fileCars));

            line = readCars.readLine();
            while(line != null){
                forReadData = forReadData + line + System.lineSeparator();
                line = readCars.readLine();
            }
            changeData = forReadData.replaceAll(selected, "");
            BufferedWriter writeCars = new BufferedWriter(
                    new FileWriter(fileCars));
            writeCars.write(changeData);
            writeCars.close();
            readCars.close();

        } catch (IOException i) { // HANDLE errors
            i.printStackTrace();
        }
        JOptionPane.showMessageDialog(
                null,
                "Delete [ Cars - " + selected + " ] Success !!");
    }
}
