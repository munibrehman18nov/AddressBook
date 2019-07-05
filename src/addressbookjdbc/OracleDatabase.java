package addressbookjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OracleDatabase
{
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    protected boolean OpenConnection()
    {
        try
        {
            Scanner scan  = new Scanner(System.in);
            //System.out.print("Enter Database UserName: ");
            String dbUserName = "MYDB";//scan.nextLine();
            //System.out.print("Enter Database Password: ");
            String dbPassword = "123";//scan.nextLine();
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",dbUserName,dbPassword);
            return true;
        }
         catch(ClassNotFoundException ex)
         {
             System.out.println("Connection Failed: Class NotFound");
         }
         catch(SQLException ex)
         {
             System.out.println("SQLException: Your Database UserName or Password is not correct");
         }
        return false;
    }
    
    protected boolean CloseConnection()
    {
        try
        {
            con.close();
            return true;
        }
         catch (SQLException ex)
         {
             System.out.println("Connection not Found or Closed");
         }
        return false;
    }
    
    protected boolean CloseStatement()
    {
        try
        {
            pst.close();
            return true;
        }
         catch (SQLException ex)
         {
             System.out.println("Statement not Found or Closed");
         }
        return false;
    }
    
    protected boolean CloseResultSet()
    {
        try
        {
            rs.close();
            return true;
        }
         catch (SQLException ex)
         {
             System.out.println("ResultSet not Found or Closed");
         }
        return false;
    }
    protected boolean CloseResultSet(ResultSet r)
    {
        if(r!=null)
        {
            try
            {
                r.close();
                return true;
            }
             catch (SQLException ex)
             {
                 System.out.println("ResultSet not Found or Closed");
             }
        }
            return false;
    }
    
    protected ResultSet Query(String q)
    {
        OpenConnection();
        rs = null;
        try
        {
            pst = con.prepareStatement(q);
            rs = pst.executeQuery(q);
        }
         catch (SQLException ex)
         {
             System.out.println("Query(String q): SQLException: Statement is not created");
         }
        return rs;
    }
    
    
    protected int Insert(String q, PersonController p)
    {
        OpenConnection();
        int rows = 0;
        try
        {
            pst = con.prepareStatement(q);
            
            pst.setString(1, p.getName());
            pst.setString(2, p.getPhoneNo());
            pst.setString(3, p.getEmail());
            pst.setString(4, p.getProfession());
            pst.setString(5, p.getCity());
            pst.setString(6, p.getWebUrl());
            rows = pst.executeUpdate();
        }
         catch(SQLException ex)
         {
             System.out.println("SQLException: Insert(String q, Person p): problem in PreparedStatement or pst.executeUpdate(q)");
         }
        
        return rows;
    }
    
    protected int[] Insert(String q, ArrayList<PersonController> pl)
    {
        OpenConnection();
        
        int rows[] = null;
        try
        {   pst = con.prepareStatement(q);
            con.setAutoCommit(false);
            for(PersonController p : pl)
            {
                pst.setString(1, p.getName());
                pst.setString(2, p.getPhoneNo());
                pst.setString(3, p.getEmail());
                pst.setString(4, p.getProfession());
                pst.setString(5, p.getCity());
                pst.setString(6, p.getWebUrl());
                pst.addBatch();
            }
            rows = pst.executeBatch();
            con.commit();
        }
         catch (SQLException ex)
         {
            try
            {
                con.rollback();
            }
             catch(SQLException sqlex)
             {
                System.out.println("SQLException: Insert(String q, ArrayList<Person> pl):  problem in con.rollback");
             }
            System.out.println("SQLException: Insert(String q, ArrayList<Person> pl):  problem in connection or preparedStatement");
         }
        if(rows != null)
        {
            System.out.println("Batch row(s) added");
        }
        else
        {
            System.out.println(0+ " row(s) added");
        }
        return rows;
    }
    
    protected int Delete(String q)
    {
        OpenConnection();
        int rows = 0;
        
        try
        {
            pst = con.prepareStatement(q);
            rows = pst.executeUpdate(q);
        }
         catch(SQLException ex)
         {
             System.out.println("SQLException: Statement is not created");
         }
        return rows;
    }
    
    public void showDatabaseMetaData()
    {
        OpenConnection();
        
        try {
            DatabaseMetaData dbmd = con.getMetaData();
            System.out.println("Database Product Name: " +dbmd.getDatabaseProductName());
            System.out.println("Database Product Version Number: " +dbmd.getDatabaseProductVersion());
            System.out.println("JDBC Driver Name: " +dbmd.getDriverName());
            System.out.println("Is Database Read Only: " +dbmd.isReadOnly());
            
        }
         catch (SQLException ex)
         {
             System.out.println(ex);
         }
        CloseConnection();
    }
}
