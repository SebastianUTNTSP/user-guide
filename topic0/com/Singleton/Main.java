package com.Singleton;


import java.sql.*;
public class Main {

    public static void main(String[] args) {



	    Connection myConn = Singleton.getDatabaseConnection();
        try{
        Statement myStmt = myConn.createStatement();
        ResultSet myRs= myStmt.executeQuery("select * from student");

    while(myRs.next()){
        System.out.println(myRs.getString("last_name")+" "+ myRs.getString("first_name")+", "+myRs.getInt(3));
    }


    }catch (Exception e){
	    e.printStackTrace();
    }
    }
}
class Singleton {
    static Connection conn =null;


    private Singleton(){

    }


    public static Connection getDatabaseConnection(){
        try{

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }




}