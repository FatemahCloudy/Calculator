package com.example.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JPanel panel;

    // create the operators
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton mulButton = new JButton("*");
    JButton divButton = new JButton("/");
    JButton equalButton = new JButton("=");
    JButton decButton = new JButton(".");
    JButton clearButton = new JButton("Clear");
    JButton delButton = new JButton("Delete");

    // An array of operators
    JButton[] operatorButtons = {addButton, subButton, mulButton, divButton, equalButton,
            decButton, clearButton, delButton};

    Font font = new Font("Arial", Font.BOLD, 30); // to be used for buttons and text field
    double number1, number2;
    char operator;

    Calculator() {

        //create the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //create the text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.LEFT);
        textField.setEditable(false);

        //add the field to the frame and make it visible
        frame.add(textField);
        frame.setVisible(true);

        // associate the operators with the action listener

        for (JButton operatorButton : operatorButtons) {
            operatorButton.addActionListener(this);
            operatorButton.setFont(font);
            operatorButton.setFocusable(false);
        }

        //creat number buttons

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        // creating delete and clear buttons

        delButton.setBounds(50, 430, 145, 50);
        clearButton.setBounds(205, 430, 145, 50);

        // Creating the panel

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add the number buttons and operators to the panel

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

        // refresh the frame
        frame.validate();

    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i<10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText()
                        .concat(String.valueOf(numberButtons[i].getText())));
            }
        }
        if (e.getSource() == decButton)
            textField.setText(textField.getText().concat("."));

        if (e.getSource() == addButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            number1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton) {
            number2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case ('+'):
                    number1 = number1 + number2;
                    break;
                case ('-'):
                    number1 = number1 - number2;
                    break;
                case ('*'):
                    number1 = number1 * number2;
                    break;
                case ('/'):
                    number1 = number1 / number2;
                    break;
            }
            textField.setText(String.valueOf(number1));
        }

        if (e.getSource() == clearButton) {
            textField.setText("");
        }


        if (e.getSource() == delButton) {
            String s = textField.getText();
            if (!(s.isEmpty())) {
                // Remove the last character from the text field
                s = s.substring(0, s.length() - 1);
                textField.setText(s);
            }
        }


    }
}
