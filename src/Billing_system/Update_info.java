package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Update_info extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    String meter_no;

    Update_info(String meter){
        super("Update Information");
        this.meter_no=meter;

        setSize(1050,450);
        setLocation(210,150);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l1=new JLabel("UPDATE CUSTOMER INFORMATION");
        l1.setBounds(110,0,400,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);

        l2=new JLabel("Meter Number");
        l2.setBounds(30,70,100,20);
        add(l2);

        l3=new JLabel();
        l3.setBounds(230,70,200,20);
        add(l3);

        l4=new JLabel("Name");
        l4.setBounds(30,110,100,20);
        add(l4);

        l5=new JLabel();
        l5.setBounds(230,110,200,20);
        add(l5);

        l6=new JLabel("Address");
        l6.setBounds(30,150,100,20);
        add(l6);

        t1=new JTextField();
        t1.setBounds(230,150,200,20);
        add(t1);

        l7=new JLabel("City");
        l7.setBounds(30,190,100,20);
        add(l7);

        t2=new JTextField();
        t2.setBounds(230,190,200,20);
        add(t2);

        l8=new JLabel("State");
        l8.setBounds(30,230,100,20);
        add(l8);

        t3=new JTextField();
        t3.setBounds(230,230,200,20);
        add(t3);

        l9=new JLabel("EMail");
        l9.setBounds(30,270,100,20);
        add(l9);

        t4=new JTextField();
        t4.setBounds(230,270,200,20);
        add(t4);

        l10=new JLabel("Phone");
        l10.setBounds(30,310,100,20);
        add(l10);

        t5=new JTextField();
        t5.setBounds(230,310,200,20);
        add(t5);

        try {
            Connect_class ob1=new Connect_class();
            String q1="select * from c_details where meter='"+meter_no+"'";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            while (rs1.next()){
                l3.setText(rs1.getString("meter"));
                l5.setText(rs1.getString("name"));
                t1.setText(rs1.getString("address"));
                t2.setText(rs1.getString("city"));
                t3.setText(rs1.getString("state"));
                t4.setText(rs1.getString("email"));
                t5.setText(rs1.getString("phone"));
            }
            rs1.close();

        }catch (Exception e1){
            e1.printStackTrace();
        }

        b1=new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70,360,100,25);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(230,360,100,25);
        add(b2);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/update.jpg"));
        Image i1=img1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i1);

        l11=new JLabel(img2);
        l11.setBounds(550,50,400,300);
        add(l11);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b2){
            this.setVisible(false);
        }
        if (e.getSource()==b1){

            String address=t1.getText();
            String city=t2.getText();
            String state=t3.getText();
            String email=t4.getText();
            String phone=t5.getText();

            try {
                Connect_class ob2=new Connect_class();
                String q2="update c_details set address='"+address+"', city='"+city+"',state='"+state+"', email='"+email+"', phone='"+phone+"' where meter='"+meter_no+"'";
                int a=ob2.stm.executeUpdate(q2);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully !!");
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Fill all details carefully !!");
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Update_info("").setVisible(true);
    }
}
