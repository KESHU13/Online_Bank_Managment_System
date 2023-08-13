package BankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Reg3 extends JFrame implements ActionListener{
    
    JLabel acc_details,acc_type,txt1,card_no,txt2,txt3,txt4,pin,txt5,services,txt7,form;
    JRadioButton type1,type2,type3,type4;
    JButton submit,cancel;
    JCheckBox ser1,ser2,ser3,ser4,ser5,ser6,txt6;
    String formno;
    Reg3(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
        
        acc_details = new JLabel("Page 3: Account Details");
        acc_details.setFont(new Font("Raleway", Font.BOLD, 22));
        acc_details.setForeground(new Color(39, 55, 77));
        acc_details.setBounds(280,40,400,40);
        add(acc_details); 
        

        
        acc_type = new JLabel("Account Type:");
        acc_type.setFont(new Font("Raleway", Font.BOLD, 18));
        acc_type.setForeground(new Color(39, 55, 77));
        acc_type.setBounds(100,130,200,30);
        add(acc_type);

        type1 = new JRadioButton("Saving Account");
        type1.setFont(new Font("Raleway", Font.BOLD, 16));
        type1.setBackground(new Color(157, 178, 191));
        
        
        type2 = new JRadioButton("Current Account");
        type2.setFont(new Font("Raleway", Font.BOLD, 16));
        type2.setBackground(new Color(157, 178, 191));

        type3 = new JRadioButton("Fixed Deposit Account");
        type3.setFont(new Font("Raleway", Font.BOLD, 16));
        type3.setBackground(new Color(157, 178, 191));
        
        type4 = new JRadioButton("Recurring Deposit Account");
        type4.setFont(new Font("Raleway", Font.BOLD, 16));
        type4.setBackground(new Color(157, 178, 191));
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(type1);
        groupgender.add(type2);
        groupgender.add(type3);
        groupgender.add(type4);

        type1.setBounds(100,165,150,30);
        add(type1);
        
        type2.setBounds(350,165,300,30);
        add(type2);
        
        type3.setBounds(100,200,250,30);
        add(type3);
        
        type4.setBounds(350,200,250,30);
        add(type4);
        
        txt1 = new JLabel("Card Number:");
        txt1.setFont(new Font("Raleway", Font.BOLD, 18));
        txt1.setForeground(new Color(39, 55, 77));
        txt1.setBounds(100,264,200,30);
        add(txt1);
        
        
        
        card_no = new JLabel("XXXX-XXXX-XXXX-XXXX");
        card_no.setFont(new Font("Raleway", Font.BOLD, 18));
        card_no.setForeground(new Color(39, 55, 77));
        card_no.setBounds(330,264,250,30);
        add(card_no);
        
        
        
        txt2 = new JLabel("(Your 16-digit Card number)");
        txt2.setFont(new Font("Raleway", Font.BOLD, 12));
        txt2.setForeground(new Color(39, 55, 77));
        txt2.setBounds(100,294,200,20);
        add(txt2);
        
        
        
        txt3 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        txt3.setFont(new Font("Raleway", Font.BOLD, 12));
        txt3.setForeground(new Color(39, 55, 77));
        txt3.setBounds(330,294,500,20);
        add(txt3);
        
        
        
        txt4 = new JLabel("PIN:");
        txt4.setFont(new Font("Raleway", Font.BOLD, 18));
        txt4.setForeground(new Color(39, 55, 77));
        txt4.setBounds(100,340,200,30);
        add(txt4);
        
        
        
        pin = new JLabel("XXXX");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setForeground(new Color(39, 55, 77));
        pin.setBounds(330,340,200,30);
        add(pin);
        
        
    
        txt5 = new JLabel("(4-digit password)");
        txt5.setFont(new Font("Raleway", Font.BOLD, 12));
        txt5.setForeground(new Color(39, 55, 77));
        txt5.setBounds(100,370,200,20);
        add(txt5);
        
        
    
        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setForeground(new Color(39, 55, 77));
        services.setBounds(100,415,200,30);
        add(services);
        
        ser1 = new JCheckBox("Internet Banking");
        ser1.setBackground(new Color(157, 178, 191));
        ser1.setFont(new Font("Raleway", Font.BOLD, 16));

        ser2 = new JCheckBox("Mobile Banking");
        ser2.setBackground(new Color(157, 178, 191));
        ser2.setFont(new Font("Raleway", Font.BOLD, 16));

        ser3 = new JCheckBox("ATM CARD");
        ser3.setBackground(new Color(157, 178, 191));
        ser3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        ser4 = new JCheckBox("E-Statement");
        ser4.setBackground(new Color(157, 178, 191));
        ser4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        ser5 = new JCheckBox("Cheque Book");
        ser5.setBackground(new Color(157, 178, 191));
        ser5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        ser6 = new JCheckBox("EMAIL Alerts");
        ser6.setBackground(new Color(157, 178, 191));
        ser6.setFont(new Font("Raleway", Font.BOLD, 16));
        
      
        txt6 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        txt6.setBackground(new Color(157, 178, 191));
        txt6.setFont(new Font("Raleway", Font.BOLD, 12));

        ser1.setBounds(100,460,200,30);
        add(ser1);
        
        ser2.setBounds(350,460,200,30);
        add(ser2);
        
        ser3.setBounds(100,500,200,30);
        add(ser3);
        
        ser4.setBounds(350,500,200,30);
        add(ser4);
        
        ser5.setBounds(100,540,200,30);
        add(ser5);
        
        ser6.setBounds(350,540,200,30);
        add(ser6);
        
        txt6.setBounds(100,600,600,20);
        add(txt6);


        txt7 = new JLabel("Form No:");
        txt7.setFont(new Font("Raleway", Font.BOLD, 14));
        txt7.setForeground(new Color(39, 55, 77));
        txt7.setBounds(700,10,70,30);
        add(txt7);
        
        
        
        form = new JLabel(formno);
        form.setFont(new Font("Raleway", Font.BOLD, 14));
        form.setForeground(new Color(39, 55, 77));
        form.setBounds(770,10,40,30);
        add(form);
         
       
        setLayout(null);
             
      
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);

        submit.setBounds(290,660,100,30);
        add(submit);
        
        cancel.setBounds(480,660,100,30);
        add(cancel);
        
        submit.addActionListener(this);
        cancel.addActionListener(this);

        getContentPane().setBackground(new Color(157, 178, 191));
        
        setSize(1000,750);
        setLocation(250,55);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(type1.isSelected()){ 
            atype = "Saving Account";
        }
        else if(type2.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(type3.isSelected()){ 
            atype = "Current Account";
        }else if(type4.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long card = (ran.nextLong() % 90000000L) + 4878142000000000L;
        String cardno = "" + Math.abs(card);
        
        long pin_no = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(pin_no);
        
        String facility = "";
        if(ser3.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(ser2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(ser2.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(ser6.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(ser5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(ser4.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submit){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Connect c1 = new Connect();
                    String q1 = "insert into register3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==cancel){
                setVisible(false);
                new Home().setVisible(true);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new Reg3("").setVisible(true);
    }
    
}