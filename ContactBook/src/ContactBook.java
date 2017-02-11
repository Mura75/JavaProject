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

        if (getContactsFromFile() == null) {
            contactList = new ArrayList<>();
        }
        else {
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


    //Записль списка в файл
    public static void writeListToFile(List<Contact> contacts) {
        //Путь к файлу
        String filePath = "D:\\myFile\\Contacts.txt";
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contacts);
            oos.close();
            System.out.println("Write to file finished");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    //Чтение списка в файл
    public static ArrayList<Contact> getContactsFromFile() {
        String filePath = "D:\\myFile\\Contacts.txt";
        ArrayList<Contact> contactList;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contactList = (ArrayList<Contact>)ois.readObject();
            ois.close();
            return contactList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
