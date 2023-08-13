package BankManagment;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class UserHome extends JFrame implements ActionListener{

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

    JLabel txt1, txt2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton balance, mini_state, atm, c_care;
    int sliderValue = 0;
    JSlider slider;
    Timer timer;
    int interval = 3000;
    private JLabel textLabel;
    private int xCoordinate = 0;
    private int yCoordinate = 615;
    String pin;

    UserHome(String pin) {
        this.pin=pin;
        setTitle("User Home");

        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/bg.jpg"));
        Image bg2 = bg1.getImage().getScaledInstance(1200, 342, Image.SCALE_AREA_AVERAGING);
        ImageIcon bg3 = new ImageIcon(bg2);
        JLabel bg = new JLabel(bg3);
        bg.setBounds(0, 0, 1200, 130);
        add(bg);
        // setSize(1200, 700);
        // setLocation(190, 65);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/provider.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(120, 20, 100, 100);
        bg.add(l11);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
        Image i5 = i4.getImage().getScaledInstance(586, 333, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        RoundedCornerLabel l12 = new RoundedCornerLabel(i6, 20, 20);
        l12.setBounds(30, 145, 586, 333);
        add(l12);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/2.jpg"));
        Image i8 = i7.getImage().getScaledInstance(586, 333, Image.SCALE_SMOOTH);
        ImageIcon i9 = new ImageIcon(i8);
        RoundedCornerLabel l13 = new RoundedCornerLabel(i9, 20, 20);
        l13.setBounds(30, 145, 586, 333);
        add(l13);
        l13.setVisible(false);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/3.jpg"));
        Image i11 = i10.getImage().getScaledInstance(586, 333, Image.SCALE_SMOOTH);
        ImageIcon i12 = new ImageIcon(i11);
        RoundedCornerLabel l14 = new RoundedCornerLabel(i12, 20, 20);
        l14.setBounds(30, 145, 586, 333);
        add(l14);
        l14.setVisible(false);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/4.jpg"));
        Image i14 = i13.getImage().getScaledInstance(586, 333, Image.SCALE_SMOOTH);
        ImageIcon i15 = new ImageIcon(i14);
        RoundedCornerLabel l15 = new RoundedCornerLabel(i15, 20, 20);
        l15.setBounds(30, 145, 586, 333);
        add(l15);
        l15.setVisible(false);

        // Create the slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.addChangeListener(e -> {
            int value = slider.getValue();
            if (value==1) {
                l15.setVisible(false);
                l12.setVisible(true);
            } else if(value==2){
                l12.setVisible(false);
                l13.setVisible(true);
            }
            else if(value==3){
                l13.setVisible(false);
                l14.setVisible(true);
            }
            else{
                l14.setVisible(false);
                l15.setVisible(true);
            }
        });

        timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sliderValue += 1;
                if (sliderValue > 3) {
                    sliderValue = 0;
                }
                slider.setValue(sliderValue);
            }
        });
        timer.start();
    

        txt1 = new JLabel("WELCOME TO PERSONAL BANKING");
        txt1.setFont(new Font("Osward", Font.BOLD, 38));
        txt1.setBounds(260, 50, 1000, 40);
        txt1.setForeground(Color.WHITE); 
        bg.add(txt1);

        txt2 = new JLabel("Please Select a Service...");
        txt2.setFont(new Font("Osward", Font.BOLD, 25));
        txt2.setBounds(722, 150, 1000, 40);
        txt2.setForeground(Color.BLACK);
        add(txt2);

        

        balance = new JButton(" >>>  Balance Enquiry");
        balance.setContentAreaFilled(false);
        balance.setBorderPainted(false); 
        balance.setOpaque(false);
        balance.setForeground(new Color(39, 55, 77 ));
        balance.setFont(new Font("Arial", Font.BOLD, 25));
        balance.setBounds(630, 230, 300, 30);
        add(balance);

        mini_state = new JButton(" >>>  Mini Statement");
        mini_state.setContentAreaFilled(false);
        mini_state.setBorderPainted(false); 
        mini_state.setOpaque(false);
        mini_state.setForeground(new Color(39, 55, 77 ));
        mini_state.setFont(new Font("Arial", Font.BOLD, 25));
        mini_state.setBounds(630, 280, 280, 30);
        add(mini_state);

        atm = new JButton(" >>>  Go To ATM");
        atm.setContentAreaFilled(false);
        atm.setBorderPainted(false); 
        atm.setOpaque(false);
        atm.setForeground(new Color(39, 55, 77 ));
        atm.setFont(new Font("Arial", Font.BOLD, 25));
        atm.setBounds(610, 330, 280, 30);
        add(atm);

        c_care = new JButton(" >>>  Customer Care");
        c_care.setContentAreaFilled(false);
        c_care.setBorderPainted(false); 
        c_care.setOpaque(false);
        c_care.setForeground(new Color(39, 55, 77 ));
        c_care.setFont(new Font("Arial", Font.BOLD, 25));
        c_care.setBounds(630, 380, 280, 30);
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

        balance.addActionListener(this);
        mini_state.addActionListener(this);
        atm.addActionListener(this);
        c_care.addActionListener(this);

        getContentPane().setBackground(new Color(157, 178, 191 ));

        setSize(1200, 700);
        setLocation(190, 65);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
    try{
        if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);

        }
        else if(ae.getSource()==mini_state){
            new MiniStatement(pin).setVisible(true);
        }
        else if(ae.getSource()==atm){
            setVisible(false);
            new AtmScreen(pin).setVisible(true);
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
        new UserHome("").setVisible(true);
    }

}