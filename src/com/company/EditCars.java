package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCars extends JFrame {
    JPanel jPanel;
    JButton jButtonEditCars;
    JLabel jLabelTitle ,jLabelSelect, jLabelEdit, jLabelTransimissi, jLabelCarTypes, jLabelCarBrands, jLabelCars;
    JTextField jTextFieldCars;
    JCheckBox jCheckBoxManual, jCheckBoxAutomatic;
    JList jListCars, jListCarBrands, jListCarType;

    public EditCars() throws HeadlessException {
        this("Edit Cars");
    }
    public EditCars(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }
    public void initializeApp() {
        this.setBounds(600,100,450,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelTitle = new JLabel();
        jLabelTitle.setText("[ EDIT CARS ] ");
        jPanel.add(jLabelTitle, "wrap, align 50%, span");

        jLabelSelect = new JLabel();
        jLabelSelect.setText("Select To Edit :");
        jPanel.add(jLabelSelect, "align 50% ,wrap, newline 10px, span");

        // READ LIST
        Data data = new Data();
        jListCars = new JList(data.listDataCars());
        jPanel.add(jListCars, "center, grow, wrap, span");

        // -- EDIT --
        jLabelEdit = new JLabel();
        jLabelEdit.setText("---- EDIT ----");
        jPanel.add(jLabelEdit, "center, wrap, newline 15px, span");

        jLabelCars = new JLabel();
        jLabelCars.setText("Car Name:");
        jPanel.add(jLabelCars, "align 50%, span, wrap");
        jTextFieldCars = new JTextField();
        jPanel.add(jTextFieldCars, "grow, span, wrap");

        jLabelTransimissi = new JLabel();
        jLabelTransimissi.setText("Transmission Type:");
        jPanel.add(jLabelTransimissi, "center, spanx, wrap");

        jCheckBoxAutomatic = new JCheckBox();
        jCheckBoxAutomatic.setText("Automatic");
        jPanel.add(jCheckBoxAutomatic, "center, spanx, wrap");
        jCheckBoxManual = new JCheckBox();
        jCheckBoxManual.setText("Manual");
        jPanel.add(jCheckBoxManual, "center, span, wrap");

        jLabelCarBrands = new JLabel();
        jLabelCarBrands.setText("Car Brands:");
        jPanel.add(jLabelCarBrands);

        jLabelCarTypes = new JLabel();
        jLabelCarTypes.setText("Types Of Cars:");
        jPanel.add(jLabelCarTypes, "center, wrap");

        jListCarBrands = new JList<>(data.listDataCarBrands());
        jPanel.add(jListCarBrands);

        jListCarType = new JList<>(data.listDataCarType());
        jPanel.add(jListCarType, "center, wrap");;

        // BUTTON EDIT
        jButtonEditCars = new JButton();
        jButtonEditCars.setText("Submit Edit");
        jButtonEditCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCars = String.valueOf(jListCars.getSelectedValue());
                String newCarName = jTextFieldCars.getText();
                String newCarBrands = String.valueOf(jListCarBrands.getSelectedValue());
                String newCarTypes = String.valueOf(jListCarType.getSelectedValue());
                String transmisiManual = jCheckBoxManual.getText();
                String transmisiAuto = jCheckBoxAutomatic.getText();

                if (jCheckBoxManual.isSelected() && selectedCars != null) {
                    data.replaceDataCars(selectedCars, transmisiManual, newCarName, newCarBrands, newCarTypes);
                }
                else if(jCheckBoxAutomatic.isSelected() && selectedCars != null){
                    data.replaceDataCars(selectedCars, transmisiAuto, newCarName, newCarBrands, newCarTypes);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Please Select To Edit !!");
                }
            }
        });
        jPanel.add(jButtonEditCars, "align 50% 50%, center, pushx");
    }
}
