package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCars extends JFrame{
    JPanel jPanel;
    JLabel jLabelCar, jLabelTransimissi, jLabelCarTypes, jLabelCarBrands;
    JTextField jTextFieldCar;
    JButton jButtonSubmit;
    JCheckBox jCheckBoxManual, jCheckBoxAutomatic;
    JList jListCarBrands, jListCarType;

    public AddCars() throws HeadlessException {
        this("Add Cars");
    }
    public AddCars(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }
    public void initializeApp(){
        this.setBounds(600,100,300,450);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelCar = new JLabel();
        jLabelCar.setText("CARS :");
        jPanel.add(jLabelCar, "wrap, align 50%");
        jTextFieldCar = new JTextField();
        jPanel.add(jTextFieldCar, "pushx, grow, wrap");

        // TRANSMISSI
        jLabelTransimissi = new JLabel();
        jLabelTransimissi.setText("Transmission Type:");
        jPanel.add(jLabelTransimissi, "align 50%, wrap");

        jCheckBoxAutomatic = new JCheckBox();
        jCheckBoxAutomatic.setText("Automatic");
        jPanel.add(jCheckBoxAutomatic, "wrap");
        jCheckBoxManual = new JCheckBox();
        jCheckBoxManual.setText("Manual");
        jPanel.add(jCheckBoxManual, "wrap");

        // CAR BRANDS
        jLabelCarBrands = new JLabel();
        jLabelCarBrands.setText("Car Brands :");
        jPanel.add(jLabelCarBrands, "align 50%, wrap");
        Data data = new Data();
        jListCarBrands = new JList(data.listDataCarBrands());
        jPanel.add(jListCarBrands, "align 50%, center, grow, wrap");

        // CAR TYPE
        jLabelCarTypes = new JLabel();
        jLabelCarTypes.setText("Type Of Car :");
        jPanel.add(jLabelCarTypes, "align 50%, wrap");
        jListCarType = new JList(data.listDataCarType());
        jPanel.add(jListCarType, "align 50%, center, grow, wrap");

        jButtonSubmit = new JButton();
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkCarType = String.valueOf(jListCarType.getSelectedValue());
                String checkCarBrands = String.valueOf(jListCarBrands.getSelectedValue());

                if (jCheckBoxAutomatic.isSelected() && checkCarType != null && checkCarBrands != null) {
                    data.addCars(jCheckBoxAutomatic.getText(), jTextFieldCar.getText(), checkCarType, checkCarBrands);
                }
                else if (jCheckBoxManual.isSelected() && checkCarType != null && checkCarBrands != null) {
                    data.addCars(jCheckBoxManual.getText(), jTextFieldCar.getText(), checkCarType, checkCarBrands);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Add Car Failed !!"+"\n - Try Again");
                }
            }
        });
        jPanel.add(jButtonSubmit, "align 50%");
    }
}

