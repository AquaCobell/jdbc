package testdb;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static testdb.App.connectDatabase;

public class InvoiceDAOImpl implements InvoiceDAO
{

    ArrayList<Invoice> invoices;

    InvoiceDAOImpl()
    {
        invoices = new ArrayList<>();

        Date date = new Date(System.currentTimeMillis());
        Invoice test1 = new Invoice(1,date,"test1",1, (byte) 1);
        Invoice test2 = new Invoice(2,date,"test2",2, (byte) 0);
        Invoice test3 = new Invoice(3,date,"test3",3, (byte) 1);
        Invoice test4 = new Invoice(4,date,"test4",4, (byte) 0);
        invoices.add(test1);
        invoices.add(test2);
        invoices.add(test3);
        invoices.add(test4);

    }
    @Override
    public ArrayList<Invoice> showInvoice()
    {

        return invoices;
    }

    @Override
    public void updateInvoice(long id, Date date, String description, double value, byte paid) //Updated
    {

        Invoice invoice = new Invoice(id,date,description,value,paid);
        for(Invoice inv: invoices)
        {
            if(inv.getId()== id)
            {
                Invoice temp = null;
                temp = inv;
                invoices.set(invoices.indexOf(inv),invoice);
            }

        }

        /*if(invoice != null)
        {
            invoice.setDate(date);
            invoice.setDescription(description);
            invoice.setValue(value);
            invoice.setPaid(paid);
            invoices.add(invoice);

        }

         */

    }
    @Override
    public void deleteInvoice(long id)
    {
        for(Invoice inv: invoices)
        {
            if(inv.getId()== id)
            {
                invoices.remove(inv);
            }
        }
    }
    @Override
    public void insertInvoice(Invoice invoice)
    {
        if(invoice != null)
        {
            invoices.add(invoice);
        }
    }
}



