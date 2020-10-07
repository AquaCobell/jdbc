package testdb;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Test");
        //PrintStream stream = new PrintStream(System.out);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdpc","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select Age,Vorname from namen");
            //stream.println(rs);
            while(rs.next())
                System.out.println(rs.getInt("Age")+"  "+rs.getString("Vorname"));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}