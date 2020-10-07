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

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from invoice");

            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }


    public static void showInvoices()
    {


    }
    public static void insertInvoices()
    {

    }


}