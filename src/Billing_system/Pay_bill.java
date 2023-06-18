package Billing_system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Pay_bill extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    Choice ch1;
    JButton b1,b2;
    String meter_no;

    Pay_bill(String meter){

        this.meter_no=meter;

        setSize(900,600);
        setLocation(250,100);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1=new JLabel("PAY ELECTRICITY BILL");
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        l1.setBounds(120,5,400,30);
        add(l1);

        l2=new JLabel("Meter Number");
        l2.setBounds(35,80,200,20);
        add(l2);

        l3=new JLabel();
        l3.setBounds(300,80,200,20);
        add(l3);

        l4=new JLabel("Name");
        l4.setBounds(35,140,200,20);
        add(l4);

        l5=new JLabel();
        l5.setBounds(300,140,200,20);
        add(l5);

        try {
            Connect_class ob1=new Connect_class();
            String q1="select * from c_details where meter='"+meter_no+"'";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            while (rs1.next()){
                l3.setText(rs1.getString("meter"));
                l5.setText(rs1.getString("name"));
            }
            rs1.close();

        }catch (Exception e1){
            e1.printStackTrace();
        }

        l6=new JLabel("Month");
        l6.setBounds(35,220,200,20);
        add(l6);

        ch1=new Choice();
        ch1.setBounds(300,220,200,20);
        ch1.add("January");
        ch1.add("February");
        ch1.add("March");
        ch1.add("April");
        ch1.add("May");
        ch1.add("June");
        ch1.add("July");
        ch1.add("August");
        ch1.add("September");
        ch1.add("october");
        ch1.add("November");
        ch1.add("December");
        add(ch1);

        l7=new JLabel("Units");
        l7.setBounds(35,300,200,20);
        add(l7);

        l8=new JLabel();
        l8.setBounds(300,300,200,20);
        add(l8);

        l9=new JLabel("Total Bill");
        l9.setBounds(35,380,200,20);
        add(l9);

        l10=new JLabel();
        l10.setBounds(300,380,200,20);
        add(l10);

        l11=new JLabel("Status");
        l11.setBounds(35,440,200,20);
        add(l11);

        l12=new JLabel();
        l12.setBounds(300,440,200,20);
        l12.setForeground(Color.RED);
        add(l12);

        ch1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Connect_class ob2=new Connect_class();
                    String q2="select * from bill where meter_no='"+meter_no+"' AND month='"+ch1.getSelectedItem()+"'";
                    ResultSet rs2=ob2.stm.executeQuery(q2);
                    while (rs2.next()){
                        l8.setText(rs2.getString("units"));
                        l10.setText(rs2.getString("total_bill"));
                        l12.setText(rs2.getString("status"));
                    }
                    rs2.close();

                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/bill.png"));
        Image i1=img1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i1);

        l13=new JLabel(img2);
        l13.setBounds(400,120,600,300);
        add(l13);

        b1=new JButton("Pay");
        b1.setBounds(100,500,100,25);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBounds(230,500,100,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b2){
            this.setVisible(false);
        }
        if (e.getSource()==b1){
            try {
                Connect_class ob3=new Connect_class();
                String q3="update bill set status='Paid' where meter_no='"+meter_no+"' AND month='"+ch1.getSelectedItem()+"'";
                int a=ob3.stm.executeUpdate(q3);
                if (a==1){
                    //JOptionPane.showMessageDialog(null,"Successful,Bill Payment !!");
                    this.setVisible(false);
                    new Paytm(meter_no).setVisible(true);
                }

            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Pay_bill("").setVisible(true);
    }
}
