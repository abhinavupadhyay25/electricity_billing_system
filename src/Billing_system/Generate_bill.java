package Billing_system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Generate_bill extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextArea area;
    JScrollPane pane;
    Choice ch1;
    JButton b1;
    JPanel p;
    String meter_no;

    Generate_bill(String meter){

        this.meter_no=meter;

        setSize(500,770);
        setLocation(430,10);

        setLayout(new BorderLayout());

        p=new JPanel();

        l1=new JLabel("Generate Bill");

        l2=new JLabel();

        ch1=new Choice();
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

        area=new JTextArea(50,15);
        area.setText("\n\n\t--------Click on the--------\n\t Generate Bill Button to get\n\t the bill of the selected month");
        area.setFont(new Font("Arial",Font.PLAIN,18));

        pane=new JScrollPane(area);

        b1=new JButton("Generate Bill");

        p.add(l1);
        p.add(l2);
        p.add(ch1);
        add(p,"North");

        add(pane,"Center");

        add(b1,"South");
        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String month=ch1.getSelectedItem();
        try {
            Connect_class ob1=new Connect_class();
            area.setText("\tReliance Power Limited\nELECTRICITY BILL GENERATED FOR THE MONTH\n\tOF "+month+",2023\n\n\n");
            String q1="select * from c_details where meter='"+meter_no+"'";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            if (rs1.next()){
                l2.setText(rs1.getString("meter"));
                area.append("\n    Customer Name : "+rs1.getString("name")+"");
                area.append("\n    Meter Number : "+rs1.getString("meter")+"");
                area.append("\n    Address : "+rs1.getString("address")+"");
                area.append("\n    City : "+rs1.getString("city")+"");
                area.append("\n    State : "+rs1.getString("state")+"");
                area.append("\n    EMail : "+rs1.getString("email")+"");
                area.append("\n    Phone : "+rs1.getString("phone")+"");
                area.append("\n-----------------------------------------------------------------");
                area.append("\n");
            }

            String q2="select * from meter_info where meter_no='"+meter_no+"'";
            rs1=ob1.stm.executeQuery(q2);
            if (rs1.next()){
                area.append("\n    Meter Location : "+rs1.getString("location")+"");
                area.append("\n    Meter Type : "+rs1.getString("type")+"");
                area.append("\n    Phase Code : "+rs1.getString("phase")+"");
                area.append("\n    Bill Type : "+rs1.getString("bill_type")+"");
                area.append("\n    Days : "+rs1.getString("days")+"");
                area.append("\n-----------------------------------------------------------------");
                area.append("\n");
            }

            String q3="select * from tax";
            rs1=ob1.stm.executeQuery(q3);
            if (rs1.next()){
                area.append("\n");
                area.append("\n    Cost per Unit : "+rs1.getString("cost_per_unit")+"");
                area.append("\n    Meter Rent : "+rs1.getString("meter_rent")+"");
                area.append("\n    Service Charge : "+rs1.getString("service_charge")+"");
                area.append("\n    Service Tax : "+rs1.getString("service_tax")+"");
                area.append("\n    Swacch Bharat Cess : "+rs1.getString("s_b_cess")+"");
                area.append("\n    Fixed Tax : "+rs1.getString("fixed_tax")+"");
                area.append("\n");
            }

            String q4="select * from bill where meter_no='"+meter_no+"'";
            rs1=ob1.stm.executeQuery(q4);
            if (rs1.next()){
                area.append("\n");
                area.append("\n    Current Month : "+rs1.getString("month")+"");
                area.append("\n    Units Consumed : "+rs1.getString("units")+"");
                area.append("\n    Total Charges : "+rs1.getString("total_bill")+"");
                area.append("\n-----------------------------------------------------------------");
                area.append("\n    Total payable : "+rs1.getString("total_bill")+"");
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Generate_bill("").setVisible(true);
    }
}
