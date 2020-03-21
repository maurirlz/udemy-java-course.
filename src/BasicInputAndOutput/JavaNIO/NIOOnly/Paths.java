package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Paths {
    public static void main(String[] args) {


    }

    private static void printFIle(Path path) {

        try (BufferedReader fileReader = Files.newBufferedReader(path)) {

            String line;

            while ((line = fileReader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}