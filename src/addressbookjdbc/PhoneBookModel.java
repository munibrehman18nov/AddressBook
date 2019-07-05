package addressbookjdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.ScriptingFunctions;

public class PhoneBookModel
{
    private OracleDatabase db;

    public PhoneBookModel()
    {
        db = new OracleDatabase();
    }

    private void showRecord(ResultSet r)
    {
        if(r!=null)
        {
            try {
                int row = 0;

                ResultSetMetaData rsmd = r.getMetaData();
                int nOfCol = rsmd.getColumnCount();
                if(r!=null)
                {
                    try {
                        while(r.next())
                        {
                            System.out.println(r.getString("name") +"\t"+ r.getString("phone") +"\t"+ r.getString("email") +"\t"+ r.getString("profession") +"\t"+ r.getString("city") +"\t"+ r.getString("weburl"));
                            row++;
                        }
                        System.out.println(nOfCol+ " Total Column(s) selected");
                    }
                    catch (SQLException ex)
                    {
                        System.out.println(ex);
                    }
                }
                else
                {
                    System.out.println("no data found");
                }
                System.out.println(row+ " row(s) selected");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public ResultSet searchByName(String nam)
    {
        ResultSet r = null;
        if(nam!=null)
        {
            String q = "select * from CONTACTS where name = "+ "'"+nam+"'" ;
            r = db.Query(q);
            //showRecord(rs);
            //db.CloseResultSet(rs);
            //db.CloseStatement();
            //db.CloseConnection();
        }
        return r;
    }
    
    public int deleteByName(String nam)
    {
        int row = 0;
        if(nam!=null)
        {
            String q = "delete from CONTACTS where name = "+ "'"+nam+"'" ;
            row =  db.Delete(q);
            JOptionPane.showMessageDialog(null, row+ " row(s) deleted");
            db.CloseStatement();
            db.CloseConnection();
        }
        return row;
    }
    
    public ResultSet searchByPhoneNumber(String ph)
    {
        ResultSet r = null;
        if(ph!=null)
        {
            String q = "select * from CONTACTS where phone = "+ "'"+ph+"'" ;
            r = db.Query(q);
            //showRecord(rs);
            //db.CloseResultSet(rs);
            //db.CloseStatement();
            //db.CloseConnection();
        }
        return r;
    }
    
    public int deleteByPhoneNumber(String ph)
    {
        int row = 0;
        if(ph!=null)
        {
            String q = "delete from CONTACTS where phone = "+ "'"+ph+"'" ;
            row = db.Delete(q);
            JOptionPane.showMessageDialog(null, row+ " row(s) deleted");
            db.CloseStatement();
            db.CloseConnection();
        }
        return row;
    }
    
    public ResultSet searchByProfession(String pro)
    {
        ResultSet r = null;
        if(pro!=null)
        {
            String q = "select * from CONTACTS where profession = "+ "'"+pro+"'" ;
            r = db.Query(q);
            //showRecord(rs);
            //db.CloseResultSet(rs);
            //db.CloseStatement();
            //db.CloseConnection();
        }
        return r;
    }
    
    public int deleteByProfession(String pro)
    {
        int row = 0;
        if(pro!=null)
        {
            String q = "delete from CONTACTS where profession = "+ "'"+pro+"'" ;
            row = db.Delete(q);
            JOptionPane.showMessageDialog(null, row+ " row(s) deleted");
            db.CloseStatement();
            db.CloseConnection();
        }
        return row;
    }
    
    public ResultSet searchByWebURL(String url)
    {
        ResultSet r = null;
        if(url!=null)
        {
            String q = "select * from CONTACTS where weburl = "+ "'"+url+"'" ;
            r = db.Query(q);
            //showRecord(rs);
            //db.CloseResultSet(rs);
            //db.CloseStatement();
            //db.CloseConnection();
        }
        return r;
    }
    
    public int deleteByWebURL(String url)
    {
        int row = 0;
        if(url != null)
        {
            String q = "delete from CONTACTS where weburl = "+ "'"+url+"'" ;
            row = db.Delete(q);
            JOptionPane.showMessageDialog(null, row+ " row(s) deleted");
            //db.CloseStatement();
            //db.CloseConnection();
        }
            return row;
    }
    
    public ResultSet searchByEmail(String mail)
    {
        ResultSet r = null;
        if(mail!=null)
        {
            String q = "select * from CONTACTS where email = "+ "'"+mail+"'" ;
            r = db.Query(q);
            //showRecord(rs);
            //db.CloseResultSet(rs);
            //db.CloseStatement();
            //db.CloseConnection();
        }
        return r;
    }
    
    public int deleteByEmail(String mail)
    {
        int row = 0;
        if(mail!=null)
        {
            String q = "delete from CONTACTS where email = "+ "'"+mail+"'" ;
            row = db.Delete(q);
            JOptionPane.showMessageDialog(null, row+ " row(s) deleted");
            db.CloseStatement();
            db.CloseConnection();
        }
        return row;
    }
    
    public ResultSet searchByCity(String city)
    {
        ResultSet rs = null;
        if(city!=null)
        {
            String q = "select * from CONTACTS where city = "+ "'"+city+"'" ;
            rs = db.Query(q);
            //showRecord(rs);
            //db.CloseResultSet(rs);
            //db.CloseStatement();
            //db.CloseConnection();
        }
        return rs;
    }
    
    public int deleteByCity(String city)
    {
        int row = 0;
        if(city!=null)
        {
            String q = "delete from CONTACTS where city = "+ "'"+city+"'" ;
            row = db.Delete(q);
            JOptionPane.showMessageDialog(null, row+ " row(s) deleted");
            db.CloseStatement();
            db.CloseConnection();
        }
        return row;
    }
    
    public int addContact(PersonController p)
    {
        int rows = 0;
        if(p!=null)
        {
            String q = "insert into CONTACTS (name, phone, email, profession, city, weburl) values (?, ?, ?, ?, ?, ?)";
            rows = db.Insert(q, p);
            JOptionPane.showMessageDialog(null, rows+ " row(s) added");
            //System.out.println(rows+ " row(s) added");
            db.CloseStatement();
            db.CloseConnection();
        }
        return rows;
    }
    
    public void addContact(ArrayList<PersonController> pList)
    {
        if(pList!=null)
        {
            String q = "insert into CONTACTS (name, phone, email, profession, city, weburl) values (?, ?, ?, ?, ?, ?)";
            db.Insert(q, pList);
            db.CloseStatement();
            db.CloseConnection();
        }
    }
    
    public void showAllContacts()
    {
        ResultSet rs;
        String q = "select * from contacts";
        rs = db.Query(q);
        showRecord(rs);
        db.CloseResultSet(rs);
        db.CloseStatement();
        db.CloseConnection();
    }
    
    protected ResultSet getAllContacts(String q)
    {
        //String q = "select * from contacts";
        return db.Query(q);
    }
    
    protected ResultSet getAllContacts()
    {
        String q = "select * from contacts";
        return db.Query(q);
    }
    
    public ResultSet nameStartWith(String s)
    {
        //ResultSet rs;
        String s1 = s.toUpperCase();
        String q = "select * from contacts where name like"+  "'"+s+"%'"   +" or "+   "name like"+  "'"+s1+"%'";
        return db.Query(q);
        //showRecord(rs);
    }
    
    public void readContactsFromFile()
    {
        ArrayList<PersonController> pl = new ArrayList<PersonController>();
        FileReader fr = null;
        try
        {
            fr = new FileReader("pInfo.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            do
            {
                s = br.readLine();
                String token[] = s.split(",");
                if(!s.equals("/="))
                {
                    PersonController p = new PersonController(token[0], token[1], token[2], token[3], token[4], token[5]);
                    pl.add(p);
                }
                
            }while(!s.equals("/="));
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        addContact(pl);
    }
    
    
    
}
