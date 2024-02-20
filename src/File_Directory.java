import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class File_Directory {
    public static void main(String[] args) throws IOException {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter a file or directory path: ");
        String url = s1.nextLine();

        Path path = Paths.get(url);

        // One method to get all the files under a directory
        File fl = new File(url);
        File[] fls = fl.listFiles();
        for (File f : fls){
            System.out.println(f);
        }

        if(Files.exists(path)){
            System.out.println(path.isAbsolute());
            System.out.println(path.getFileName());
            System.out.println(Files.getLastModifiedTime(path));
            System.out.println(Files.size(path));

            if(Files.isDirectory(path)){
                System.out.println("This is a directory.");

                // Another way to get the contents of the directory
                DirectoryStream<Path> ds = Files.newDirectoryStream(path);
                for(Path p : ds){
                    System.out.println(p);
                }

            }else if(Files.isRegularFile(path)){
                System.out.println("This is an ordinary file.");

            }


        }

    }
}
