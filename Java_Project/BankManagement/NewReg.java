package BankManagment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class NewReg extends JFrame implements ActionListener{
    
    JLabel application_no,personal_details,name,father_name,dob,gender,mail,marital_status,address,city,pin,state,date,month,year;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton back,next;
    JDateChooser dateChooser;
    
    
    Random ran = new Random();
    long random = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(random);
    
    NewReg(){
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        setLayout(null);
        
        ImageIcon bankIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankIcon2 = bankIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon3 = new ImageIcon(bankIcon2);
        JLabel bankIcon = new JLabel(bankIcon3);
        bankIcon.setBounds(100, 5, 100, 100);
        add(bankIcon);

        
        application_no = new JLabel("APPLICATION FORM NO. "+first);
        application_no.setFont(new Font("Raleway", Font.BOLD, 38));
        application_no.setForeground(new Color(39, 55, 77 ));
        application_no.setBounds(250,30,600,40);
        add(application_no);

        
        personal_details = new JLabel("Page 1: Personal Details");
        personal_details.setFont(new Font("Raleway", Font.BOLD, 22));
        personal_details.setForeground(new Color(39, 55, 77 ));
        personal_details.setBounds(372,85,600,30);
        add(personal_details);


        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setForeground(new Color(39, 55, 77 ));
        name.setBounds(120,140,100,30);
        add(name);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBackground(new Color(221, 230, 237));
        t1.setBounds(325,140,400,30);
        add(t1);
        
        
        father_name = new JLabel("Father's Name:");
        father_name.setFont(new Font("Raleway", Font.BOLD, 20));
        father_name.setForeground(new Color(39, 55, 77 ));
        father_name.setBounds(120,190,200,30);
        add(father_name);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBackground(new Color(221, 230, 237));
        t2.setBounds(325,190,400,30);
        add(t2);

        
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setForeground(new Color(39, 55, 77 ));
        dob.setBounds(120,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(137, 337, 200, 29);
        add(dateChooser);
        
        dateChooser.setBounds(325, 240, 400, 30);
    
        
        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setForeground(new Color(39, 55, 77 ));
        gender.setBounds(120,290,200,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(157, 178, 191));
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(157, 178, 191));
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);

        r1.setBounds(325,290,60,30);
        add(r1);
        
        r2.setBounds(450,290,90,30);
        add(r2);

        

        mail = new JLabel("Email Address:");
        mail.setFont(new Font("Raleway", Font.BOLD, 20));
        mail.setForeground(new Color(39, 55, 77 ));
        mail.setBounds(120,340,200,30);
        add(mail);

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        t3.setBackground(new Color(221, 230, 237));
        t3.setBounds(325,340,400,30);
        add(t3);
        

        marital_status = new JLabel("Marital Status:");
        marital_status.setFont(new Font("Raleway", Font.BOLD, 20));
        marital_status.setForeground(new Color(39, 55, 77 ));
        marital_status.setBounds(120,390,200,30);
        add(marital_status);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(157, 178, 191));
        
        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(157, 178, 191));
        
        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(new Color(157, 178, 191));
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);

        r3.setBounds(325,390,100,30);
        add(r3);
        
        r4.setBounds(450,390,100,30);
        add(r4);
        
        r5.setBounds(635,390,100,30);
        add(r5);

        
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setForeground(new Color(39, 55, 77 ));
        address.setBounds(120,440,200,30);
        add(address);

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        t4.setBackground(new Color(221, 230, 237));
        t4.setBounds(325,440,400,30);
        add(t4);
        
        
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setForeground(new Color(39, 55, 77 ));
        city.setBounds(120,490,200,30);
        add(city);

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        t5.setBackground(new Color(221, 230, 237));
        t5.setBounds(325,490,400,30);
        add(t5);
    
        
        pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setForeground(new Color(39, 55, 77 ));
        pin.setBounds(120,540,200,30);
        add(pin);

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        t6.setBackground(new Color(221, 230, 237));
        t6.setBounds(325,540,400,30);
        add(t6);
        

        
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setForeground(new Color(39, 55, 77 ));
        state.setBounds(120,590,200,30);
        add(state);

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        t7.setBackground(new Color(221, 230, 237));
        t7.setBounds(325
        ,590,400,30);
        add(t7);
        
        date = new JLabel("Date");
        date.setFont(new Font("Raleway", Font.BOLD, 14));
        
        month = new JLabel("Month");
        month.setFont(new Font("Raleway", Font.BOLD, 14));
        
        year = new JLabel("Year");
        year.setFont(new Font("Raleway", Font.BOLD, 14));
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);  
        next.setBounds(620,660,80,30);
        add(next);
        
        next.addActionListener(this); 

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);  
        back.setBounds(500,660,80,30);
        add(back);
        
        back.addActionListener(this); 

        
        getContentPane().setBackground(new Color(157, 178, 191));
        
        setSize(1000,750);
        setLocation(250,55);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = first;
        String name = t1.getText();
        String fname = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){ 
            gender = "Male";
        }else if(r2.isSelected()){ 
            gender = "Female";
        }
            
        String email = t3.getText();
        String marital = null;
        if(r3.isSelected()){ 
            marital = "Married";
        }else if(r4.isSelected()){ 
            marital = "Unmarried";
        }else if(r5.isSelected()){ 
            marital = "Other";
        }
           
        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();
        

        try{
           
            if(ae.getSource()==next){
                if(t6.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }
                else{
                    Connect c1 = new Connect();
                    String q1 = "insert into register values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                    c1.s.executeUpdate(q1);
                    
                    new Reg2(first).setVisible(true);
                    setVisible(false);
                }
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Home().setVisible(true);
            }
            
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args){
        new NewReg().setVisible(true);
    }
}