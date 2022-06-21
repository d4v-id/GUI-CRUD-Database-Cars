package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelCars extends JFrame {
    JPanel jPanel;
    JList jListCars;
    JButton jButtonSubmit;
    JLabel jLabelDel, jLabelTitle;


    public DelCars() throws HeadlessException {
        this("Delete Cars");
    }
    public DelCars(String title) throws HeadlessException {
        super(title);
        initializeApp();
    }
    public void initializeApp() {
        this.setBounds(600,100,500,350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        jPanel = new JPanel();
        jPanel.setLayout(new MigLayout());
        this.setContentPane(jPanel);

        jLabelTitle = new JLabel();
        jLabelTitle.setText("[ CARS ] ");
        jPanel.add(jLabelTitle, "wrap, align 50%, pushx");

        jLabelDel = new JLabel();
        jLabelDel.setText("Select To Delete:");
        jPanel.add(jLabelDel, "pushx ,wrap, align 50%");

        Data data = new Data();
        jListCars = new JList<>(data.listDataCars());
        jPanel.add(jListCars, "pushx, align 50%, grow, wrap");

        // BUTTON
        jButtonSubmit = new JButton();
        jButtonSubmit.setText("Submit Delete");
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedList = String.valueOf(jListCars.getSelectedValue());
                if(selectedList != null){
                    data.delCars(selectedList);
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
