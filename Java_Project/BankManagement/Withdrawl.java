package BankManagment;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amt,t2;
    JButton withdraw,back,b3;
    JLabel txt1,txt2,atm,l4;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon atm1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image atm2 = atm1.getImage().getScaledInstance(750, 795, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atm = new JLabel(atm3);
        atm.setBounds(0, 0, 750, 795);
        add(atm);

        txt1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        txt1.setForeground(Color.WHITE);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        
        txt2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        txt2.setForeground(Color.WHITE);
        txt2.setFont(new Font("System", Font.BOLD, 14));
        
        amt = new JTextField();
        amt.setFont(new Font("Raleway", Font.BOLD, 25));
        
        withdraw = new JButton("WITHDRAW");
        back = new JButton("BACK");
        
        txt1.setBounds(135,310,400,35);
        atm.add(txt1);
        
        txt2.setBounds(165,370,400,20);
        atm.add(txt2);
        
        amt.setBounds(165,400,240,25);
        atm.add(amt);
        
        withdraw.setBounds(308,467,120,25);
        atm.add(withdraw);
        
        back.setBounds(308,497,120,25);
        atm.add(back);
        
        withdraw.addActionListener(this);
        back.addActionListener(this);

        setLayout(null);
        
        getContentPane().setBackground(new Color(157, 178, 191));
        
        setSize(750,830);
        setLocation(353,0);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = amt.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(amt.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Connect c1 = new Connect();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 1000;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new AtmScreen(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new AtmScreen(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}