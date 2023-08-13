package BankManagment;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JLabel text, card, pin;
    JTextField card_no;
    JPasswordField pin_no;
    JButton sign_in, clear, back;
    int sliderValue = 0;
    JSlider slider;
    Timer timer;
    int interval = 3000;

    Login() {
        setTitle("LOG-IN PAGE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(195, 10, 100, 100);
        add(l11);

        ImageIcon pb1 = new ImageIcon(ClassLoader.getSystemResource("icons/11.png"));
        Image pb2 = pb1.getImage().getScaledInstance(500, 700, Image.SCALE_DEFAULT);
        ImageIcon pb3 = new ImageIcon(pb2);
        JLabel pb = new JLabel(pb3);
        pb.setBounds(0, 0, 500, 700);
        add(pb);

        text = new JLabel(" PERSONAL  BANKING ");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(595, 40, 1000, 40);
        text.setForeground(new Color(39, 55, 77)); 
        add(text);

        card = new JLabel("Card No:");
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        card.setBounds(625, 150, 375, 30);
        card.setForeground(new Color(39, 55, 77));
        add(card);

        card_no = new JTextField(15);
        card_no.setBounds(760, 150, 230, 30);
        card_no.setFont(new Font("Arial", Font.BOLD, 14));
        card_no.setBackground(new Color(221, 230, 237));
        add(card_no);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(625, 220, 375, 30);
        pin.setForeground(new Color(39, 55, 77));
        add(pin);

        pin_no = new JPasswordField(15);
        pin_no.setFont(new Font("Arial", Font.BOLD, 14));
        pin_no.setBounds(760, 220, 230, 30);
        pin_no.setBackground(new Color(221, 230, 237));
        add(pin_no);

        sign_in = new JButton("SIGN IN");
        sign_in.setBackground(Color.BLACK);
        sign_in.setForeground(Color.WHITE);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        setLayout(null);

        sign_in.setFont(new Font("Arial", Font.BOLD, 14));
        sign_in.setBounds(765, 300, 100, 30);
        add(sign_in);

        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(885, 300, 100, 30);
        add(clear);

        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBounds(822, 350, 100, 30);
        add(back);

        sign_in.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);

        getContentPane().setBackground(new Color(157, 178, 191));

        setSize(1200, 700);
        setLocation(190, 65);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
    try{
        if(ae.getSource()==sign_in){
            Connect c1 = new Connect();
            String kp = card_no.getText();
            String pin = pin_no.getText();
            String q = "select * from login where cardnumber = '"+kp+"' and pin ='"+pin+"'";

            try {
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new UserHome(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==clear){
            card_no.setText("");
            pin_no.setText("");
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Home().setVisible(true);
        }
        
    }
    catch(Exception e){
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}