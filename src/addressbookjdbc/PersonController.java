package addressbookjdbc;

import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class PersonController
{
    
    private String name;
    private String phoneNo;
    private String city;
    private String profession;
    private String email;
    private String webUrl;

    public PersonController(String name, String phoneNo, String city, String profession, String email, String webUrl) {
        setName(name);
        setPhoneNo(phoneNo);
        setCity(city);
        setProfession(profession);
        setEmail(email);
        setWebUrl(webUrl);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        while(name.length()<3)
        {
            name = JOptionPane.showInputDialog("Enter Name");
        }
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    private char[] toCharArray(String s)
    {
        if(s == null)
        {
            return null;
        }
        int len = s.length();
        char[] arr = new char[len];
        for(int i=0; i<len; i++)
        {
            arr[i] = s.charAt(i);
        }
        return arr;
    }
    private String makeValidPhoneNo(String no)
    {
        Scanner scan = new Scanner(System.in);
        String ph;
        char ch[] = toCharArray(no);
        boolean chk = true;
        
        do
        {
            chk = true;
            if(ch.length==11)
            {
                for(int i=0; i<11; i++)
                {
                    //System.out.println((int)ch[i]);
                    if((int)ch[i]<48 || (int)ch[i]>57)
                    {
                        chk = false;
                    }
                }
            }
            if(chk == false || ch.length != 11)
            {
                ph = JOptionPane.showInputDialog("Enter Valid Phone Number: ");
                ch = ph.toCharArray();
                //ch = scan.next().toCharArray();
                chk = false;
            }
        }while(chk == false || ch.length != 11);
        return String.valueOf(ch);
    }
    public void setPhoneNo(String phoneNo) {
        
        this.phoneNo = makeValidPhoneNo(phoneNo);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        while(city.length()<3)
        {
            city = JOptionPane.showInputDialog("Enter City");
        }
        this.city = city;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }
    
    private String makeValidEmail(String mail)
    {
        if(mail.contains("@"))
        {
            return mail;
        }
        else
        {
            Scanner scan = new Scanner(System.in);
            do
            {
                mail = null;
                mail = JOptionPane.showInputDialog("Enter Valid Email Address: ");
            }while(!mail.contains("@"));
            
        }
        return mail;
    }

    public void setEmail(String email) {
        this.email = makeValidEmail(email);
        
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
    public String toString()
    {
        return "Name: " +getName()+ ". Contact #: " +getPhoneNo()+ ". Profession: " +getProfession()+ ". Email: " +getEmail()+ ". Url: " +getWebUrl();
    }
    
}
