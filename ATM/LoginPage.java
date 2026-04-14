package search.ATM;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage implements ActionListener {

    JFrame jf;
    JTextField pinField;
    JButton enterBtn;

    public LoginPage() {

        jf = new JFrame("ATM Login");
        jf.setSize(500, 400);
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(244, 241, 250)); // light lavender

        JLabel screen = new JLabel("WELCOME TO ATM", JLabel.CENTER);
        screen.setBounds(50, 40, 400, 55);
        screen.setOpaque(true);
        screen.setBackground(new Color(230, 225, 242));
        screen.setForeground(new Color(63, 61, 86));
        screen.setFont(new Font("Segoe UI", Font.BOLD, 22));
        screen.setBorder(BorderFactory.createLineBorder(new Color(184, 178, 216), 2));
        jf.add(screen);

        JLabel pinLabel = new JLabel("ENTER PIN");
        pinLabel.setBounds(200, 120, 120, 25);
        pinLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pinLabel.setForeground(new Color(107, 106, 126));
        jf.add(pinLabel);

        pinField = new JTextField();
        pinField.setBounds(150, 155, 200, 40);
        pinField.setHorizontalAlignment(JTextField.CENTER);
        pinField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        pinField.setBorder(BorderFactory.createLineBorder(new Color(184, 178, 216)));
        jf.add(pinField);

        enterBtn = new JButton("ENTER");
        enterBtn.setBounds(180, 220, 140, 42);
        enterBtn.setBackground(new Color(201, 195, 230));
        enterBtn.setForeground(new Color(63, 61, 86));
        enterBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        enterBtn.setFocusPainted(false);
        enterBtn.addActionListener(this);
        jf.add(enterBtn);

        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pinField.getText().equals("1234")) {
            jf.dispose();
            new MenuPage();
        } else {
            JOptionPane.showMessageDialog(jf, "Invalid PIN");
            pinField.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}