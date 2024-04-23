package com.example.ui;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.ItemEvent;
import javax.swing.plaf.FontUIResource;

public class BlockchainUI {
    private final JFrame window;
    private static String TITLE = "Blockchain Statistics";
    private JTextField inputField;
    private JButton submitButton;

    public BlockchainUI() {
        window = new JFrame(TITLE);
        initInputScreen();

        window.setSize(700, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private void initInputScreen() {
        inputField = new JTextField("Enter a blockchain name here");
        inputField.setBounds(100, 100, 35, 70);
        inputField.setBackground(Color.ORANGE);
        window.add(inputField);
        

        submitButton = createButton("Submit");
    }

    private JButton createButton(String label) {
        JButton btn = new JButton(label);
        btn.setFocusable(false);
        window.add(btn);

        return btn;
    }

}
