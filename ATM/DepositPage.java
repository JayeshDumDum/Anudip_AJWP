package search.ATM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DepositPage implements ActionListener {

    JFrame jf;
    JTextField amountField;
    JButton depositBtn, backBtn;
    int balance;

    public DepositPage(int balance) {
        this.balance = balance;

        jf = new JFrame("ATM - Deposit");
        jf.setSize(500, 400);
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(244, 241, 250));

        JLabel screen = new JLabel("ENTER DEPOSIT AMOUNT", JLabel.CENTER);
        screen.setBounds(50, 40, 400, 55);
        screen.setOpaque(true);
        screen.setBackground(new Color(230, 225, 242));
        screen.setForeground(new Color(63, 61, 86));
        screen.setFont(new Font("Segoe UI", Font.BOLD, 18));
        screen.setBorder(BorderFactory.createLineBorder(new Color(184, 178, 216), 2));
        jf.add(screen);

        amountField = new JTextField();
        amountField.setBounds(150, 130, 200, 40);
        amountField.setHorizontalAlignment(JTextField.CENTER);
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        amountField.setBorder(BorderFactory.createLineBorder(new Color(184, 178, 216)));
        jf.add(amountField);

        depositBtn = new JButton("DEPOSIT");
        depositBtn.setBounds(150, 190, 200, 42);
        depositBtn.setBackground(new Color(201, 195, 230));
        depositBtn.setForeground(new Color(63, 61, 86));
        depositBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        depositBtn.setFocusPainted(false);
        depositBtn.addActionListener(this);
        jf.add(depositBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(150, 245, 200, 42);
        backBtn.setBackground(new Color(222, 217, 242));
        backBtn.setForeground(new Color(63, 61, 86));
        backBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        jf.add(backBtn);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == depositBtn) {
            int amt = Integer.parseInt(amountField.getText());
            balance += amt;
            JOptionPane.showMessageDialog(jf,
                    "Amount Deposited: ₹" + amt + "\nUpdated Balance: ₹" + balance);
            jf.dispose();
            new MenuPage();
        }

        if (e.getSource() == backBtn) {
            jf.dispose();
            new MenuPage();
        }
    }
}