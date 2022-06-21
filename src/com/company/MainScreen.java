package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    JPanel jPanel;
    JList jList;
    JLabel jLabelCarDatabase, jLabelRecentDatabase ,jLabelCars, jLabelCarType, jLabelCarBrands;
    JButton jButtonEditCars, jButtondeleteCars, jButtonaddCars, jButtonReload;

    public MainScreen() throws HeadlessException {
        this("Mockup Database Cars");
    }
    public MainScreen(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }

    public void initializeApp(){
        this.setBounds(100,100,500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelCarDatabase = new JLabel();
        jLabelCarDatabase.setText("[ DATABASE CARS ]");
        jPanel.add(jLabelCarDatabase, "wrap, wrap");

        menuCars();
        menuCarType();
        menuCarBrands();

        jLabelRecentDatabase = new JLabel();
        jLabelRecentDatabase.setText("[ RECENT CARS ]");
        jPanel.add(jLabelRecentDatabase, "newline 25px, wrap");

        recentCars();
        refreshApp();
    }
    private void menuCars(){
        jLabelCars = new JLabel();
        jLabelCars.setText("Cars");
        jPanel.add(jLabelCars, "grow, pushx");

        // EDIT
        jButtonEditCars = new JButton();
        jButtonEditCars.setText("Edit");
        jButtonEditCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCars();
            }
        });
        jPanel.add(jButtonEditCars, "skip");

        // DELETE
        jButtondeleteCars = new JButton();
        jButtondeleteCars.setText("Delete");
        jButtondeleteCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DelCars();
            }
        });
        jPanel.add(jButtondeleteCars);

        // ADD
        jButtonaddCars = new JButton();
        jButtonaddCars.setText("Add");
        jButtonaddCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCars();
            }
        });
        jPanel.add(jButtonaddCars, "wrap");
    }
    private void menuCarType(){
        jLabelCarType = new JLabel();
        jLabelCarType.setText("Types Of Cars");
        jPanel.add(jLabelCarType);

        // EDIT
        jButtonEditCars = new JButton();
        jButtonEditCars.setText("Edit");
        jButtonEditCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCarType();
            }
        });
        jPanel.add(jButtonEditCars, "skip");

        // DELETE
        jButtondeleteCars = new JButton();
        jButtondeleteCars.setText("Delete");
        jButtondeleteCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DelCarType();
            }
        });
        jPanel.add(jButtondeleteCars);

        // ADD
        jButtonaddCars = new JButton();
        jButtonaddCars.setText("Add");
        jButtonaddCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCarType();
            }
        });
        jPanel.add(jButtonaddCars, "wrap");
    }
    private void menuCarBrands(){
        jLabelCarBrands = new JLabel();
        jLabelCarBrands.setText("Cars Brands");
        jPanel.add(jLabelCarBrands);

        // EDIT
        jButtonEditCars = new JButton();
        jButtonEditCars.setText("Edit");
        jButtonEditCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCarBrands();
            }
        });
        jPanel.add(jButtonEditCars, "skip");

        // DELETE
        jButtondeleteCars = new JButton();
        jButtondeleteCars.setText("Delete");
        jButtondeleteCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DelCarBrands();
            }
        });
        jPanel.add(jButtondeleteCars);

        // ADD
        jButtonaddCars = new JButton();
        jButtonaddCars.setText("Add");
        jButtonaddCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCarBrands();
            }
        });
        jPanel.add(jButtonaddCars, "wrap");
    }

    private void recentCars(){
        Data data = new Data();
        jList = new JList(data.listDataCars());
        jPanel.add(jList, "span, newline 5px");
    }
    private void refreshApp(){
        jButtonReload = new JButton();
        jButtonReload.setText("Reload / Refresh");
        jPanel.add(jButtonReload, "align 50%, center, span, newline 20px");
        jButtonReload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen.super.dispose();
                initializeApp();
            }
        });
    }
}
