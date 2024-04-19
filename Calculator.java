package com.example.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JPanel panel;

    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton mulButton = new JButton("*");
    JButton divButton = new JButton("/");
    JButton equalButton = new JButton("=");
    JButton decButton = new JButton(".");
    JButton clearButton = new JButton("Clear");
    JButton delButton = new JButton("Delete");


    JButton[] operatorButtons = {addButton, subButton, mulButton, divButton, equalButton, decButton};

    Font font = new Font("Arial", Font.BOLD, 30);
    double number1, number2;
    char operator;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.LEFT);
        textField.setEditable(false);

        frame.add(textField);
        frame.setVisible(true);

        for (JButton operatorButton : operatorButtons) {
            operatorButton.addActionListener(this);
            operatorButton.setFont(font);
            operatorButton.setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        delButton.setBounds(50, 430, 145, 50);
        clearButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clearButton);

        frame.validate();

    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method setup
    }
}
