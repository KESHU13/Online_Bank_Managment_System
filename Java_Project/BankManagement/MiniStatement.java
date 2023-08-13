package BankManagment;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton exit, b2;
    JLabel txt1;
    MiniStatement(String pin){
        super("Mini Statement");
        getContentPane().setBackground(new Color(157, 178, 191));
        setSize(400,600);
        setLocation(525,50);
        
        txt1 = new JLabel();
        add(txt1);
        
        JLabel txt2 = new JLabel("OUR BANK");
        txt2.setBounds(150, 20, 100, 20);
        add(txt2);
        
        JLabel txt3 = new JLabel();
        txt3.setBounds(20, 80, 300, 20);
        add(txt3);
        
        JLabel txt4 = new JLabel();
        txt4.setBounds(20, 400, 300, 20);
        add(txt4);
        
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                txt3.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e){

        }
        	 
        try{
            int balance = 0;
            Connect c1  = new Connect();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                txt1.setText(txt1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            txt4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        exit = new JButton("Exit");
        add(exit);
        
        exit.addActionListener(this);
        
        txt1.setBounds(20, 100, 400, 200);
        exit.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}