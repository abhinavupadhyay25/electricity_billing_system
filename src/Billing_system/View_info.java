package Billing_system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class View_info extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JButton cancel;
    String meter_no;

    View_info(String meter){
        super("View information");

        this.meter_no=meter;

        setBounds(280,60,850,650);
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        l1=new JLabel("VIEW CUSTOMER INFORMATION");
        l1.setBounds(250,0,500,40);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);

        l2=new JLabel("Meter Number");
        l2.setBounds(70,80,100,20);
        add(l2);

        l3=new JLabel();
        l3.setBounds(250,80,100,20);
        add(l3);

        l4=new JLabel("Name");
        l4.setBounds(70,140,100,20);
        add(l4);

        l5=new JLabel();
        l5.setBounds(250,140,150,20);
        add(l5);

        l6=new JLabel("Address");
        l6.setBounds(70,200,100,20);
        add(l6);

        l7=new JLabel();
        l7.setBounds(250,200,200,20);
        add(l7);

        l8=new JLabel("City");
        l8.setBounds(70,260,100,20);
        add(l8);

        l9=new JLabel();
        l9.setBounds(250,260,100,20);
        add(l9);

        l10=new JLabel("State");
        l10.setBounds(500,80,100,20);
        add(l10);

        l11=new JLabel();
        l11.setBounds(650,80,100,20);
        add(l11);

        l12=new JLabel("EMail");
        l12.setBounds(500,140,100,20);
        add(l12);

        l13=new JLabel();
        l13.setBounds(650,140,300,20);
        add(l13);

        l14=new JLabel("Phone");
        l14.setBounds(500,200,100,20);
        add(l14);

        l15=new JLabel();
        l15.setBounds(650,200,100,20);
        add(l15);

        try {
            Connect_class ob1=new Connect_class();
            String q1="select * from c_details where meter = '"+meter_no+"'";
            ResultSet rs1=ob1.stm.executeQuery(q1);

            while (rs1.next()){
                l3.setText(rs1.getString("meter"));
                l5.setText(rs1.getString("name"));
                l7.setText(rs1.getString("address"));
                l9.setText(rs1.getString("city"));
                l11.setText(rs1.getString("state"));
                l13.setText(rs1.getString("email"));
                l15.setText(rs1.getString("phone"));
            }
            rs1.close();

        }catch (Exception e1){
            e1.printStackTrace();
        }


        cancel=new JButton("Cancel");
        cancel.setBounds(350,340,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/viewcustomer.jpg"));
        Image i1=img1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i1);

        l16=new JLabel(img2);
        l16.setBounds(20,350,600,300);
        add(l16);

        cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    public static void main(String [] args){
        new View_info("").setVisible(true);
    }
}
