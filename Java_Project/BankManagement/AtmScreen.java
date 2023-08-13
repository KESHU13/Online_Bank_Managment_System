package BankManagment;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AtmScreen extends JFrame implements ActionListener{

    JLabel txt;
    JButton deposit,withdrawl,fastCash,mini_state,pin_change,balance,b7;
    String pin;
    AtmScreen(String pin){
        this.pin = pin;
        ImageIcon atm1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image atm2 = atm1.getImage().getScaledInstance(750, 795, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atm = new JLabel(atm3);
        atm.setBounds(0, 0, 750, 795);
        add(atm);
        
        txt = new JLabel("Please Select Your Transaction");
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System", Font.BOLD, 16));
        txt.setBounds(165,300,700,35);
        atm.add(txt);
        
       
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(130,401,120,25);
        atm.add(deposit);

        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(280,401,150,25);
        atm.add(withdrawl);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(130,432,120,25);
        atm.add(fastCash);

        mini_state = new JButton("MINI STATEMENT");
        mini_state.setBounds(280,432,150,25);
        atm.add(mini_state);

        pin_change = new JButton("PIN CHANGE");
        pin_change.setBounds(130,463,120,25);
        atm.add(pin_change);

        balance = new JButton("BALANCE ENQUIRY");
        balance.setBounds(280,463,150,25);
        atm.add(balance);

        b7 = new JButton("EXIT");
        b7.setBounds(280,494,150,25);
        atm.add(b7);
        
        
        deposit.addActionListener(this);
        withdrawl.addActionListener(this);
        fastCash.addActionListener(this);
        mini_state.addActionListener(this);
        pin_change.addActionListener(this);
        balance.addActionListener(this);
        b7.addActionListener(this);

        
        setLayout(null);
        
        getContentPane().setBackground(new Color(157, 178, 191));
        setUndecorated(true);
        setSize(750,830);
        setLocation(365,10);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){ 
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){ 
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if(ae.getSource()==fastCash){ 
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(ae.getSource()==mini_state){ 
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()==pin_change){ 
            setVisible(false);
            new Pin(pin).setVisible(true);
        }
        else if(ae.getSource()==balance){ 
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else{
            this.setVisible(false);
            new UserHome(pin).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new AtmScreen("").setVisible(true);
    }
}