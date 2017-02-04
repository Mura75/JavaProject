/**
 * Created by Murager on 04.02.2017.
 */
public class AbstractLesson {

    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.setAge(2);
        cat.setName("Barsik");
        cat.sound();
        System.out.println(cat.toString());
    }

}
