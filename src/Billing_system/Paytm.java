package Billing_system;

import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    String meter_no;
    JEditorPane j;
    JScrollPane scrollPane;
    JButton back;

    Paytm(String meter){

        this.meter_no=meter;

        j=new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/online-payments");
        }catch(Exception e1){
            j.setContentType("text/html");
            j.setText("<html>Could Not Load</html>");
        }

        scrollPane=new JScrollPane(j);
        add(scrollPane);

        setSize(800,600);
        setLocation(330,100);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        j.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Successful,Bill Payment !!");
        this.setVisible(false);
        new Pay_bill(meter_no).setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm("").setVisible(true);
    }
}
