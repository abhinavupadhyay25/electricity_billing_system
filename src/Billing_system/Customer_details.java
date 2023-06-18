package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Customer_details extends JFrame implements ActionListener{

    JTable table;
    JScrollPane scrollPane;
    JButton button;

    Customer_details(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(100,70);

        table=new JTable();

        try {
            Connect_class ob1=new Connect_class();
            String q1="select * from c_details";
            ResultSet rs1=ob1.stm.executeQuery(q1);

            table.setModel(DbUtils.resultSetToTableModel(rs1));
        }catch (Exception e){
            e.printStackTrace();
        }

        scrollPane=new JScrollPane(table);
        add(scrollPane);

        button=new JButton("Print");
        button.setBackground(Color.YELLOW);
        button.setForeground(Color.BLACK);
        button.addActionListener(this);
        add(button,"South");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            table.print();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Customer_details().setVisible(true);
    }
}
