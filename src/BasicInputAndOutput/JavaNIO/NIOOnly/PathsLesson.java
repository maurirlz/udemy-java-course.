package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsLesson {
    public static void main(String[] args) {

        Path firstPath = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        Path secondPath = FileSystems.getDefault().getPath("Files", "SubDirectoryFile.txt"); // relative path, getDefault method gets thw working directory (in this case, my folder under git/udemy-java-course/ and then gets the txt's relative path.
        Path thirdPath = java.nio.file.Paths.get("/home/maaush/git/OutThere.txt"); // Absolute path, use readlink -f file.txt on terminal (linux) to get the absolute path of the desired folder.

        secondPath = Paths.get(".", "Files", "SubDirectoryFile.txt"); // Relative path with Paths instead of Filesystems, getting first the working directory as an argument (.) and then navigating
                                                                        // to Files, and then getting the Path of the desired file.

        Path thirdPathAbsolute = thirdPath.toAbsolutePath();

        System.out.println(thirdPathAbsolute); // prints the absolute path of the third file in /home/maaush/git/

        System.out.println("-----------------------------------------------------------------");
        printFIle(firstPath);
        System.out.println("-----------------------------------------------------------------");
        printFIle(secondPath);
        System.out.println("-----------------------------------------------------------------");
        printFIle(thirdPath);
        System.out.println("-----------------------------------------------------------------");
    }

    private static void printFIle(Path path) {

        try (BufferedReader fileReader = Files.newBufferedReader(path)) {

            String line;

            while ((line = fileReader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
