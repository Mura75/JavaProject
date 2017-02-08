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
                createNewContact(scanner);
            }
            if (menuOption.equals("5")) {
                System.out.println("Program stopped");
                break;
            }
        }

    }


    public static void createNewContact(Scanner scanner) {
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
                String surname = scanner.nextLine();
                contact.setSurname(surname);
                System.out.println("Contact surname is: " + contact.getSurname());
            }
            else if (data.equals("c")) {
                String phone = scanner.nextLine();
                contact.setPhone(phone);
                System.out.println("Contact phone is: " + contact.getPhone());
            }
            else if (data.equals("d")) {
                String email = scanner.nextLine();
                contact.setEmail(email);
                System.out.println("Contact email is: " + contact.getEmail());
            }
            else if (data.equals("e")) {
                System.out.println("Contact created!" + "\n\n\n");
                System.out.println("1) Create contact" + "\n" +
                        "2) Change contact" + "\n" +
                        "3) Delete contact" + "\n" +
                        "4) Show contact list" + "\n" +
                        "5) Exit");
                break;
            }
        }
    }
}
