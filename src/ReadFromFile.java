import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Murager on 04.02.2017.
 */
public class ReadFromFile {

    public static void main(String[] args) {

        //Put k failu otkuda mi hotim schtiat dannie
        File file = new File("D:\\myFile\\File.txt");

        try {
            //Chtenie s faila
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);

            //Vivod teksta
            String text = scanner.nextLine();
            System.out.println(text);
        }
        catch (Exception e) {
            // Pokaziat teks oshibki esli ona est
            System.out.println(e.toString());
        }

    }
}
