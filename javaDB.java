package javadb;
import java.sql.*;

public class JavaDB {

    public static void main(String[] args) {
        insert();
        select();
        delete();
        select();
        update();
        select();
    }
    
    public static void insert(){
        
        Connection con;
        String dburl = "jdbc:mysql://localhost:3306/javadb";
        String dbuser = "root";
        String dbpassword = "root";
        String query;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbuser, dbpassword);
            
            Statement statement; 
            statement = con.createStatement(); //create statements to be inputted in mySQL
            
            query = "INSERT INTO employees (firstName, lastName, address) values (\"Daniel\", \"Padilla\", \"Manila\")";
            
            statement.executeUpdate(query);
            statement.close();
            con.close();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            
        }
    }
    
    public static void update(){
        Connection con;
        String dburl = "jdbc:mysql://localhost:3306/javadb";
        String dbuser = "root";
        String dbpassword = "root";
        String query;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbuser, dbpassword);
            
            Statement statement; 
            statement = con.createStatement(); //create statements to be inputted in mySQL
            
            query = "UPDATE employees set firstname = 'Khaye' WHERE firstname = 'Arj'" ;
            
            statement.executeUpdate(query);
            statement.close();
            con.close();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            
        }
    }
    
    public static void delete(){
        Connection con;
        String dburl = "jdbc:mysql://localhost:3306/javadb";
        String dbuser = "root";
        String dbpassword = "root";
        String query;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbuser, dbpassword);
            
            Statement statement; 
            statement = con.createStatement(); //create statements to be inputted in mySQL
            
            query = "DELETE FROM employees WHERE firstname = 'Daniel'";
            
            statement.executeUpdate(query);
            statement.close();
            con.close();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            
        }
    }
    
    public static void select(){
        
        Connection con;
        String dburl = "jdbc:mysql://localhost:3306/javadb";
        String dbuser = "root";
        String dbpassword = "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dburl, dbuser, dbpassword);
            
            Statement statement; 
            statement = con.createStatement(); //create statements to be inputted in mySQL
            ResultSet resultSet; //returns statement to mySQL
            resultSet = statement.executeQuery("select * from employees"); //appends text to the input
            
            //to print content of result set
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)); //numbers represent id of column (1 - employeeID, 2 - firstname)                                                                        
            }
            
            resultSet.close();
            statement.close();
            con.close();
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            
        }
    }