package addressbookjdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AddressBookJdbc
{

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
    {
        ViewMainFrame vmf = new ViewMainFrame();
        
        /*OracleDatabase db = new OracleDatabase();
        db.showDatabaseMetaData();
        PhoneBook pBook = new PhoneBook();
        /*Person p3 = new Person("xyz a","03333000333","Karachi","CEO","abc.@yahoo.com","https://abc.edu.pk");
        //pBook.addContact(p3);
        Person p1 = new Person("yzx a","03644466753","Multan","Student","abc@yahoo.com","https://abc.edu.pk");
        //pBook.addContact(p1);
        Person p2 = new Person("Aaa a","03711188204","Lahore","Teacher","abc@yahoo.com","https://abc.edu.pk");
        ArrayList<Person> pl = new ArrayList<Person>();
        pl.add(p3);pl.add(p1);pl.add(p2);*/

       /* Scanner scan = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("1. ADD\n2. SEARCH\n3. REMOVE\n4. PRESS ANY KEY TO EXIT");
            int choice  = scan.nextInt();
            
            //char opt = input.charAt(0);
            switch(choice)
            {
                case 1:
                    int addChoice;
                    do
                    {
                        System.out.println("1. ADD A PERSON\n2. ADD MULTIPLE PERSONS (using ArrayList of Persons)\n3. ADD MULTIPLE PERSONS (read Data from a File)\n4. PRESS ANY KEY TO QUIT FROM THIS MENU");
                        addChoice = scan.nextInt();
                        switch(addChoice)
                        {
                            case 1:
                                scan.nextLine();
                                System.out.print("Enter Contact's Name: ");
                                String name = scan.nextLine();
                                System.out.print("Enter Contact's Phone Number: ");
                                String phone = scan.nextLine();
                                System.out.print("Enter Contact's City: ");
                                String city = scan.nextLine();
                                System.out.print("Enter Contact's Profession: ");
                                String prof = scan.nextLine();
                                System.out.print("Enter Contact's Email: ");
                                String mail = scan.nextLine();
                                System.out.print("Enter Contact's WebURL: ");
                                String url = scan.nextLine();
                                Person p = new Person(name, phone, city, prof, mail, url);
                                pBook.addContact(p);
                                break;
                            case 2:
                                scan.nextLine();
                               // pBook.addContact(pl);
                                System.out.println("We dont have so much time to take Input of Multiple Contacts");
                                break;
                            case 3:
                                scan.nextLine();
                                pBook.readContactsFromFile();
                                break;    
                            default:
                                break;
                        }
                    }while(addChoice==1 || addChoice==2);
                    break;
                case 2:
                    int searchChoice;
                    do
                    {
                        System.out.println("1. SEARCH BY NAME\n2. SEARCH BY PHONE\n3. SEARCH BY EMAIL\n4. SEARCH BY CITY\n5. SEARCH BY PROFESSION\n6. SEARCH BY WEBURL\n7. SHOW ALL CONTACTS\n8. SEARCH BY FIRST LETTER\n9. PRESS ANY KEY TO QUIT FROM THIS MENU");
                        searchChoice = scan.nextInt();
                        switch(searchChoice)
                        {
                            case 1:
                                scan.nextLine();
                                System.out.print("Enter Contact's Name: ");
                                String name = scan.nextLine();
                                pBook.searchByName(name);
                                break;
                            case 2:
                                scan.nextLine();
                                System.out.print("Enter Contact's Phone: ");
                                String phone = scan.nextLine();
                                pBook.searchByPhoneNumber(phone);
                                break;
                            case 3:
                                scan.nextLine();
                                System.out.print("Enter Contact's Email: ");
                                String mail = scan.nextLine();
                                pBook.searchByEmail(mail);
                                break;
                            case 4:
                                scan.nextLine();
                                System.out.print("Enter Contact's City: ");
                                String city = scan.nextLine();
                                pBook.searchByCity(city);
                                break;
                            case 5:
                                scan.nextLine();
                                System.out.print("Enter Contact's Profession: ");
                                String prof = scan.nextLine();
                                pBook.searchByProfession(prof);
                                break;
                            case 6:
                                scan.nextLine();
                                System.out.print("Enter Contact's Web URL: ");
                                String url = scan.nextLine();
                                pBook.searchByWebURL(url);
                                break;
                            case 7:
                                scan.nextLine();
                                pBook.showAllContacts();
                                break;
                            case 8:
                                scan.nextLine();
                                System.out.print("Enter Contact's First Letter: ");
                                String ch = scan.nextLine();
                                pBook.nameStartWith(ch);
                                break;
                            default:
                                break;
                        }
                    }while(searchChoice==1 || searchChoice==2 || searchChoice==3 || searchChoice==4 || searchChoice==5 || searchChoice==6 || searchChoice==7 || searchChoice==8);
                    break;
                case 3:
                    int removeChoice;
                    do
                    {
                        System.out.println("1. DELETE BY NAME\n2. DELETE BY PHONE\n3. DELETE BY EMAIL\n4. DELETE BY CITY\n5. DELETE BY PROFESSION\n6. DELETE BY WEBURL\n7. PRESS ANY KEY TO QUIT FROM THIS MENU");
                        removeChoice = scan.nextInt();
                        switch(removeChoice)
                        {
                            case 1:
                                scan.nextLine();
                                System.out.print("Enter Contact's Name: ");
                                String name = scan.nextLine();
                                pBook.deleteByName(name);
                                break;
                            case 2:
                                scan.nextLine();
                                System.out.print("Enter Contact's Phone: ");
                                String phone = scan.nextLine();
                                pBook.deleteByPhoneNumber(phone);
                                break;
                            case 3:
                                scan.nextLine();
                                System.out.print("Enter Contact's Email: ");
                                String mail = scan.nextLine();
                                pBook.deleteByEmail(mail);
                                break;
                            case 4:
                                scan.nextLine();
                                System.out.print("Enter Contact's City: ");
                                String city = scan.nextLine();
                                pBook.deleteByCity(city);
                                break;
                            case 5:
                                scan.nextLine();
                                System.out.print("Enter Contact's Profession: ");
                                String prof = scan.nextLine();
                                pBook.deleteByProfession(prof);
                                break;
                            case 6:
                                scan.nextLine();
                                System.out.print("Enter Contact's Web URL: ");
                                String url = scan.nextLine();
                                pBook.deleteByWebURL(url);
                                break;
                            default:
                                break;
                        }
                    }while(removeChoice==1 || removeChoice==2 || removeChoice==3 || removeChoice==4 || removeChoice==5 || removeChoice==6);
                    break;
                default:
                    System.exit(0);
            }
        }
        
        
        
        
        
        
        
        
       /*Person p = new Person("Arsalan","03228002654","Karachi","CEO","abc.@yahoo.com","https://abc.edu.pk");
        pBook.addContact(p);
        //Person p1 = new Person("Asman","84673864753","Multan","Student","abc@yahoo.com","https://abc.edu.pk");
        //pBook.addContact(p1);
        //Person p2 = new Person("Aoman","93758354204","Lahore","Teacher","abc@yahoo.com","https://abc.edu.pk");
        //ArrayList<Person> pl = new ArrayList<Person>();
        //pl.add(p);pl.add(p1);pl.add(p2);
       // pBook.addContact(pl);
        
        //pBook.addContact(p2);*/
       //pBook.deleteByCity("Karachi");
        //pBook.searchByCity("Lahore");
        //pBook.showAllContacts();
        //pBook.searchByName("Ahmed");
        //pBook.nameStartWith("a");
        //pBook.readContactsFromFile();
        //pBook.searchByPhoneNumber("03228002654");
        
    }
    
}
