import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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
        String filePath = "D:\\myFile\\File.txt";

        //Sozdaem file po ukazanomu puti
        File file = new File(filePath);
        System.out.println("Abs_path " + file.getAbsolutePath() + "  " + file.canWrite());
        try {
            //Klass kotori otvechiated za zapis v file
            FileWriter fileWriter = new FileWriter(file);
            //Zapis v file
            fileWriter.append(input);
            // Zakanchivaem zapis v file
            fileWriter.close();
        } catch (IOException e) {
            //Vivodim ssobshenie esli zapis ne udalas
            System.out.println("Ne smog zapisiat v fail " + e.toString());
        }


        // Vivod teksta s klaviaturi
        System.out.println(input);


        //Sozdaiet massiv 10X10 zapolnenne 1
        createArray();
    }


    public static void createArray() {
        int[][] array = new int[10][10];
        String filePath = "D:\\myFile\\File.txt";

        //Sozdaem file po ukazanomu puti
        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    array[i][j] = 1;
                    fileWriter.append( String.valueOf(array[i][j]) + " ");
                }
                fileWriter.append("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //arrayToFile(Arrays.toString(array));
    }

}
