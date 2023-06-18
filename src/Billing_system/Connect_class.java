package Billing_system;

import java.sql.*;

public class Connect_class {

    Connection con=null;
    Statement stm;

    Connect_class(){
        try{
            //Loading Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver Loaded");

            //Establishing Connnection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_system","root","rishu12345");
            //System.out.println("Connection Established");

            stm=con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Connect_class();
    }
}
