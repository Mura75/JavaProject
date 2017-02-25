import sun.rmi.runtime.Log;

import java.io.*;
import java.util.*;

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
                "5) Find contact by full name" + "\n" +
                "6) Sort contact" + "\n" +
                "7) Exit");


        while (scanner.hasNext()) {
            String menuOption = scanner.nextLine();
            if (menuOption.equals("1")) {
                createNewContact(scanner, contactList);
            }
            else if (menuOption.equals("2")) {
                updateContact(scanner, contactList);
            }
            else if (menuOption.equals("3")) {
                deleteContactById(scanner, contactList);
            }
            else if (menuOption.equals("4")) {
                System.out.println(contactList.toString());
            }
            else if (menuOption.equals("5")) {
                findContact(scanner, contactList);
            }
            else if (menuOption.equals("6")) {
                sortedContact(contactList);
            }
            else if (menuOption.equals("7")) {
                System.out.println("Program stopped");
                break;
            }
        }

    }

    //Poisk kontaktov v spiske po imeni
    public static void findContact(Scanner scanner, ArrayList<Contact> contacts) {
        System.out.println("Enter a word: ");
        String subString = scanner.nextLine();

        String lowerSub = subString.toUpperCase();


        //Novi spisok resultat
        ArrayList<Contact> resultList = new ArrayList<>();

        //Ciklom "for each" probegaemcia po spisku kontaktov
        for (Contact contact : contacts) {
            //Polnoe imia cheloveka
            String fullName = contact.getName() + " " + contact.getSurname();
            String fullNameLower = fullName.toUpperCase();
            //Esli v spiske est kontakti kotorie soderzhait
            // takoe sochetanie bukv
            // to zapisivaem ih v novii spisok
            if (fullNameLower.contains(lowerSub)) {
                resultList.add(contact);
            }
        }

        //Vividim rezultat
        System.out.println(resultList.toString());
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
                        "5) Find contact by full name" + "\n" +
                        "6) Sort contact" + "\n" +
                        "7) Exit");
                break;
            }
        }
    }



    public static void sortedContact(ArrayList<Contact> contacts) {
        Collections.sort(contacts);
        for (Contact c : contacts) {
            System.out.println(c.getSurname() + " " + c.getName());
        }
    }


    public static void updateContact(Scanner scanner, ArrayList<Contact> contacts) {
        Collections.sort(contacts);
        for (Contact c : contacts) {
            System.out.println(c.toString());
        }

        System.out.println("\n\n Enter id to find contact and change it:");

        Contact foundContact = null;
        int position = -1;


        for (int i = 0; i < contacts.size(); i++) {
            try {
                Integer id = scanner.nextInt();
                if (id == contacts.get(i).getId()) {
                    foundContact = contacts.get(i);
                    position = i;
                }
            }
            catch (Exception e) {
                System.out.println("Wrong number format");
            }
        }

        if (foundContact != null && position >= 0) {
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
                    foundContact.setName(name);
                    System.out.println("Contact name is: " + foundContact.getName());
                }
                else if (data.equals("b")) {
                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();
                    foundContact.setSurname(surname);
                    System.out.println("Contact surname is: " + foundContact.getSurname());
                }
                else if (data.equals("c")) {
                    System.out.println("Enter phone:");
                    String phone = scanner.nextLine();
                    foundContact.setPhone(phone);
                    System.out.println("Contact phone is: " + foundContact.getPhone());
                }
                else if (data.equals("d")) {
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    foundContact.setEmail(email);
                    System.out.println("Contact email is: " + foundContact.getEmail());
                }
                else if (data.equals("e")) {
                    System.out.println("Contact changed:\n\n\n");
                    contacts.set(position, foundContact);
                    writeListToFile(contacts);
                    System.out.println("1) Create contact" + "\n" +
                            "2) Change contact" + "\n" +
                            "3) Delete contact" + "\n" +
                            "4) Show contact list" + "\n" +
                            "5) Find contact by full name" + "\n" +
                            "6) Sort contact" + "\n" +
                            "7) Exit");
                    break;
                }
            }
        }
        else {
            System.out.println("Contact not exist!!!");
        }
    }


    //Udalenie kontakta po id
    public static void deleteContactById(Scanner scanner, ArrayList<Contact> contacts) {
        Collections.sort(contacts);
        for (Contact c : contacts) {
            System.out.println(c.toString());
        }

        System.out.println("\n\n Enter id to delete contact:");
        try {
            Integer id = scanner.nextInt();
            for (int i = 0; i < contacts.size(); i++) {
                if (id == contacts.get(i).getId()) {
                    Contact contactToRemove = contacts.get(i);
                    contacts.remove(contactToRemove);
                    writeListToFile(contacts);
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Wrong number format");
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
