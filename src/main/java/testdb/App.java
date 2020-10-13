package testdb;

import java.io.PrintStream;
import java.sql.*;
import java.util.Calendar;


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

        //Date datum = new java.sql.Date(Calendar.getInstance().getTime().getTime());;
        //Date datum = new Date(System.currentTimeMillis());

        long millis=System.currentTimeMillis();

        java.sql.Date datum=new java.sql.Date(millis);
        //System.out.println("hallo " +datum.getTime() +"  ");
        byte test = 0;

        //insertInvoice(datum,"Testobjekt",30 ,test); //funtkioniert
        //deleteInvoice(30); //funktioniert nicht
        // updateInvoice(30,datum,"Moin",30 ,test); //funktioniert nicht
        showInvoice();

        //updateInvoice(datum,"Moin",30 ,test);
        //deleteInvoice(24);

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


    public static void insertInvoice(Date datum, String besch, int wert, byte bez)
    {
        connectDatabase();
        try
        {
            Statement state = con.createStatement();
            String sql = "insert into invoice "
                + " (date, description, value, paid)"
                + " values ('"+datum+"'" +
                    ",'"+besch+"'" +
                    ",'"+wert+"'" +
                    ",'"+bez+"')";
            state.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
    public static void updateInvoice(int id,Date date, String description, double value, byte paid)
    {

        connectDatabase();
        try
        {
            Statement state = con.createStatement();
            String sql = "update invoice"
                    + " set description = '"+description+"' "
                    + " set date = '"+date+"' "
                    + " set value = '"+value+"' "
                    + " set paid = '"+paid+ "' "
                    + " where id = '"+id+"' ";
            System.out.println("hello");
        }
        catch(Exception e)
        {

            System.out.println(e);
        }



    }
    public static void deleteInvoice(int id)
    {
        connectDatabase();
        try
        {
            Statement state = con.createStatement();
            String sql = "delete from invoice where ID = '"+id+"' ";
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


}