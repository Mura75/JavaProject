import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Murager on 01.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Vvod teksta s klaviaturi
        String input = scanner.nextLine();



        //Put kuda mi hotim zapisiat nashi vvedennie dannie
        // !!!! Ukazite zdes svoi put k failu
        String filePath = "C:\\Users\\Администратор\\Desktop\\myFile\\File.txt";
        //Sozdaem file po ukazanomu puti
        File file = new File(filePath);
        try {
            //Klass kotori otvechiated za zapis v file
            FileWriter bufferedWriter = new FileWriter(file);
            //Zapis v file
            bufferedWriter.append(input);
            // Zakanchivaem zapis v file
            bufferedWriter.close();
        } catch (IOException e) {
            //Vivodim ssobshenie esli zapis ne udalas
            System.out.println("Ne smog zapisiat v fail");
        }


        // Vivod teksta s klaviaturi
        System.out.println(input);
    }

}
