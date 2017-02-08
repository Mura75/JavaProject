import java.util.Scanner;

/**
 * Created by Murager on 08.02.2017.
 */
public class ContactBook {

    public static void main(String[] args) {

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
                createNewContact();
                break;
            }
            if (menuOption.equals("5")) {
                System.out.println("Program stopped");
                break;
            }
        }

    }


    public static void createNewContact() {
        System.out.println("Create new contact");
        Contact contact = new Contact();
        Scanner scanner = new Scanner(System.in);
        System.out.println("a) Enter name");
        System.out.println("b) Enter surname");
        System.out.println("c) Enter phone");
        System.out.println("e) Enter email");
        System.out.println("d) exit");
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            if (data.equals("a")) {
                String name = scanner.nextLine();
                contact.setName(name);
                System.out.println("Contact name is: " + contact.getName());
            }
            else if (data.equals("b")) {
                contact.setSurname(data);
                System.out.println("Contact surname is: " + contact.getSurname());

            }
            else if (data.equals("x")) {
                contact.toString();
                break;
            }
        }
    }
}
