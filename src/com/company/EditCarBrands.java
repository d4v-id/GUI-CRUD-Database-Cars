package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCarBrands extends JFrame {
    JPanel jPanel;
    JButton jButtonEditCarBrands;
    JLabel jLabelTitle ,jLabelSelect, jLabelEdit;
    JTextField jTextFieldCarBrands;
    JList jListCarBrands;

    public EditCarBrands() throws HeadlessException {
        this("Edit (Car Brands)");
    }
    public EditCarBrands(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }
    public void initializeApp() {
        this.setBounds(600,100,300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelTitle = new JLabel();
        jLabelTitle.setText("[ CAR BRANDS ] ");
        jPanel.add(jLabelTitle, "wrap, align 50%, pushx");

        jLabelSelect = new JLabel();
        jLabelSelect.setText("Select To Edit :");
        jPanel.add(jLabelSelect, "align 50% ,wrap");

        // READ DATA
        Data data = new Data();
        jListCarBrands = new JList<>(data.listDataCarBrands());
        jPanel.add(jListCarBrands, "align 50%, grow, wrap");

        jLabelEdit = new JLabel();
        jLabelEdit.setText("-- Edit --");
        jPanel.add(jLabelEdit, "align 50%, wrap");

        jTextFieldCarBrands = new JTextField();
        jPanel.add(jTextFieldCarBrands, "pushx, grow, wrap");

        // BUTTON
        jButtonEditCarBrands = new JButton();
        jButtonEditCarBrands.setText("Submit Edit");
        jButtonEditCarBrands.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jListCarBrands.getSelectedValue() != null)
                {
                    String editData = jTextFieldCarBrands.getText();
                    data.replaceDataCarBrands(String.valueOf(jListCarBrands.getSelectedValue()), editData);

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please Select To Edit !!");
                }
            }
        });
        jPanel.add(jButtonEditCarBrands, "align 50% 50%, center, pushx");
    }
}
