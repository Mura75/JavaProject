/**
 * Created by Murager on 04.02.2017.
 */
public class Cat extends Animal {


    // Lkass Cat pereopredeliaet metod svoego roditelia
    @Override
    public void sound() {
        System.out.println("Miau!");
    }


    @Override
    public String toString() {
        return "Cat {\n" + "name=" + name + "\n" + "age=" + age + "\n}";
    }
}
