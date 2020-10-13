package testdb;

import java.sql.*;
import java.util.ArrayList;


public class SQLInvoiceDAOImpl implements InvoiceDAO
{
    Connection con;

    public SQLInvoiceDAOImpl()
    {



    }

    public void connectDB()
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       // con.close();

    }

    @Override
    public ArrayList<Invoice> showInvoice()
    {
        ArrayList<Invoice> invoices = new ArrayList<>();
        Statement state = null;
        connectDB();
        try
        {
            state = con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        try
        {
            assert state != null; //kann weggelassen werden
            ResultSet rs=state.executeQuery("select * from invoice");
            while(rs.next())
            {
                //Date date, String description, double value, byte paid
                Invoice invoice = new Invoice(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getDouble(4),rs.getByte(5));
                invoices.add(invoice);
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return invoices;
    }

    @Override
    public void updateInvoice(long id, Date date, String description, double value, byte paid)
    {
        try
        {
            Statement state = con.createStatement();
            String sql = "update invoice"
                    + " set description = '"+description+"' "
                    + " where id = '"+id+"' ";
            state.executeUpdate(sql);

            sql = "update invoice"
                    + " set date = '"+date+"' "
                    + " where id = '"+id+"' ";
            state.executeUpdate(sql);

            sql = "update invoice"
                    + " set value = '"+value+"' "
                    + " where id = '"+id+"' ";
            state.executeUpdate(sql);

            sql = "update invoice"
                    + " set value = '"+value+"' "
                    + " where id = '"+id+"' ";
            state.executeUpdate(sql);

            sql = "update invoice"
                    + " set paid = '"+paid+ "' "
                    + " where id = '"+id+"' ";

            state.executeUpdate(sql);

        }
        catch(Exception e)
        {

            System.out.println(e);
        }
    }

    @Override
    public void deleteInvoice(long id)
    {
        connectDB();
        try
        {
            Statement state = con.createStatement();
            String sql = "delete from invoice where ID = '"+id+"' ";
            state.executeUpdate(sql);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void insertInvoice(Invoice invoice)
    {
        connectDB();
        Date date = invoice.getDate();
        String description = invoice.getDescription();
        double value = invoice.getValue();
        byte paid = invoice.getPaid();
        try
        {
            Statement state = con.createStatement();
            String sql = "insert into invoice "
                    + " (date, description, value, paid)"
                    + " values ('"+date+"'" +
                    ",'"+description+"'" +
                    ",'"+value+"'" +
                    ",'"+paid+"')";
            state.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
