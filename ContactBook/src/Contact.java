import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;

/**
 * Created by Murager on 08.02.2017.
 */
public class Contact implements Serializable, Comparable {

    private int id;

    private String name;

    private String surname;

    private String phone;

    private String email;


    //Generiruem novii id
    public Contact() {
        id = Math.abs(UUID.randomUUID().hashCode());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'';
    }


    @Override
    public int compareTo(Object o) {
        Contact c = (Contact)o;
        String fullName1 = getSurname() + " " + getName();
        String fullName2 = c.getSurname() + " " + c.getName();
        return fullName1.compareTo(fullName2);
    }
}
