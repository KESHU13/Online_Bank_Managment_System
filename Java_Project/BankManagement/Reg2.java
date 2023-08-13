package BankManagment;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reg2 extends JFrame implements ActionListener{
    
    JLabel additional_details,religion,category,income,education,occupation,pan_no,adhaar_no,senior_citizen,existing_acc,additional_details1,form_no,form_no2;
    JButton next;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    Reg2(String formno){
        
        ImageIcon bankIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankIcon2 = bankIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon3 = new ImageIcon(bankIcon2);
        JLabel bankIcon = new JLabel(bankIcon3);
        bankIcon.setBounds(170, 0, 100, 100);
        add(bankIcon);;;
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        additional_details = new JLabel("Page 2: Additonal Details");
        additional_details.setFont(new Font("Raleway", Font.BOLD, 22));
        additional_details.setForeground(new Color(39, 55, 77));
        additional_details.setBounds(330,32,600,40);
        add(additional_details);

        education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 18));
        education.setForeground(new Color(39, 55, 77));
        education.setBounds(140,130,100,30);
        add(education);

        String Education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(Education);
        c4.setBackground(new Color(221, 230, 237));
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        c4.setBounds(370,130,320,30);
        add(c4);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setForeground(new Color(39, 55, 77));
        occupation.setBounds(140,185,150,30);
        add(occupation);

        String Occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(Occupation);
        c5.setBackground(new Color(221, 230, 237));
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        c5.setBounds(370,185,320,30);
        add(c5);


        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setForeground(new Color(39, 55, 77));
        income.setBounds(140,240,100,30);
        add(income);
        
        String Income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(Income);
        c3.setBackground(new Color(221, 230, 237));
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        c3.setBounds(370,240,320,30);
        add(c3);
        
 
        

        pan_no = new JLabel("PAN Number:");
        pan_no.setFont(new Font("Raleway", Font.BOLD, 18));
        pan_no.setForeground(new Color(39, 55, 77));
        pan_no.setBounds(140,295,150,30);
        add(pan_no);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBackground(new Color(221, 230, 237));
        t1.setBounds(370,295,320,30);
        add(t1);


        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setForeground(new Color(39, 55, 77));
        religion.setBounds(140,350,150,30);
        add(religion);

        String Religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(Religion);
        c1.setBackground(new Color(221, 230, 237));
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        c1.setBounds(370,350,320,30);
        add(c1);
        
        
        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setForeground(new Color(39, 55, 77));
        category.setBounds(140,405,100,30);
        add(category);

        String Category[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(Category);
        c2.setBackground(new Color(221, 230, 237));
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        c2.setBounds(370,405,320,30);
        add(c2);
        
       
        adhaar_no = new JLabel("Adhaar Number:");
        adhaar_no.setFont(new Font("Raleway", Font.BOLD, 18));
        adhaar_no.setForeground(new Color(39, 55, 77));
        adhaar_no.setBounds(140,460,180,30);
        add(adhaar_no);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBackground(new Color(221, 230, 237));
        t2.setBounds(370,460,320,30);
        add(t2);

        
        senior_citizen = new JLabel("Senior Citizen:");
        senior_citizen.setFont(new Font("Raleway", Font.BOLD, 18));
        senior_citizen.setForeground(new Color(39, 55, 77));
        senior_citizen.setBounds(140,510,150,30);
        add(senior_citizen);

        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(157, 178, 191));
        r1.setBounds(370,510,100,30);
        add(r1);
        
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(157, 178, 191));
        r2.setBounds(480,510,100,30);
        add(r2);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r1);
        groupstatus.add(r2);
        
        
        existing_acc = new JLabel("Existing Account:");
        existing_acc.setFont(new Font("Raleway", Font.BOLD, 18));
        existing_acc.setForeground(new Color(39, 55, 77));
        existing_acc.setBounds(140,560,180,30);
        add(existing_acc);

        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(157, 178, 191));
        r3.setBounds(370,560,100,30);
        add(r3);
        
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(157, 178, 191));
        r4.setBounds(480,560,100,30);
        add(r4);

        ButtonGroup groupstatus2 = new ButtonGroup();
        groupstatus2.add(r3);
        groupstatus2.add(r4);

        
        form_no = new JLabel("Form No:");
        form_no.setFont(new Font("Raleway", Font.BOLD, 15));
        form_no.setForeground(new Color(39, 55, 77));
        form_no.setBounds(700,15,70,30);
        add(form_no);
        
        
        
        form_no2 = new JLabel(formno);
        form_no2.setFont(new Font("Raleway", Font.BOLD, 15));
        form_no2.setForeground(new Color(39, 55, 77));
        form_no2.setBounds(772,15,60,30);
        add(form_no2);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
           
        
        setLayout(null);
        
        next.setBounds(570,640,100,30);
        add(next);
        
        next.addActionListener(this);
        
        getContentPane().setBackground(new Color(157, 178, 191));
        
        setSize(1000,750);
        setLocation(250,55);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)c1.getSelectedItem(); 
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();
        
        String pan = t1.getText();
        String aadhar = t2.getText();
        
        String scitizen = "";
        if(r1.isSelected()){ 
            scitizen = "Yes";
        }
        else if(r2.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(r3.isSelected()){ 
            eaccount = "Yes";
        }else if(r4.isSelected()){ 
            eaccount = "No";
        }
        
        try{
            if(t2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Connect c = new Connect();
                String q1 = "insert into register2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(q1);
                
                new Reg3(formno).setVisible(true);
                setVisible(false);
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    
               
    }
    
    public static void main(String[] args){
        new Reg2("").setVisible(true);
    }
}
