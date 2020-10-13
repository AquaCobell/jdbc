package testdb;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAO
{
    public List showInvoice();

    public  void updateInvoice(long id, Date date, String description, double value, byte paid);

    public  void deleteInvoice(long id);

    public  void insertInvoice(Invoice invoice);



}
