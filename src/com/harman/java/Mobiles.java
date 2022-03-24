package com.harman.java;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mobiles {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("select an option");
            System.out.println("1.Add the smartphones");
            System.out.println("2.view all smartphones ");
            System.out.println("3.search phones based on brand");
            System.out.println("4.edit using imei number");
            System.out.println("5.Delete the smart phone data from db using imei number");
            System.out.println("6.exit");
            option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("1.Add the smartphones");
                    try {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Scanner input = new Scanner(System.in);
                        String imei, brand, model, price;
                        System.out.println("enter imei");
                        imei = input.next();
                        System.out.println("enter brand");
                        brand = input.next();
                        System.out.println("enter model");
                        model = input.next();
                        System.out.println("enter price");
                        price = input.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `smartphones`(`imei`, `brand`, `model`, `price`) VALUES(" + imei + ",'" + brand + "','" + model + "'," + price + ")");
                        System.out.println("Inserted successfully");
                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 2:
                    System.out.println("2.view all smartphones");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartPhonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `imei`, `brand`, `model`, `price` FROM `smartphones` WHERE 1");
                        while (rs.next()){
                            System.out.println("imei="+rs.getInt("imei"));
                            System.out.println("brand="+rs.getString("brand"));
                            System.out.println("model="+rs.getString("model"));
                            System.out.println("price="+rs.getInt("price"));
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }break;
                case 3:

                    try{
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        System.out.println("3.search phones based on brand");
                        Scanner s=new Scanner(System.in);
                        String brand = s.nextLine();
                        ResultSet rs=stmt.executeQuery("SELECT `id`, `imei`, `brand`, `model`, `price` FROM `smartphones` WHERE 1");
                        while (rs.next()){
                            System.out.println("imei="+rs.getInt("imei"));
                            System.out.println("brand="+rs.getString("brand"));
                            System.out.println("model="+rs.getString("model"));
                            System.out.println("price="+rs.getInt("price"));
                            System.out.println("searched successfully");
                        }


                    }catch (Exception e){
                        System.out.println(e);
                    }break;
                case 4:
                    try{
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartPhonedb?autoReconnect=true&useSSL=false","root","");
                        Scanner a=new Scanner(System.in);
                        String brand,model,price,imei;
                        System.out.println("edit using imei number");
                        imei=a.nextLine();
                        System.out.println("Brand :");
                        brand=a.nextLine();
                        System.out.println("Model :");
                        model=a.nextLine();
                        System.out.println("Price :");
                        price=a.nextLine();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("UPDATE `smartphones` SET `brand`='"+brand+"',`model`='"+model+"',`price`="+price+" WHERE `imei`");
                        System.out.println("Updated Successfully");



                    }catch (Exception e){
                        System.out.println(e);


                    }break;
                case 5:
                    try {
                        Connection c= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false","root","");
                        Scanner b=new Scanner(System.in);
                        String imei;
                        System.out.println("Delete Phone data using imei :");
                        imei=b.nextLine();
                        Statement stmt=c.createStatement();
                        stmt.executeUpdate("DELETE FROM `smartphones` WHERE `imei`");
                        System.out.println("Phone Data deleted successfully.");

                    }catch (Exception e){
                        System.out.println(e);

                    }break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    break;


            }
        }
    }
}
