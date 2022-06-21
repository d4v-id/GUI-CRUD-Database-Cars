package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelCarBrands extends JFrame {
    JPanel jPanel;
    JList jListCarBrands;
    JButton jButtonSubmit;
    JLabel jLabelDel, jLabelTitle;

    public DelCarBrands() throws HeadlessException {
        this("Delete (Car Brands)");
    }

    public DelCarBrands(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }
    public void initializeApp() {
        this.setBounds(600,100,300,250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelTitle = new JLabel();
        jLabelTitle.setText("[ CAR BRANDS ] ");
        jPanel.add(jLabelTitle, "wrap, align 50%, pushx");

        jLabelDel = new JLabel();
        jLabelDel.setText("Select To Delete:");
        jPanel.add(jLabelDel, "pushx ,wrap, align 50%");

        Data data = new Data();
        jListCarBrands = new JList<>(data.listDataCarBrands());
        jPanel.add(jListCarBrands, "pushx, align 50%, grow, wrap");

        // BUTTON
        jButtonSubmit = new JButton();
        jButtonSubmit.setText("Submit Delete");
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedList = String.valueOf(jListCarBrands.getSelectedValue());
                if(selectedList != null){
                    data.delCarBrands(selectedList);
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "Please Select To Delete !!");
                }
            }
        });
        jPanel.add(jButtonSubmit, "align 50%, center");
    }
}
