package BankManagment;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.*;


public class FastCash extends JFrame implements ActionListener {

    JLabel txt1, l2;
    JButton amt1, amt2, amt3, amt4, amt5, amt6, back, b8;
    JTextField t1;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        
        ImageIcon atm1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image atm2 = atm1.getImage().getScaledInstance(750, 795, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atm = new JLabel(atm3);
        atm.setBounds(0, 0, 750, 795);
        add(atm);

        txt1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        txt1.setForeground(Color.WHITE);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setBounds(160,320,400,35);
        atm.add(txt1);

        amt1 = new JButton("Rs 100");
        amt2 = new JButton("Rs 500");
        amt3 = new JButton("Rs 1000");
        amt4 = new JButton("Rs 2000");
        amt5 = new JButton("Rs 5000");
        amt6 = new JButton("Rs 10000");
        back = new JButton("BACK");

        

        amt1.setBounds(130,401,120,25);
        atm.add(amt1);

        amt2.setBounds(280,401,150,25);
        atm.add(amt2);

        amt3.setBounds(130,432,120,25);
        atm.add(amt3);

        amt4.setBounds(280,432,150,25);
        atm.add(amt4);

        amt5.setBounds(130,463,120,25);
        atm.add(amt5);
        
        amt6.setBounds(280,463,150,25);
        atm.add(amt6);
    
        back.setBounds(280,494,150,25);
        atm.add(back);

        amt1.addActionListener(this);
        amt2.addActionListener(this);
        amt3.addActionListener(this);
        amt4.addActionListener(this);
        amt5.addActionListener(this);
        amt6.addActionListener(this);
        back.addActionListener(this);

        setLayout(null);
        getContentPane().setBackground(new Color(157, 178, 191));
        
        setSize(750,830);
        setLocation(353,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back) {
                this.setVisible(false);
                new AtmScreen(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new AtmScreen(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}