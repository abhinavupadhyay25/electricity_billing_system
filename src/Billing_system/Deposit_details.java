package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Deposit_details extends JFrame implements ActionListener{

    JLabel l1,l2;
    Choice ch1,ch2;
    JButton b1,b2;
    JTable table;

    Deposit_details(){
        super("Deposit Details");
        setSize(700,700);
        setLocation(330,50);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1=new JLabel("Search By Meter Number");
        l1.setBounds(20,20,150,20);
        add(l1);

        ch1=new Choice();
        ch1.setBounds(180,20,150,20);
        add(ch1);

        try{
            Connect_class ob1=new Connect_class();
            String q1="select meter from c_details";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            while (rs1.next()){
                ch1.add(rs1.getString("meter"));
            }
            rs1.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        l2=new JLabel("Search By Month");
        l2.setBounds(400,20,100,20);
        add(l2);

        ch2=new Choice();
        ch2.setBounds(520,20,150,20);
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
        add(ch2);

        table=new JTable();
        try {
            Connect_class ob2=new Connect_class();
            String q2="select * from bill";
            ResultSet rs2= ob2.stm.executeQuery(q2);

            table.setModel(DbUtils.resultSetToTableModel(rs2));
        }catch (Exception e1){
            e1.printStackTrace();
        }

        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,100,700,600);
        add(scrollPane);

        b1=new JButton("Search");
        b1.setBounds(20,70,80,20);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Print");
        b2.setBounds(120,70,80,20);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                Connect_class ob3=new Connect_class();
                String query="select * from bill where meter_no='"+ch1.getSelectedItem()+"' and month='"+ch2.getSelectedItem()+"'";
                ResultSet rs3=ob3.stm.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(rs3));
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            try{
                table.print();
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Deposit_details().setVisible(true);
    }
}
