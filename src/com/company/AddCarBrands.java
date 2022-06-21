package com.company;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddCarBrands extends JFrame {
    JPanel jPanel;
    JLabel jLabelBrands;
    JTextField jTextFieldBrands;
    JButton jButtonSubmit;

    public AddCarBrands() throws HeadlessException {
        this("Add (Car Brands)");
    }
    public AddCarBrands(String title) throws HeadlessException {
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

        jLabelBrands = new JLabel();
        jLabelBrands.setText("Add - Car Brands");
        jPanel.add(jLabelBrands, "align 50%, wrap");

        jTextFieldBrands = new JTextField();
        jPanel.add(jTextFieldBrands, "pushx, grow, wrap");

        jButtonSubmit = new JButton();
        jButtonSubmit.setText("Submit");
        jButtonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BufferedWriter bwCarTypes = new BufferedWriter(
                            new FileWriter("D:\\CODE\\GUI\\carbrands.txt",true));

                    bwCarTypes.write(jTextFieldBrands.getText());
                    bwCarTypes.newLine();
                    bwCarTypes.close();
                } catch (IOException i){
                    System.out.println("An error occurred.");
                    i.printStackTrace();
                }
                JOptionPane.showMessageDialog(
                        null,
                        "Data Added Successfully "+"\n - "+jTextFieldBrands.getText());
            }
        });
        jPanel.add(jButtonSubmit, "align 50%");
    }
}