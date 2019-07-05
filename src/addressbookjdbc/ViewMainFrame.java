package addressbookjdbc;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewMainFrame implements ActionListener
{
    OracleDatabase db;
    private PhoneBookModel pBook;
    protected JFrame frame; 
    protected Container cont;
    private JButton bExit; private JButton bAdd; private JButton bSearch; private JButton bRemove;
    private ResultSet r;
    
    
    
    public ViewMainFrame()
    {
         db = new OracleDatabase();
        pBook = new PhoneBookModel();
        initMainFrame();
    }
    
    public void initMainFrame()
    {
        frame = new JFrame();
        cont = frame.getContentPane();
        cont.setLayout(null);

        bAdd = new JButton("ADD"); bAdd.setFont(new Font("Arial", Font.PLAIN, 18)); bAdd.setBackground(Color.LIGHT_GRAY);
        bAdd.setBounds(70, 40, 150, 40); 
        bAdd.addActionListener(this);
        cont.add(bAdd);

        bSearch = new JButton("SEARCH");  bSearch.setFont(new Font("Arial", Font.PLAIN, 18)); bSearch.setBackground(Color.LIGHT_GRAY);
        bSearch.setBounds(70, 120, 150, 40);
        bSearch.addActionListener(this);
        cont.add(bSearch);
        
        bRemove = new JButton("REMOVE");  bRemove.setFont(new Font("Arial", Font.PLAIN, 18)); bRemove.setBackground(Color.LIGHT_GRAY);
        bRemove.setBounds(70, 200, 150, 40);
        bRemove.addActionListener(this);        
        cont.add(bRemove);
        
        bExit = new JButton("EXIT");  bExit.setFont(new Font("Arial", Font.PLAIN, 18)); bExit.setBackground(Color.LIGHT_GRAY);
        bExit.setBounds(70, 280, 150, 40);
        bExit.addActionListener(this);
        cont.add(bExit);
        
        frame.setVisible(true);
        frame.setBounds(400, 100, 300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ADDRESS BOOK");
        cont.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bAdd)
        {
            frame.dispose();
            AddFrame addFrame = new AddFrame();
        }
        else if(e.getSource() == bSearch)
        {
            frame.dispose();
            SearchFrame searchFrame = new SearchFrame();
        }
        else if(e.getSource() == bRemove)
        {
            frame.dispose();
            RemoveFrame removeFrame = new RemoveFrame();
        }
        else if(e.getSource() == bExit)
        {
            frame.dispose();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private class AddFrame implements ActionListener
{
    private JLabel addName; private JLabel addPhone; private JLabel addEmail; private JLabel addProf; private JLabel addCity; private JLabel addUrl;
    private JTextField tfName;    private JTextField tfPhone;    private JTextField tfMail; private JTextField tfProf; private JTextField tfCity; private JTextField tfUrl;
    private JButton bBack; private JButton bSubmit;
    
    public AddFrame()
    {
        initAddFrame();
        
    }
    
    public void initAddFrame()
    {
        frame = new JFrame();
        cont = frame.getContentPane();
        cont.setLayout(null);
            
        addName = new JLabel("NAME"); addName.setBounds(40, 50, 110, 30);
        addName.setFont(new Font("Arial", Font.PLAIN, 14));
        cont.add(addName);
        tfName = new JTextField(); tfName.setFont(new Font("Arial", Font.PLAIN, 12));
        tfName.setBounds(180, 56, 180, 20); cont.add(tfName);

        addPhone = new JLabel("PHONE NUMBER"); addPhone.setBounds(40, 100, 110, 30);
        addPhone.setFont(new Font("Arial", Font.PLAIN, 14));
        cont.add(addPhone);
        tfPhone = new JTextField(); tfPhone.setFont(new Font("Arial", Font.PLAIN, 12));
        tfPhone.setBounds(180, 105, 180, 20); cont.add(tfPhone);

        addEmail = new JLabel("EMAIL"); addEmail.setBounds(40, 150, 110, 30);
        addEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        cont.add(addEmail);
        tfMail = new JTextField(); tfMail.setFont(new Font("Arial", Font.PLAIN, 12));
        tfMail.setBounds(180, 155, 180, 20); cont.add(tfMail);

        addProf = new JLabel("PROFESSION"); addProf.setBounds(40, 200, 110, 30);
        addProf.setFont(new Font("Arial", Font.PLAIN, 14));
        cont.add(addProf);
        tfProf = new JTextField(); tfProf.setFont(new Font("Arial", Font.PLAIN, 12));
        tfProf.setBounds(180, 205, 180, 20); cont.add(tfProf);

        addCity = new JLabel("CITY"); addCity.setBounds(40, 250, 110, 30);
        addCity.setFont(new Font("Arial", Font.PLAIN, 14));
        cont.add(addCity);
        tfCity = new JTextField(); tfCity.setFont(new Font("Arial", Font.PLAIN, 12));
        tfCity.setBounds(180, 255, 180, 20); cont.add(tfCity);

        addUrl = new JLabel("WEB URL"); addUrl.setBounds(40, 300, 110, 30);
        addUrl.setFont(new Font("Arial", Font.PLAIN, 14));
        cont.add(addUrl);
        tfUrl = new JTextField(); tfUrl.setFont(new Font("Arial", Font.PLAIN, 12));
        tfUrl.setBounds(180, 305, 180, 20); cont.add(tfUrl);

        bSubmit = new JButton("SUBMIT");  bSubmit.setFont(new Font("Arial", Font.PLAIN, 18)); bSubmit.setBackground(Color.DARK_GRAY);
        bSubmit.setBounds(50, 360, 130, 30); bSubmit.setForeground(Color.WHITE);
        bSubmit.addActionListener(this);
        cont.add(bSubmit);

        bBack = new JButton("BACK");  bBack.setFont(new Font("Arial", Font.PLAIN, 18)); bBack.setBackground(Color.DARK_GRAY);
        bBack.setBounds(240, 365, 100, 20); bBack.setForeground(Color.WHITE);
        bBack.addActionListener(this);
        cont.add(bBack);

        frame.setVisible(true);
        frame.setBounds(400, 150, 400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ADDRESS BOOK");
        cont.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bSubmit)
        {
            PersonController p = new PersonController(tfName.getText(), tfPhone.getText(), tfCity.getText(), tfProf.getText(), tfMail.getText(), tfUrl.getText());
            pBook.addContact(p);
        }
        if(e.getSource()==bBack)
        {
            pBook = new PhoneBookModel();
            frame.dispose();
            ViewMainFrame vmf = new ViewMainFrame();
        }
    }
    
}
    
    private class SearchFrame implements ActionListener
    {
        private JComboBox sComboBox;
        private JButton bOk; private JButton bBack;
        
        public SearchFrame()
        {
            initSearchFrame();
        }
        
        
        public void initSearchFrame()
        {
            frame = new JFrame();
            cont = frame.getContentPane();
            cont.setLayout(null);

            String []sList = {"SEARCH BY PHONE", "SEARCH BY NAME", "SEARCH BY EMAIL", "SEARCH BY CITY", "SEARCH BY PROFESSION", "SEARCH BY WEBURL", "SEARCH BY NAME'S FIRST LETTER", "VIEW ALL CONTACTS"};
            sComboBox = new JComboBox(sList); sComboBox.setFont(new Font("Arail", Font.PLAIN, 14));
            sComboBox.setBounds(55, 50, 300, 30); sComboBox.setBackground(Color.WHITE);
            cont.add(sComboBox);
            
            bOk = new JButton("SEARCH"); bOk.setFont(new Font("Arial", Font.PLAIN, 13));
            bOk.setBounds(375, 50, 90, 30); bOk.setBackground(Color.BLACK);
            bOk.setForeground(Color.WHITE); bOk.addActionListener(this);
            cont.add(bOk);
            
            bBack = new JButton("BACK");  bBack.setFont(new Font("Arial", Font.PLAIN, 15)); bBack.setBackground(Color.DARK_GRAY);
            bBack.setBounds(375, 100, 90, 30); bBack.setForeground(Color.WHITE);
            bBack.addActionListener(this);
            cont.add(bBack);
            
            frame.setVisible(true);
            frame.setBounds(400, 200, 500, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("ADDRESS BOOK");
            cont.setBackground(Color.WHITE);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==bOk)
            {
                if(sComboBox.getSelectedItem()=="VIEW ALL CONTACTS")
                {
                    db.CloseResultSet(r);
                    r = pBook.getAllContacts();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY NAME'S FIRST LETTER")
                {
                    db.CloseResultSet(r);
                    String n = JOptionPane.showInputDialog("Enter Contact's Name's First Letter: ");
                    r = pBook.nameStartWith(n);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY PHONE")
                {
                    db.CloseResultSet(r);
                    String ph = JOptionPane.showInputDialog("Enter Contact's Phone: ");
                    r = pBook.searchByPhoneNumber(ph);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY NAME")
                {
                    db.CloseResultSet(r);
                    String name = JOptionPane.showInputDialog("Enter Contact's Name: ");
                    r = pBook.searchByName(name);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY EMAIL")
                {
                    db.CloseResultSet(r);
                    String mail = JOptionPane.showInputDialog("Enter Contact's Email: ");
                    r = pBook.searchByEmail(mail);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY PROFESSION")
                {
                    db.CloseResultSet(r);
                    String prof = JOptionPane.showInputDialog("Enter Contact's Profession: ");
                    r = pBook.searchByProfession(prof);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY WEBURL")
                {
                    db.CloseResultSet(r);
                    String url = JOptionPane.showInputDialog("Enter Contact's WEB-URL: ");
                    r = pBook.searchByWebURL(url);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
                else if(sComboBox.getSelectedItem()=="SEARCH BY CITY")
                {
                    //db.CloseResultSet(r);
                    String city = JOptionPane.showInputDialog("Enter Contact's City: ");
                    r = pBook.searchByCity(city);
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new NewJFrame().setVisible(true);
                    }
                });
                }
            
            }
            else if(e.getSource()==bBack)
            {
                pBook = new PhoneBookModel();
                frame.dispose();
                ViewMainFrame vmf = new ViewMainFrame();
            }
        }
    }
    
    
    private class RemoveFrame implements ActionListener
    {
        private JComboBox sComboBox;
        private JButton bOk; private JButton bBack;
        
        
        public RemoveFrame()
        {
            initRemoveFrame();
        }
        
        
        public void initRemoveFrame()
        {
            frame = new JFrame();
            cont = frame.getContentPane();
            cont.setLayout(null);
            

            String []sList = {"REMOVE BY PHONE", "REMOVE BY NAME", "REMOVE BY EMAIL", "REMOVE BY CITY", "REMOVE BY PROFESSION", "REMOVE BY WEBURL"};
            sComboBox = new JComboBox(sList); sComboBox.setFont(new Font("Arail", Font.PLAIN, 14));
            sComboBox.setBounds(55, 50, 300, 30); sComboBox.setBackground(Color.WHITE);
            cont.add(sComboBox);
            
            bOk = new JButton("DELETE"); bOk.setFont(new Font("Arial", Font.PLAIN, 13));
            bOk.setBounds(375, 50, 90, 30); bOk.setBackground(Color.BLACK);
            bOk.setForeground(Color.WHITE); bOk.addActionListener(this);
            cont.add(bOk);
            
            bBack = new JButton("BACK");  bBack.setFont(new Font("Arial", Font.PLAIN, 15)); bBack.setBackground(Color.DARK_GRAY);
            bBack.setBounds(375, 100, 90, 30); bBack.setForeground(Color.WHITE);
            bBack.addActionListener(this);
            cont.add(bBack);
            
            frame.setVisible(true);
            frame.setBounds(400, 200, 500, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("ADDRESS BOOK");
            cont.setBackground(Color.WHITE);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==bOk)
            {
                if(sComboBox.getSelectedItem()=="REMOVE BY NAME")
                {
                    System.out.println("Hello in name");
                    String name = JOptionPane.showInputDialog("Enter Contact's Name: ");
                    pBook.deleteByName(name);
                }
                else if(sComboBox.getSelectedItem()=="REMOVE BY PHONE")
                {
                    String ph = JOptionPane.showInputDialog("Enter Contact's Phone: ");
                    pBook.deleteByPhoneNumber(ph);
                }
                else if(sComboBox.getSelectedItem()=="REMOVE BY EMAIL")
                {
                    String mail = JOptionPane.showInputDialog("Enter Contact's Email: ");
                    pBook.deleteByEmail(mail);
                }
                else if(sComboBox.getSelectedItem()=="REMOVE BY PROFESSION")
                {
                    String prof = JOptionPane.showInputDialog("Enter Contact's Profession: ");
                    pBook.deleteByProfession(prof);
                }
                else if(sComboBox.getSelectedItem()=="REMOVE BY WEBURL")
                {
                    String url = JOptionPane.showInputDialog("Enter Contact's WEB-URL: ");
                    pBook.deleteByWebURL(url);
                }
                else if(sComboBox.getSelectedItem()=="REMOVE BY CITY")
                {
                    String city = JOptionPane.showInputDialog("Enter Contact's City: ");
                    pBook.deleteByCity(city);
                }
            }
            else if(e.getSource()==bBack)
            {
                pBook = new PhoneBookModel();
                frame.dispose();
                ViewMainFrame vmf = new ViewMainFrame();
            }
        }
        
    }
    
    
    
    
    
    
    public class NewJFrame extends JFrame implements ActionListener
    {
        private JLabel jLabel1;
        private JScrollBar jScrollBar1;
        private JScrollPane jScrollPane1;
        private JTable jTable1;
        
        private DefaultTableModel model;
        JButton bExit;

        public NewJFrame()
        {
            initComponents();
            setBounds(400, 200, 700, 400);
            model = (DefaultTableModel)jTable1.getModel();
            try {
                while(r.next())
                {
                    ResultSetMetaData rsmd = r.getMetaData();
                    Vector<String> colNames = new Vector<String>();
                    int colCount = rsmd.getColumnCount();
                    for(int i=1; i<=colCount; i++)
                    {
                        colNames.add(rsmd.getColumnName(i));
                    }
                    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                    while(r.next())
                    {
                        Vector<Object> vector = new Vector<Object>();
                        for(int i=1; i<=colCount; i++)
                        {
                            vector.add(r.getString(i));
                        }
                            model.addRow(vector);
                                //data.add(vector);
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            bExit = new JButton("EXIT");  bExit.setFont(new Font("Arial", Font.PLAIN, 18)); bExit.setBackground(Color.LIGHT_GRAY);
            bExit.setBounds(270, 280, 150, 40);
            bExit.addActionListener(this);
            getContentPane().add(bExit);

        }
        /*public NewJFrame(ResultSet rs)
        {
            initComponents();
            setBounds(400, 200, 700, 400);
            model = (DefaultTableModel)jTable1.getModel();
            if(rs!=null)
            {
                try {
                    while(rs.next())
                    {
                        ResultSetMetaData rsmd = rs.getMetaData();
                        Vector<String> colNames = new Vector<String>();
                        int colCount = rsmd.getColumnCount();
                        for(int i=1; i<=colCount; i++)
                        {
                            colNames.add(rsmd.getColumnName(i));
                        }
                        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                        while(rs.next())
                        {
                            Vector<Object> vector = new Vector<Object>();
                            for(int i=1; i<=colCount; i++)
                            {
                                vector.add(rs.getString(i));
                            }
                                model.addRow(vector);
                                    //data.add(vector);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }

            bExit = new JButton("EXIT");  bExit.setFont(new Font("Arial", Font.PLAIN, 18)); bExit.setBackground(Color.LIGHT_GRAY);
            bExit.setBounds(270, 280, 150, 40);
            bExit.addActionListener(this);
            getContentPane().add(bExit);

        }*/

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == bExit)
            {
                dispose();
            }

        }
        
        private void initComponents()
        {

            jScrollBar1 = new javax.swing.JScrollBar();
            jLabel1 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jTable1 = new javax.swing.JTable();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("CONTACTS");

            jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String [] {
                    "NAME", "PHONE", "EMAIL", "PROFESSION", "CITY", "WEB URL"
                }
            ));
            jScrollPane1.setViewportView(jTable1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                        .addComponent(jScrollPane1)
                            .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(174, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(160, 160, 160))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(92, Short.MAX_VALUE))
            );

            pack();
        }
        
        
        
        
        
        
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
