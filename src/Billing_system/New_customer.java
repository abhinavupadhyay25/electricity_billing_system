package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class New_customer extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JPanel p;

    New_customer(){
        setSize(700,500);
        setLocation(350,130);

        p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        l1=new JLabel("NEW CUSTOMER");
        l1.setBounds(180,10,300,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(l1);

        l2=new JLabel("Customer Name");
        l2.setBounds(100,80,100,20);
        p.add(l2);

        t1=new JTextField();
        t1.setBounds(240,80,200,20);
        p.add(t1);

        l3=new JLabel("Meter Number");
        l3.setBounds(100,120,100,20);
        p.add(l3);

        Random ran=new Random();
        long num=ran.nextLong() % 1000000;

        l4=new JLabel();
        l4.setBounds(240,120,100,20);
        p.add(l4);

        l4.setText("" + Math.abs(num));

        l5=new JLabel("Address");
        l5.setBounds(100,160,100,20);
        p.add(l5);

        t2=new JTextField();
        t2.setBounds(240,160,200,20);
        p.add(t2);

        l6=new JLabel("City");
        l6.setBounds(100,200,100,20);
        p.add(l6);

        t3=new JTextField();
        t3.setBounds(240,200,200,20);
        p.add(t3);

        l7=new JLabel("State");
        l7.setBounds(100,240,100,20);
        p.add(l7);

        t4=new JTextField();
        t4.setBounds(240,240,200,20);
        p.add(t4);

        l8=new JLabel("EMail");
        l8.setBounds(100,280,100,20);
        p.add(l8);

        t5=new JTextField();
        t5.setBounds(240,280,200,20);
        p.add(t5);

        l9=new JLabel("Phone Number");
        l9.setBounds(100,320,100,20);
        p.add(l9);

        t6=new JTextField();
        t6.setBounds(240,320,200,20);
        p.add(t6);

        b1=new JButton("Next");
        b1.setBounds(120,390,100,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        p.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(250,390,100,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        p.add(b2);

        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/hicon1.jpg"));
        Image i1=img.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l10=new JLabel(img1);
        add(l10,"West");

        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b2){
            this.setVisible(false);
        }

        if (e.getSource()==b1){
            String meter= l4.getText();
            String name=t1.getText();
            String address=t2.getText();
            String city=t3.getText();
            String state=t4.getText();
            String email=t5.getText();
            String phone=t6.getText();

            try {
                Connect_class obj=new Connect_class();
                String q1="insert into c_details values('"+meter+"','"+name+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
                String q2="insert into log_in values('"+meter+"','"+name+"','','','')";
                int a=obj.stm.executeUpdate(q1);
                int b=obj.stm.executeUpdate(q2);
                if (a==1 && b==1){
                    JOptionPane.showMessageDialog(null,"New Customer Added Successfully !!");
                    this.setVisible(false);
                    new Meter_Info(meter).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Fill all details carefully !!");
                    this.setVisible(false);
                    new Home_page("","").setVisible(true);
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new New_customer().setVisible(true);
    }
}
