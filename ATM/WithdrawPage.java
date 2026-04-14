package search.ATM;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WithdrawPage implements ActionListener {

    JFrame jf;
    JTextField amountField;
    JButton withdrawBtn, backBtn;
    int balance;

    public WithdrawPage(int balance) {
        this.balance = balance;

        jf = new JFrame("ATM - Withdraw");
        jf.setSize(500, 400);
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(244, 241, 250));

        JLabel screen = new JLabel("ENTER WITHDRAW AMOUNT", JLabel.CENTER);
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

        withdrawBtn = new JButton("WITHDRAW");
        withdrawBtn.setBounds(150, 190, 200, 42);
        withdrawBtn.setBackground(new Color(214, 164, 180)); // soft rose
        withdrawBtn.setForeground(new Color(63, 61, 86));
        withdrawBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        withdrawBtn.setFocusPainted(false);
        withdrawBtn.addActionListener(this);
        jf.add(withdrawBtn);

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

        if (e.getSource() == withdrawBtn) {
            int amt = Integer.parseInt(amountField.getText());

            if (amt <= balance) {
                balance -= amt;
                JOptionPane.showMessageDialog(jf,
                        "Amount Withdrawn: ₹" + amt + "\nRemaining Balance: ₹" + balance);
            } else {
                JOptionPane.showMessageDialog(jf, "Insufficient Balance");
            }

            jf.dispose();
            new MenuPage();
        }

        if (e.getSource() == backBtn) {
            jf.dispose();
            new MenuPage();
        }
    }
}