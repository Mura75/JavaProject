/**
 * Created by Murager on 04.02.2017.
 */

//Abstractnii klass kluchivoe slovo "abstract"
public abstract class Animal {

    protected String name;

    protected int age;

    //Abstraktine metodi vsegda bez tela
    public abstract void sound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
