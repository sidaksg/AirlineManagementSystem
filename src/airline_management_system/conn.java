package airline_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///ams","root","mysql123");
            s =c.createStatement();



        }catch(Exception e){
            System.out.println(e);
        }
    }
}
