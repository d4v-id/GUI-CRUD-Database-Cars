package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelCarType extends JFrame {
    JPanel jPanel;
    JList jListCarType;
    JButton jButtonSubmit;
    JLabel jLabelDel, jLabelTitle;

    public DelCarType() throws HeadlessException {
        this("Delete (Types Of Cars)");
    }

    public DelCarType(String title) throws HeadlessException {
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
        jLabelTitle.setText("[ TYPES OF CARS ] ");
        jPanel.add(jLabelTitle, "wrap, align 50%, pushx");

        jLabelDel = new JLabel();
        jLabelDel.setText("Select To Delete:");
        jPanel.add(jLabelDel, "pushx ,wrap, align 50%");

        Data data = new Data();
        jListCarType = new JList<>(data.listDataCarType());
        jPanel.add(jListCarType, "pushx, align 50%, grow, wrap");

        // BUTTON
        jButtonSubmit = new JButton();
        jButtonSubmit.setText("Submit Delete");
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedList = String.valueOf(jListCarType.getSelectedValue());
                if(selectedList != null){
                    data.delCarType(selectedList);
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
