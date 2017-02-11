import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Murager on 08.02.2017.
 */
public class ContactBook {

    public static void main(String[] args) {

        ArrayList<Contact> contactList;

        //Proveriaem esli u nas spisok kontaktov v faile
        if (getContactsFromFile() == null) { // Esli ego net to sozdaem novii spisok
            contactList = new ArrayList<>();
        }
        else {
            //Esli on est to prisvaemevaem spisok iz faila k sozdannomu spisku
            contactList = getContactsFromFile();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose option:");
        System.out.println("1) Create contact" + "\n" +
                           "2) Change contact" + "\n" +
                           "3) Delete contact" + "\n" +
                           "4) Show contact list" + "\n" +
                           "5) Exit");


        while (scanner.hasNext()) {
            String menuOption = scanner.nextLine();
            if (menuOption.equals("1")) {
                createNewContact(scanner, contactList);
            }
            else if (menuOption.equals("4")) {
                System.out.println(contactList.toString());
            }
            else if (menuOption.equals("5")) {
                System.out.println("Program stopped");
                break;
            }
        }

    }


    public static void createNewContact(Scanner scanner, ArrayList<Contact> list) {
        System.out.println("Create new contact");
        Contact contact = new Contact();
        System.out.println("a) Enter name");
        System.out.println("b) Enter surname");
        System.out.println("c) Enter phone");
        System.out.println("d) Enter email");
        System.out.println("e) exit");
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            if (data.equals("a")) {
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                contact.setName(name);
                System.out.println("Contact name is: " + contact.getName());
            }
            else if (data.equals("b")) {
                System.out.println("Enter surname:");
                String surname = scanner.nextLine();
                contact.setSurname(surname);
                System.out.println("Contact surname is: " + contact.getSurname());
            }
            else if (data.equals("c")) {
                System.out.println("Enter phone:");
                String phone = scanner.nextLine();
                contact.setPhone(phone);
                System.out.println("Contact phone is: " + contact.getPhone());
            }
            else if (data.equals("d")) {
                System.out.println("Enter email:");
                String email = scanner.nextLine();
                contact.setEmail(email);
                System.out.println("Contact email is: " + contact.getEmail());
            }
            else if (data.equals("e")) {
                System.out.println("Contact created!" + "\n\n\n");
                list.add(contact);
                writeListToFile(list);
                System.out.println("1) Create contact" + "\n" +
                        "2) Change contact" + "\n" +
                        "3) Delete contact" + "\n" +
                        "4) Show contact list" + "\n" +
                        "5) Exit");
                break;
            }
        }
    }


    //Zapis spiske v fail
    public static void writeListToFile(List<Contact> contacts) {
        //put k failu
        String filePath = "D:\\myFile\\Contacts.txt";
        try {
            //Zapis v fail
            FileOutputStream fos = new FileOutputStream(filePath);
            //Zapis obiekt (spisok) v fail
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.close();
            System.out.println("Write to file finished");
        } catch (Exception e) {
            //Esli budet oshibke to pokaziat ee
            System.out.println(e.getMessage());
        }

    }


    //Chtenie spiska s faila
    public static ArrayList<Contact> getContactsFromFile() {
        //Put k failu
        String filePath = "D:\\myFile\\Contacts.txt";
        ArrayList<Contact> contactList;
        try {
            //Cheteni dannih s faila
            FileInputStream fis = new FileInputStream(filePath);
            //Chtenie obiektov iz potoke dannih
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Poluchennie obiekto prisvaevaem spisku
            contactList = (ArrayList<Contact>) ois.readObject();
            ois.close();

            //Vozvrashaiem spisok
            return contactList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //esli nichego net vozvrashiaem NULL
        return null;
    }
}
