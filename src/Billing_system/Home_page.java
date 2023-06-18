package Billing_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home_page extends JFrame implements ActionListener{

    JLabel image;
    JMenuBar mb;
    JMenu m1,m2,m3,m4,m5,m6;
    JMenuItem mt1,mt2,mt3,mt4,mt5,mt6,mt7,mt8,mt9,mt10,mt11,mt12;
    String user,meter_no;

    Home_page(String account,String meter){
        super("Electricity Billing System");

        this.user=account;
        this.meter_no=meter;
        //setSize(1550,800);
        //setLocation(0,0);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        ImageIcon img= new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/elect1.jpg"));
        Image i1=img.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        image=new JLabel(img1);
        add(image);

        mb=new JMenuBar();
        setJMenuBar(mb);

        setLayout(new FlowLayout());

        m1=new JMenu("Master");
        m1.setFont(new Font("Arial",Font.BOLD,16));
        m1.setForeground(Color.BLUE);

        mt1=new JMenuItem("New Customer");
        mt1.setFont(new Font("monospace",Font.PLAIN,12));
        mt1.setBackground(Color.WHITE);
        ImageIcon img2=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon1.png"));
        Image i2=img2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(i2);
        mt1.setIcon(img3);
        mt1.setMnemonic('D');
        mt1.addActionListener(this);
        mt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        m1.add(mt1);

        mt2=new JMenuItem("Customer Details");
        mt2.setFont(new Font("monospace",Font.PLAIN,12));
        mt2.setBackground(Color.WHITE);
        ImageIcon img4=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon2.png"));
        Image i3=img4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img5=new ImageIcon(i3);
        mt2.setIcon(img5);
        mt2.setMnemonic('M');
        mt2.addActionListener(this);
        mt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        m1.add(mt2);

        mt3=new JMenuItem("Deposit Details");
        mt3.setFont(new Font("monospace",Font.PLAIN,12));
        mt3.setBackground(Color.WHITE);
        ImageIcon img6=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon3.png"));
        Image i4=img6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img7=new ImageIcon(i4);
        mt3.setIcon(img7);
        mt3.setMnemonic('N');
        mt3.addActionListener(this);
        mt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        m1.add(mt3);

        mt4=new JMenuItem("Calculate Bill");
        mt4.setFont(new Font("monospace",Font.PLAIN,12));
        mt4.setBackground(Color.WHITE);
        ImageIcon img8=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon5.png"));
        Image i5=img8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img9=new ImageIcon(i5);
        mt4.setIcon(img9);
        mt4.setMnemonic('B');
        mt4.addActionListener(this);
        mt4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        m1.add(mt4);

        m2=new JMenu("Information");
        m2.setFont(new Font("Arial",Font.BOLD,16));
        m2.setForeground(Color.RED);

        mt5=new JMenuItem("Update Info");
        mt5.setFont(new Font("monospace",Font.PLAIN,12));
        mt5.setBackground(Color.WHITE);
        ImageIcon img10=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon4.png"));
        Image i6=img10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img11=new ImageIcon(i6);
        mt5.setIcon(img11);
        mt5.setMnemonic('U');
        mt5.addActionListener(this);
        mt5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        m2.add(mt5);

        mt6=new JMenuItem("View Info");
        mt6.setFont(new Font("monospace",Font.PLAIN,12));
        mt6.setBackground(Color.WHITE);
        ImageIcon img12=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon6.png"));
        Image i7=img12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img13=new ImageIcon(i7);
        mt6.setIcon(img13);
        mt6.setMnemonic('V');
        mt6.addActionListener(this);
        mt6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        m2.add(mt6);

        m3=new JMenu("User");
        m3.setFont(new Font("Arial",Font.BOLD,16));
        m3.setForeground(Color.BLUE);

        mt7=new JMenuItem("Pay Bill");
        mt7.setFont(new Font("monospace",Font.PLAIN,12));
        mt7.setBackground(Color.WHITE);
        ImageIcon img14=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon4.png"));
        Image i8=img14.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img15=new ImageIcon(i8);
        mt7.setIcon(img15);
        mt7.setMnemonic('P');
        mt7.addActionListener(this);
        mt7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        m3.add(mt7);

        mt8=new JMenuItem("Bill Details");
        mt8.setFont(new Font("monospace",Font.PLAIN,12));
        mt8.setBackground(Color.WHITE);
        ImageIcon img16=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon6.png"));
        Image i9=img16.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img17=new ImageIcon(i9);
        mt8.setIcon(img17);
        mt8.setMnemonic('L');
        mt8.addActionListener(this);
        mt8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        m3.add(mt8);

        m4=new JMenu("Report");
        m4.setFont(new Font("Arial",Font.BOLD,16));
        m4.setForeground(Color.RED);

        mt9=new JMenuItem("Generate Bill");
        mt9.setFont(new Font("monospace",Font.PLAIN,12));
        mt9.setBackground(Color.white);
        ImageIcon img18=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon7.png"));
        Image i10=img18.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img19=new ImageIcon(i10);
        mt9.setIcon(img19);
        mt9.setMnemonic('G');
        mt9.addActionListener(this);
        mt9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        m4.add(mt9);

        m5=new JMenu("Utility");
        m5.setFont(new Font("Arial",Font.BOLD,16));
        m5.setForeground(Color.BLUE);

        mt10=new JMenuItem("Notepad");
        mt10.setFont(new Font("monospace",Font.PLAIN,12));
        mt10.setBackground(Color.WHITE);
        ImageIcon img20=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon12.png"));
        Image i11=img20.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img21=new ImageIcon(i11);
        mt10.setIcon(img21);
        mt10.setMnemonic('A');
        mt10.addActionListener(this);
        mt10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        m5.add(mt10);

        mt11=new JMenuItem("Calculator");
        mt11.setFont(new Font("monospace",Font.PLAIN,12));
        mt11.setBackground(Color.WHITE);
        ImageIcon img22=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon9.png"));
        Image i12=img22.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img23=new ImageIcon(i12);
        mt11.setIcon(img23);
        mt11.setMnemonic('J');
        mt11.addActionListener(this);
        mt11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
        m5.add(mt11);

        m6=new JMenu("EXIT");
        m6.setFont(new Font("Arial",Font.BOLD,16));
        m6.setForeground(Color.RED);

        mt12=new JMenuItem("Exit");
        mt12.setFont(new Font("monospace",Font.PLAIN,12));
        mt12.setBackground(Color.WHITE);
        ImageIcon img24=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/icon11.png"));
        Image i13=img24.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon img25=new ImageIcon(i13);
        mt12.setIcon(img25);
        mt12.setMnemonic('Q');
        mt12.addActionListener(this);
        mt12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
        m6.add(mt12);

        if (user.equals("Admin")){
            mb.add(m1);
        }else {
            mb.add(m2);
            mb.add(m3);
            mb.add(m4);
        }

        mb.add(m5);
        mb.add(m6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        if (cmd.equals("New Customer")){
            new New_customer().setVisible(true);
        } else if (cmd.equals("Customer Details")) {
            new Customer_details().setVisible(true);
        } else if (cmd.equals("Deposit Details")) {
            new Deposit_details().setVisible(true);
        } else if (cmd.equals("Calculate Bill")) {
            new Calculate_bill().setVisible(true);
        } else if (cmd.equals("View Info")) {
            new View_info(meter_no).setVisible(true);
        } else if (cmd.equals("Update Info")) {
            new Update_info(meter_no).setVisible(true);
        } else if (cmd.equals("Bill Details")) {
            new Bill_details(meter_no).setVisible(true);
        } else if (cmd.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e4){
                e4.printStackTrace();
            }
        } else if (cmd.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e5){
                e5.printStackTrace();
            }
        } else if (cmd.equals("Exit")) {
            //System.exit(0);
            setVisible(false);
            new Login().setVisible(true);
        } else if (cmd.equals("Pay Bill")) {
            new Pay_bill(meter_no).setVisible(true);
        } else if (cmd.equals("Generate Bill")) {
            new Generate_bill(meter_no).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Home_page("","").setVisible(true);
    }
}
