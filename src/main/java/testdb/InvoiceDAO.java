package testdb;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAO
{
    public List showInvoice();

    public  void updateInvoice(int id, Date date, String description, double value, byte paid);

    public  void deleteInvoice(int id);

    public  void insertInvoice(Date datum, String besch, int wert, byte bez);



}
