package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Calculate_bill extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    Choice ch1,ch2;
    JButton b1,b2;
    JPanel p;
    JTextField t;
    int totalBill;

    Calculate_bill(){
        setSize(700,500);
        setLocation(380,150);

        p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        l1=new JLabel("CALCULATE ELECTRICITY BILL");
        l1.setBounds(85,10,500,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(l1);

        l2=new JLabel("Meter Number");
        l2.setBounds(100,80,100,20);
        p.add(l2);

        ch1=new Choice();
        ch1.setBounds(240,80,200,20);
        p.add(ch1);

        try {
            Connect_class obj= new Connect_class();
            String q="select meter from c_details";
            ResultSet rs=obj.stm.executeQuery(q);
            while (rs.next()){
                ch1.add(rs.getString("meter"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        l3=new JLabel("Name");
        l3.setBounds(100,120,100,20);
        p.add(l3);

        l4=new JLabel();
        l4.setBounds(240,120,200,20);
        p.add(l4);

        l5=new JLabel("Address");
        l5.setBounds(100,160,100,20);
        p.add(l5);

        l6=new JLabel();
        l6.setBounds(240,160,200,20);
        p.add(l6);

        /*ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connect_class obj1=new Connect_class();
                    String meter=ch1.getSelectedItem();
                    String q1="select * from c_details where meter='"+meter+"'";
                    ResultSet rs1=obj1.stm.executeQuery(q1);
                    while (rs1.next()){
                        l4.setText(rs1.getString("name"));
                        l6.setText(rs1.getString("address"));
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });*/

        ch1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connect_class obj1=new Connect_class();
                    String meter=ch1.getSelectedItem();
                    String q1="select * from c_details where meter='"+meter+"'";
                    ResultSet rs1=obj1.stm.executeQuery(q1);
                    while (rs1.next()){
                        l4.setText(rs1.getString("name"));
                        l6.setText(rs1.getString("address"));
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        l7=new JLabel("Units Consumed");
        l7.setBounds(100,200,100,20);
        p.add(l7);

        t=new JTextField();
        t.setBounds(240,200,200,20);
        p.add(t);

        l8=new JLabel("Month");
        l8.setBounds(100,240,100,20);
        p.add(l8);

        ch2=new Choice();
        ch2.setBounds(240,240,200,20);
        ch2.add("January");
        ch2.add("February");
        ch2.add("March");
        ch2.add("April");
        ch2.add("May");
        ch2.add("June");
        ch2.add("July");
        ch2.add("August");
        ch2.add("September");
        ch2.add("october");
        ch2.add("November");
        ch2.add("December");
        p.add(ch2);

        b1=new JButton("Submit");
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

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/hicon2.jpg"));
        Image i1=img.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l9=new JLabel(img1);
        add(l9,"West");

        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String meter=ch1.getSelectedItem();
            String units=t.getText();
            String month=ch2.getSelectedItem();

            totalBill=0;
            int c_unit=Integer.parseInt(units);

            try{
                Connect_class obj2=new Connect_class();
                String q1="select * from tax";
                ResultSet rs2=obj2.stm.executeQuery(q1);
                while (rs2.next()){
                    //totalBill = totalBill + c_unit * Integer.parseInt(rs2.getString("cost/unit"));
                    totalBill += c_unit * Integer.parseInt(rs2.getString("cost_per_unit"));
                    totalBill += Integer.parseInt(rs2.getString("meter_rent"));
                    totalBill += Integer.parseInt(rs2.getString("service_charge"));
                    totalBill += Integer.parseInt(rs2.getString("service_tax"));
                    totalBill += Integer.parseInt(rs2.getString("s_b_cess"));
                    totalBill += Integer.parseInt(rs2.getString("fixed_tax"));
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }

            try{
                Connect_class obj3=new Connect_class();
                String q3="insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalBill+"','Not Paid')";
                int a=obj3.stm.executeUpdate(q3);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully !!");
                    this.setVisible(false);

                }
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }

        if (e.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Calculate_bill().setVisible(true);
    }
}
