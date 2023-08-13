package BankManagment;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{

    class RoundedCornerLabel extends JLabel {
        private int arcWidth;
        private int arcHeight;

        public RoundedCornerLabel(Icon icon, int arcWidth, int arcHeight) {
            super(icon);
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            Dimension arcs = new Dimension(arcWidth, arcHeight);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;

            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, arcs.width,
                    arcs.height);

            graphics.setClip(roundedRectangle);

            super.paintComponent(g);
        }
    }

    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton login, register, c_care;
    int sliderValue = 0;
    JSlider slider;
    Timer timer;
    int interval = 3000;
    private JLabel textLabel;
    private int xCoordinate = 0;
    private int yCoordinate = 615;

    Home() {
        setTitle("ONLINE BANKING SYSTEM");
        

        ImageIcon bankIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image bankIcon2 = bankIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankIcon3 = new ImageIcon(bankIcon2);
        JLabel bankIcon = new JLabel(bankIcon3);
        bankIcon.setBounds(70, 10, 100, 100);
        add(bankIcon);

        ImageIcon rupeeIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/rupees.jpg"));
        Image rupeeIcon2 = rupeeIcon1.getImage().getScaledInstance(586, 333, Image.SCALE_SMOOTH);
        ImageIcon rupeeIcon3 = new ImageIcon(rupeeIcon2);
        RoundedCornerLabel rupeeIcon = new RoundedCornerLabel(rupeeIcon3, 20, 20);
        rupeeIcon.setBounds(565, 130, 586, 333);
        add(rupeeIcon);

        ImageIcon loginIcon1 = new ImageIcon(ClassLoader.getSystemResource("icons/login_img.png"));
        Image loginIcon2 = loginIcon1.getImage().getScaledInstance(586, 333, Image.SCALE_SMOOTH);
        ImageIcon loginIcon3 = new ImageIcon(loginIcon2);
        RoundedCornerLabel loginIcon = new RoundedCornerLabel(loginIcon3, 20, 20);
        loginIcon.setBounds(565, 130, 586, 333);
        add(loginIcon);
        loginIcon.setVisible(false);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setBounds(500, 500, 300, 50);
        slider.addChangeListener(e -> {
            int value = slider.getValue();
            if (value < 50) {
                rupeeIcon.setVisible(true);
                loginIcon.setVisible(false);
            } else {
                rupeeIcon.setVisible(false);
                loginIcon.setVisible(true);
            }
        });

        timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sliderValue += 50;
                if (sliderValue > 100) {
                    sliderValue = 0;
                }
                slider.setValue(sliderValue);
            }
        });
        timer.start();
    

        l1 = new JLabel("WELCOME TO ONLINE BANKING SYSTEM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 1000, 40);
        l1.setForeground(new Color(39, 55, 77 ));
        add(l1);

        ImageIcon person1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image person2 = person1.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        ImageIcon person3 = new ImageIcon(person2);
        JLabel person = new JLabel(person3);
        person.setBounds(240, 170, 64, 64);
        add(person);

        login = new JButton("<< LOG IN >>");
        login.setBackground(new Color(39, 55, 77  ));
        login.setForeground(Color.WHITE);

        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBounds(200, 250, 160, 30);
        add(login);

        ImageIcon new_registration1 = new ImageIcon(ClassLoader.getSystemResource("icons/form.png"));
        Image new_registration2 = new_registration1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon new_registration3 = new ImageIcon(new_registration2);
        JLabel new_registration = new JLabel(new_registration3);
        new_registration.setBounds(95, 305, 120, 120);
        add(new_registration);

        register = new JButton("<< New User Registration >>");
        register.setBackground(new Color(39, 55, 77  ));
        register.setForeground(Color.WHITE);

        register.setFont(new Font("Arial", Font.BOLD, 14));
        register.setBounds(30, 425, 250, 30);
        add(register);

        ImageIcon customer_care1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer-service.png"));
        Image customer_care2 = customer_care1.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT);
        ImageIcon customer_care3 = new ImageIcon(customer_care2);
        JLabel customer_care = new JLabel(customer_care3);
        customer_care.setBounds(361, 305, 128, 128);
        add(customer_care);

        c_care = new JButton("<< Customer Care >>");
        c_care.setBackground(new Color(39, 55, 77  ));
        c_care.setForeground(Color.WHITE);

        c_care.setFont(new Font("Arial", Font.BOLD, 14));
        c_care.setBounds(300, 425, 250, 30);
        add(c_care);


        textLabel = new JLabel("                                                                                                                                                                                                                      Call or whatsup us on 7440272504 and get a wide range of services through Contact Centre  | We never asks for your Card/PIN/OTP/CVV details on phone, message or email. Please do not click on links received on your email or mobile asking your Bank/Card details");
        textLabel.setFont(new Font("Arial", Font.BOLD, 20));
        textLabel.setBackground(Color.WHITE); 
        textLabel.setOpaque(true);
        textLabel.setForeground(Color.RED);
        textLabel.setBounds(xCoordinate, yCoordinate, 5100, 30);
        add(textLabel);


        Timer timer2 = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xCoordinate -= 2; 
                int labelWidth = 5000;
                
                if (xCoordinate + labelWidth < 1100) {
                    xCoordinate = 0;
                }

                textLabel.setLocation(xCoordinate, yCoordinate);
            }
        });
        timer2.start();


        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(null);
        boxPanel.setBounds(20, 500, 250, 100); 
        boxPanel.setBackground(Color.LIGHT_GRAY);

        JLabel boxLabel = new JLabel("ALWAYS");
        boxLabel.setBounds(0, 0, 250, 30);
        boxLabel.setOpaque(true);
        boxLabel.setBackground(Color.GREEN);
        boxLabel.setForeground(Color.WHITE);
        boxLabel.setFont(new Font("Arial", Font.BOLD, 20));
        boxLabel.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel.setVerticalAlignment(SwingConstants.CENTER);
    
        boxPanel.add(boxLabel);

        JLabel boxLabel11 = new JLabel(" change your passwords periodically ");
        boxLabel11.setBounds(0, 42, 250, 30);
        boxLabel11.setForeground(Color.BLACK);
        boxLabel11.setFont(new Font("Arial", Font.BOLD, 13));
        boxLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel11.setVerticalAlignment(SwingConstants.CENTER);

        boxPanel.add(boxLabel11);
        add(boxPanel);



        JPanel boxPanel2 = new JPanel();
        boxPanel2.setLayout(null);
        boxPanel2.setBounds(319, 500, 250, 100); 
        boxPanel2.setBackground(Color.LIGHT_GRAY);

        JLabel boxLabel2 = new JLabel(" ALWAYS ");
        boxLabel2.setBounds(0, 0, 250, 30);
        boxLabel2.setOpaque(true);
        boxLabel2.setBackground(Color.GREEN);
        boxLabel2.setForeground(Color.WHITE);
        boxLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        boxLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel2.setVerticalAlignment(SwingConstants.CENTER);
    
        boxPanel2.add(boxLabel2);

        JLabel boxLabel22 = new JLabel(" keep your computer free of malware ");
        boxLabel22.setBounds(0, 42, 250, 30);
        boxLabel22.setForeground(Color.BLACK);
        boxLabel22.setFont(new Font("Arial", Font.BOLD, 13));
        boxLabel22.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel22.setVerticalAlignment(SwingConstants.CENTER);

        boxPanel2.add(boxLabel22);
        add(boxPanel2);


        JPanel boxPanel3 = new JPanel();
        boxPanel3.setLayout(null);
        boxPanel3.setBounds(618, 500, 250, 100); 
        boxPanel3.setBackground(Color.LIGHT_GRAY);

        JLabel boxLabel3 = new JLabel(" NEVER ");
        boxLabel3.setBounds(0, 0, 250, 30);
        boxLabel3.setOpaque(true);
        boxLabel3.setBackground(Color.RED);
        boxLabel3.setForeground(Color.WHITE);
        boxLabel3.setFont(new Font("Arial", Font.BOLD, 20));
        boxLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel3.setVerticalAlignment(SwingConstants.CENTER);
    
        boxPanel3.add(boxLabel3);

        JLabel boxLabel33 = new JLabel(" respond to any communication"); 
        boxLabel33.setBounds(0, 35, 250, 30);
        boxLabel33.setForeground(Color.BLACK);
        boxLabel33.setFont(new Font("Arial", Font.BOLD, 13));
        boxLabel33.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel33.setVerticalAlignment(SwingConstants.CENTER);
        boxPanel3.add(boxLabel33);

        JLabel boxLabel333 = new JLabel(" seeking your passwords "); 
        boxLabel333.setBounds(0, 50, 250, 30);
        boxLabel333.setForeground(Color.BLACK);
        boxLabel333.setFont(new Font("Arial", Font.BOLD, 13));
        boxLabel333.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel333.setVerticalAlignment(SwingConstants.CENTER);
        boxPanel3.add(boxLabel333);

        add(boxPanel3);



        JPanel boxPanel4 = new JPanel();
        boxPanel4.setLayout(null);
        boxPanel4.setBounds(917, 500, 250, 100); 
        boxPanel4.setBackground(Color.LIGHT_GRAY);

        JLabel boxLabel4 = new JLabel(" NEVER ");
        boxLabel4.setBounds(0, 0, 250, 30);
        boxLabel4.setOpaque(true);
        boxLabel4.setBackground(Color.RED);
        boxLabel4.setForeground(Color.WHITE);
        boxLabel4.setFont(new Font("Arial", Font.BOLD, 20));
        boxLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel4.setVerticalAlignment(SwingConstants.CENTER);
    
        boxPanel4.add(boxLabel4);

        JLabel boxLabel44 = new JLabel(" reveal your passwords or"); 
        boxLabel44.setBounds(0, 35, 250, 30);
        boxLabel44.setForeground(Color.BLACK);
        boxLabel44.setFont(new Font("Arial", Font.BOLD, 13));
        boxLabel44.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel44.setVerticalAlignment(SwingConstants.CENTER);
        boxPanel4.add(boxLabel44);

        JLabel boxLabel444 = new JLabel(" card details to anyone "); 
        boxLabel444.setBounds(0, 50, 250, 30);
        boxLabel444.setForeground(Color.BLACK);
        boxLabel444.setFont(new Font("Arial", Font.BOLD, 13));
        boxLabel444.setHorizontalAlignment(SwingConstants.CENTER);
        boxLabel444.setVerticalAlignment(SwingConstants.CENTER);
        boxPanel4.add(boxLabel444);
        add(boxPanel4);


        setLayout(null);

        login.addActionListener(this);
        register.addActionListener(this);
        c_care.addActionListener(this);

        getContentPane().setBackground(new Color(157, 178, 191 ));

        setSize(1200, 700);
        setLocation(190, 65);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
    try{
        if(ae.getSource()==login){
            setVisible(false);
            new Login().setVisible(true);

        }
        else if(ae.getSource()==register){
            setVisible(false);
            new NewReg().setVisible(true);
        }
        else if(ae.getSource()==c_care){
            new CustomerCare().setVisible(true);
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    public static void main(String[] args) {
        new Home().setVisible(true);
    }

}