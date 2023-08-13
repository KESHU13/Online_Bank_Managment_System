package BankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2;
    JButton confirm, back;
    JLabel txt1, txt2, txt3;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon atm1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image atm2 = atm1.getImage().getScaledInstance(750, 795, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atm = new JLabel(atm3);
        atm.setBounds(0, 0, 750, 795);
        add(atm);

        txt1 = new JLabel("CHANGE YOUR PIN");
        txt1.setForeground(Color.WHITE);
        txt1.setFont(new Font("System", Font.BOLD, 16));
        txt1.setBounds(206, 320, 400, 35);
        atm.add(txt1);

        txt2 = new JLabel("New PIN:");
        txt2.setFont(new Font("System", Font.BOLD, 16));
        txt2.setForeground(Color.WHITE);
        txt2.setBounds(135, 380, 150, 35);
        atm.add(txt2);

        txt3 = new JLabel("Re-Enter New PIN:");
        txt3.setFont(new Font("System", Font.BOLD, 16));
        txt3.setForeground(Color.WHITE);
        txt3.setBounds(135, 415, 200, 35);
        atm.add(txt3);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(280, 387, 120, 18);
        atm.add(t1);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(280, 422, 120, 18);
        atm.add(t2);

        confirm = new JButton("CONFIRM CHANGE");
        back = new JButton("BACK");

        confirm.setBounds(285, 467, 145, 25);
        atm.add(confirm);

        back.setBounds(285, 497, 145, 25);
        atm.add(back);

        confirm.addActionListener(this);
        back.addActionListener(this);

        setLayout(null);

        getContentPane().setBackground(new Color(157, 178, 191));

        setSize(750, 830);
        setLocation(353, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try {
            String npin = t1.getText();
            String rpin = t2.getText();
            
            
            
            if(ae.getSource()==confirm){
                
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                else if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                else if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                

                else{
                    Connect c1 = new Connect();
                    String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                    String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                    String q3 = "update register3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new AtmScreen(rpin).setVisible(true);
                }
            
            }
            else if(ae.getSource()==back){
                new AtmScreen(pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}
