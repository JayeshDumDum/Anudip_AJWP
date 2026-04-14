package search.ATM;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPage implements ActionListener {

    JFrame jf;
    JButton balanceBtn, depositBtn, withdrawBtn, exitBtn;
    int balance = 5000;

    public MenuPage() {

        jf = new JFrame("ATM Menu");
        jf.setSize(500, 450);
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(244, 241, 250));

        JLabel screen = new JLabel("SELECT TRANSACTION", JLabel.CENTER);
        screen.setBounds(50, 40, 400, 55);
        screen.setOpaque(true);
        screen.setBackground(new Color(230, 225, 242));
        screen.setForeground(new Color(63, 61, 86));
        screen.setFont(new Font("Segoe UI", Font.BOLD, 20));
        screen.setBorder(BorderFactory.createLineBorder(new Color(184, 178, 216), 2));
        jf.add(screen);

        balanceBtn = new JButton("BALANCE");
        balanceBtn.setBounds(70, 150, 160, 45);
        balanceBtn.setBackground(new Color(222, 217, 242));
        balanceBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        balanceBtn.addActionListener(this);
        jf.add(balanceBtn);

        depositBtn = new JButton("DEPOSIT");
        depositBtn.setBounds(270, 150, 160, 45);
        depositBtn.setBackground(new Color(201, 195, 230));
        depositBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        depositBtn.addActionListener(this);
        jf.add(depositBtn);

        withdrawBtn = new JButton("WITHDRAW");
        withdrawBtn.setBounds(70, 220, 160, 45);
        withdrawBtn.setBackground(new Color(201, 195, 230)); // soft rose
        withdrawBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        withdrawBtn.addActionListener(this);
        jf.add(withdrawBtn);

        exitBtn = new JButton("EXIT");
        exitBtn.setBounds(270, 220, 160, 45);
        exitBtn.setBackground(new Color(222, 217, 242));
        exitBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        exitBtn.addActionListener(this);
        jf.add(exitBtn);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == balanceBtn) {
            JOptionPane.showMessageDialog(jf, "Balance : ₹" + balance);
        }

        if (e.getSource() == depositBtn) {
            jf.dispose();
            new DepositPage(balance);
        }

        if (e.getSource() == withdrawBtn) {
            jf.dispose();
            new WithdrawPage(balance);
        }

        if (e.getSource() == exitBtn) {
            jf.dispose();
            new LoginPage();
        }
    }
}