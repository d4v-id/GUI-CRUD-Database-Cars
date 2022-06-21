package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCarType extends JFrame{
    JPanel jPanel;
    JButton jButtonEditCarType;
    JLabel jLabelTitle ,jLabelSelect, jLabelEdit;
    JTextField jTextFieldCarTypes;
    JList jListCarType;
    String line, changeData, forReadData;

    public EditCarType() throws HeadlessException {
        this("Edit (Types Of Cars)");
    }
    public EditCarType(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }
    public void initializeApp() {
        this.setBounds(600, 100, 300, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelTitle = new JLabel();
        jLabelTitle.setText("[ TYPES OF CARS ] ");
        jPanel.add(jLabelTitle, "wrap, align 50%, pushx");

        jLabelSelect = new JLabel();
        jLabelSelect.setText("Select To Edit :");
        jPanel.add(jLabelSelect, "align 50% ,wrap");

        // READ DATA
        Data data = new Data();
        jListCarType = new JList<>(data.listDataCarType());
        jPanel.add(jListCarType, "align 50%, grow, wrap");

        jLabelEdit = new JLabel();
        jLabelEdit.setText("-- Edit --");
        jPanel.add(jLabelEdit, "align 50%, wrap");

        jTextFieldCarTypes = new JTextField();
        jPanel.add(jTextFieldCarTypes, "pushx, grow, wrap");

        // BUTTON
        jButtonEditCarType = new JButton();
        jButtonEditCarType.setText("Submit Edit");
        jButtonEditCarType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jListCarType.getSelectedValue() != null)
                {
                    String editData = jTextFieldCarTypes.getText();
                    data.replaceDataCarType(String.valueOf(jListCarType.getSelectedValue()), editData);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Please Select To Edit !!");
                }
            }
        });
        jPanel.add(jButtonEditCarType, "align 50% 50%, center, pushx");
    }
}
