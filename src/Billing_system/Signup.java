package Billing_system;

import javax.swing.*;
//import javax.swing.border.LineBorder;
//import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3;
    JPasswordField p;
    JButton b1,b2;
    Choice ch;
    JPanel panel;

    Signup(){
        //setSize(700,400);
        //setLocation(450,150);
        setBounds(340,200,700,400);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        panel=new JPanel();
        panel.setBounds(18,20,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(172,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.white);
        panel.setForeground(new Color(34,139,34));
        panel.setLayout(null);
        add(panel);

        l1=new JLabel("Create Account as");
        l1.setBounds(100,50,150,20);
        l1.setForeground(Color.gray);
        l1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(l1);

        ch=new Choice();
        ch.add("Admin");
        ch.add("Customer");
        ch.setBounds(260,50,150,20);
        panel.add(ch);

        l2=new JLabel("Meter Number");
        l2.setBounds(100,90,140,20);
        l2.setForeground(Color.gray);
        l2.setFont(new Font("Tahoma",Font.BOLD,16));
        l2.setVisible(false);
        panel.add(l2);

        t1=new JTextField();
        t1.setBounds(260,90,150,20);
        t1.setVisible(false);
        panel.add(t1);

        l3=new JLabel("Username");
        l3.setBounds(100,130,140,20);
        l3.setForeground(Color.gray);
        l3.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(l3);

        t2=new JTextField();
        t2.setBounds(260,130,150,20);
        panel.add(t2);

        l4=new JLabel("Name");
        l4.setBounds(100,170,140,20);
        l4.setForeground(Color.gray);
        l4.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(l4);

        t3=new JTextField();
        t3.setBounds(260,170,150,20);
        panel.add(t3);

        l5=new JLabel("Password");
        l5.setBounds(100,210,140,20);
        l5.setForeground(Color.gray);
        l5.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(l5);

        p=new JPasswordField();
        p.setBounds(260,210,150,20);
        panel.add(p);

        b1=new JButton("Create");
        b1.setBounds(140,260,130,25);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);

        b2=new JButton("Back");
        b2.setBounds(300,260,130,25);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/signupImage.png"));
        Image i1=img.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l6=new JLabel(img1);
        l6.setBounds(415,30,250,250);
        panel.add(l6);

        b1.addActionListener(this);
        b2.addActionListener(this);

        t1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Connect_class ob1=new Connect_class();
                    String q1="select name from log_in where meter_no='"+t1.getText()+"'";
                    ResultSet rs1=ob1.stm.executeQuery(q1);
                    while (rs1.next()){
                        t3.setText(rs1.getString("name"));
                    }
                    rs1.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        ch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user=ch.getSelectedItem();
                if (user.equals("Customer")){
                    l2.setVisible(true);
                    t1.setVisible(true);
                    t3.setEditable(false);
                }else {
                    l2.setVisible(false);
                    t1.setVisible(false);
                    t3.setEditable(true);
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        if (e.getSource()==b1){
                String account=ch.getSelectedItem();
                String username=t2.getText();
                String name=t3.getText();
                String password=p.getText();
                String meter_no=t1.getText();

                try{
                    if (name.equals("")){
                        JOptionPane.showMessageDialog(null,"All fields are required !!");
                    }
                    else {
                    Connect_class obj=new Connect_class();
                    String q=null;
                    if (account.equals("Admin")){
                        q="insert into log_in values('"+meter_no+"','"+name+"','"+username+"','"+password+"','"+account+"')";
                    }else {
                        q="update log_in set username='"+username+"', password='"+password+"',acc_type='"+account+"' where meter_no='"+meter_no+"'";
                    }
                    int a= obj.stm.executeUpdate(q);
                    if (a==1){
                        JOptionPane.showMessageDialog(null,"Account Created Successfully!!");
                        this.setVisible(false);
                        new Login().setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Fill details Carefully !!");
                    }

                }
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        }

    public static void main(String[] args){
        new Signup().setVisible(true);
    }


}
