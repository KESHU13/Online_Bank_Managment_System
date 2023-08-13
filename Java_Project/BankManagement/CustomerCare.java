
package BankManagment;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerCare extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel txt1, txt2,txt3;
    CustomerCare(){

        txt1 = new JLabel("WELCOME TO CUSTOMER CARE PORTAL");
        txt1.setFont(new Font("Osward", Font.BOLD, 20));
        txt1.setBounds(40, 40, 500, 15);
        txt1.setForeground(new Color(39, 55, 77 )); 
        add(txt1);

        txt2 = new JLabel("===>  E-mail Us - keshupandre13@gmail.com");
        txt2.setFont(new Font("Osward", Font.BOLD, 15));
        txt2.setBounds(50, 120, 500, 15);
        txt2.setForeground(Color.BLACK); 
        add(txt2);

        txt3 = new JLabel("===>  Call Us - 7440272504");
        txt3.setFont(new Font("Osward", Font.BOLD, 15));
        txt3.setBounds(50, 150, 500, 15);
        txt3.setForeground(Color.BLACK); 
        add(txt3);

        setLayout(null);
        getContentPane().setBackground(new Color(157, 178, 191));
        setSize(500,600);
        setLocation(580,95);


        
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new CustomerCare().setVisible(true);
    }
    
}