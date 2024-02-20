import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFile_ {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter a file to be copied: ");
        String path = s1.nextLine();

        File inputFile = new File(path);
        File outputFile = new File("C:\\Users\\zhang\\Desktop\\CST8288 Java\\BACKUP.txt");

        PrintWriter out = new PrintWriter(outputFile);
        Scanner s2 = new Scanner(inputFile);
        while(s2.hasNextLine()){
            String line = s2.nextLine();
            out.println(line);
        }
        s1.close();
        s2.close();
        out.close();

    }
}
