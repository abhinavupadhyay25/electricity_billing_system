package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Meter_Info extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    Choice ch1,ch2,ch3,ch4;
    JButton b1;
    JPanel p;
    String meter_no;

    Meter_Info(String meter){

        this.meter_no=meter;

        setSize(700,500);
        setLocation(360,130);

        p=new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);

        l1=new JLabel("METER INFORMATION");
        l1.setBounds(180,10,350,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(l1);

        l2=new JLabel("Meter Number");
        l2.setBounds(100,80,100,20);
        p.add(l2);

        l3=new JLabel(meter_no);
        l3.setBounds(240,80,200,20);
        p.add(l3);

        l3=new JLabel("Meter Location");
        l3.setBounds(100,120,100,20);
        p.add(l3);

        ch1=new Choice();
        ch1.setBounds(240,120,200,20);
        ch1.add("Outside");
        ch1.add("Inside");
        p.add(ch1);

        l4=new JLabel("Meter Type");
        l4.setBounds(100,160,100,20);
        p.add(l4);

        ch2=new Choice();
        ch2.setBounds(240,160,200,20);
        ch2.add("Solar Meter");
        ch2.add("Electric Meter");
        ch2.add("Smart Meter");
        p.add(ch2);

        l5=new JLabel("Phase Code");
        l5.setBounds(100,200,100,20);
        p.add(l5);

        ch3=new Choice();
        ch3.setBounds(240,200,200,20);
        ch3.add("011");
        ch3.add("022");
        ch3.add("033");
        ch3.add("044");
        ch3.add("055");
        ch3.add("066");
        ch3.add("077");
        ch3.add("088");
        ch3.add("099");
        p.add(ch3);

        l6=new JLabel("Bill Type");
        l6.setBounds(100,240,100,20);
        p.add(l6);

        ch4=new Choice();
        ch4.setBounds(240,240,200,20);
        ch4.add("Normal");
        ch4.add("Industrial");
        p.add(ch4);

        l7=new JLabel("Days");
        l7.setBounds(100,280,100,20);
        p.add(l7);

        l8=new JLabel("30 Days");
        l8.setBounds(240,280,200,20);
        p.add(l8);

        l9=new JLabel("Note");
        l9.setBounds(100,320,100,20);
        p.add(l9);

        l10=new JLabel("By Default Bill is calculated for 30 days only.");
        l10.setBounds(240,320,500,20);
        p.add(l10);

        b1=new JButton("Submit");
        b1.setBounds(220,390,100,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        p.add(b1);

        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/hicon1.jpg"));
        Image i1=img.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l11=new JLabel(img1);
        add(l11,"West");

        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String meter=meter_no;
            String location=ch1.getSelectedItem();
            String type=ch2.getSelectedItem();
            String phase=ch3.getSelectedItem();
            String bill=ch4.getSelectedItem();
            String days="30";

            try {
                Connect_class obj=new Connect_class();
                String q="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+phase+"','"+bill+"','"+days+"')";
                int a=obj.stm.executeUpdate(q);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Submitted Successfully !!");
                    this.setVisible(false);
                    //new Home_page("","").setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Fill all details carefully !!");
                    this.setVisible(false);
                    //new Home_page("","").setVisible(true);
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Meter_Info("").setVisible(true);
    }
}
