package BankManagment;
import java.sql.*;  

public class Connect{
    Connection c;
    Statement s;
    public Connect(){  
        try{  
            c =DriverManager.getConnection("jdbc:mysql:///BankManagmentSystem","root","Keshu@13p");    
            s =c.createStatement(); 
                 
        }
        catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  