package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4;
    JTextField t;
    JPasswordField p;
    Choice ch;
    JButton b1,b2,b3;

    Login(){
        super("Login Page");

        setSize(600,300);
        setLocation(400,200);

         getContentPane().setBackground(Color.white);

         setLayout(null);

         l1=new JLabel("Username");
         l1.setBounds(300,20,100,20);
         add(l1);

         l2=new JLabel("Password");
         l2.setBounds(300,60,100,20);
         add(l2);

         l3=new JLabel("Login in as");
         l3.setBounds(300,100,100,20);
         add(l3);

         t=new JTextField();
         t.setBounds(400,20,150,20);
         add(t);

         p=new JPasswordField();
         p.setBounds(400,60,150,20);
         add(p);

         ch=new Choice();
         ch.setBounds(400,100,150,20);
         ch.add("Admin");
         ch.add("Customer");
         add(ch);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/login.png"));
        Image i1=img.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);

         b1=new JButton("Login",new ImageIcon(i1));
         b1.setBounds(330,160,100,20);
         add(b1);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/cancel.jpg"));
        Image i2=img1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);

         b2=new JButton("Cancel",new ImageIcon(i2));
         b2.setBounds(450,160,100,20);
         add(b2);

        ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/signup.png"));
        Image i3=img2.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);

         b3=new JButton("Sign Up",new ImageIcon(i3));
         b3.setBounds(380,200,100,20);
         add(b3);

         ImageIcon img3=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/second.jpg"));
         Image i4=img3.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
         ImageIcon img4=new ImageIcon(i4);

         l4=new JLabel(img4);
         l4.setBounds(0,0,250,250);
         add(l4);

         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String username=t.getText();
            String password=p.getText();
            String account=ch.getSelectedItem();
            try{
                Connect_class obj=new Connect_class();
                String q="select * from log_in where username='"+username+"' and password='"+password+"' and acc_type='"+account+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if (rs.next()){
                    String meter=rs.getString("meter_no");
                    this.setVisible(false);
                    new Home_page(account,meter).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid login!!");
                    //this.setVisible(false);
                    //new Login().setVisible(true);
                    t.setText("");
                    p.setText("");
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            System.exit(0);
        }
        if (e.getSource()==b3){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
