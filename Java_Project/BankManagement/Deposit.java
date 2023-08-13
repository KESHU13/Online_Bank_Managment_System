package BankManagment;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton deposit,back;
    JLabel txt1,l2,atm;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        
        ImageIcon atm1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image atm2 = atm1.getImage().getScaledInstance(750, 795, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atm = new JLabel(atm3);
        atm.setBounds(0, 0, 750, 795);
        add(atm);
        
        txt1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        txt1.setForeground(Color.WHITE);
        txt1.setFont(new Font("System", Font.BOLD, 14));
        txt1.setBounds(135,320,400,35);
        atm.add(txt1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 18));
        t1.setBounds(165,365,240,25);
        atm.add(t1);
        
        deposit = new JButton("DEPOSIT");
        back = new JButton("BACK");
       
        deposit.setBounds(333,467,95,25);
        atm.add(deposit);
        
        back.setBounds(333,497,95,25);
        atm.add(back);
        
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        setLayout(null);
        getContentPane().setBackground(new Color(157, 178, 191));
        
        setSize(750,830);
        setLocation(353,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    try {
                        Connect c1 = new Connect();
                        String q1="insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')";
                        c1.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                        setVisible(false);
                        new Login().setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new AtmScreen(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}