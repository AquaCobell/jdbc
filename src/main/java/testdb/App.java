package testdb;

import java.io.PrintStream;
import java.sql.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Test");

        /*try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from invoice");

            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(3));
            con.close();
        }
        catch(Exception e){ System.out.println(e);}

         */
        showInvoice();
    }

    static Connection con;
    static Statement stmt;
    public static void connectDatabase()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
            stmt=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void showInvoice()
    {
        connectDatabase();



        try
        {
            ResultSet rs=stmt.executeQuery("select * from invoice");
            while(rs.next())
            {

                System.out.println(rs.getInt(1) + "  " +rs.getDate(2) + " " + rs.getString(3) +  " " +
                                    rs.getInt(4) + " " + rs.getInt(5) );

            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    public static void insertInvoice(Date date, String description, double value, Boolean paid)
    {

    }
    public static void updateInvoice(int id, Date date, String description, double value, Boolean paid)
    {

    }
    public static void deleteInvoice(int id)
    {

    }


}