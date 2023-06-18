package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Bill_details extends JFrame implements ActionListener {

    JTable table;
    JScrollPane scrollPane;
    JButton print;
    String meter_no;

    Bill_details(String meter){

        this.meter_no=meter;

        setSize(700,650);
        setLocation(360,80);

        getContentPane().setBackground(Color.WHITE);

        table=new JTable();

        try {
            Connect_class ob1=new Connect_class();
            String q1="select * from bill where meter_no='"+meter_no+"'";
            ResultSet rs1=ob1.stm.executeQuery(q1);

            table.setModel(DbUtils.resultSetToTableModel(rs1));

        }catch(Exception e){
            e.printStackTrace();
        }

        scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,0,700,650);
        add(scrollPane);

        print=new JButton("Print");
        print.setBackground(Color.YELLOW);
        print.setForeground(Color.BLACK);
        print.addActionListener(this);
        add(print,"South");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            table.print();
        }catch (Exception e2){
            e2.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Bill_details("").setVisible(true);
    }
}
