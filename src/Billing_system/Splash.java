package Billing_system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    JLabel image;
    int x=1;
    Thread thread;

    Splash(){

        ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("Billing_system/icon/elect.jpg"));
        Image i1=img1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i1);

        image=new JLabel(img2);
        add(image);

        setVisible(true);

        for (int i=2;i<600;i+=4,x+=1){
            setSize(i+x,i);
            setLocation(700-((i+x)/2),400-(i/2));

            try {
                Thread.sleep(5);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            thread=new Thread(this);
            thread.start();
        }
    }
    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Splash();
    }
}
