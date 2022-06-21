package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddCarType extends JFrame {
    JPanel jPanel;
    JLabel jLabelType;
    JTextField jTextFieldType;
    JButton jButtonSubmit;

    public AddCarType() throws HeadlessException {
        this("Add (Types Of Cars)");
    }
    public AddCarType(String title) throws HeadlessException {
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

        jLabelType = new JLabel();
        jLabelType.setText("Add - Types Of Cars");
        jPanel.add(jLabelType, "align 50%, wrap");

        jTextFieldType = new JTextField();
        jPanel.add(jTextFieldType, "pushx, grow, wrap");

        jButtonSubmit = new JButton();
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BufferedWriter bwCarTypes = new BufferedWriter(
                            new FileWriter("D:\\CODE\\GUI\\cartypes.txt",true));

                    bwCarTypes.write(jTextFieldType.getText());
                    bwCarTypes.newLine();
                    bwCarTypes.close();
                } catch (IOException i){ // handle errors
                    System.out.println("An error occurred.");
                    i.printStackTrace();
                }
                JOptionPane.showMessageDialog(
                        null,
                        "Data Added Successfully !!"+"\n - "+jTextFieldType.getText()
                );
            }
        });
        jPanel.add(jButtonSubmit, "align 50%");
    }
}
