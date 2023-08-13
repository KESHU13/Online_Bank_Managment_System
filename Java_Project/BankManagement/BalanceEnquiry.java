package BankManagment;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton back, b2, b3;
    JLabel txt, l2, atm, amount;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        
        ImageIcon atm1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image atm2 = atm1.getImage().getScaledInstance(750, 795, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atm = new JLabel(atm3);
        atm.setBounds(0, 0, 750, 795);
        add(atm);
        
        txt = new JLabel("Your Current Account Balance is");
        txt.setForeground(Color.WHITE);
        txt.setBounds(157, 320, 340, 35);
        txt.setFont(new Font("System", Font.BOLD, 16));
        atm.add(txt);


        amount = new JLabel();
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(240, 340, 400, 40);
        atm.add(amount);


        back = new JButton("BACK");
        back.setBounds(333,497,95,25);
        atm.add(back);
        int balance = 0;


        try{
            Connect c1 = new Connect();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        amount.setText(" Rs "+balance);

        back.addActionListener(this);

        setLayout(null);
        getContentPane().setBackground(new Color(157, 178, 191));
        setSize(750,830);
        setLocation(353,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new UserHome(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}

