package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class CopyDeleteFiles {

    public static void main(String[] args) {

        try {

            Files.createDirectories(FileSystems.getDefault().getPath("Examples"));
            Path newFilePath = FileSystems.getDefault().getPath("Examples", "newFile.txt");

            if (Files.notExists(newFilePath)) {

                Files.createFile(newFilePath);
            }

            Path sourceFile = newFilePath;
            Path copyFile = FileSystems.getDefault().getPath("Examples", "newFileCopy.txt");
            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "fileToDelete.txt");
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(copyFile, fileToDelete, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Want to delete the new created file?");
            Scanner input = new Scanner(System.in);

            if (input.nextLine().equalsIgnoreCase("yes")) {

                Files.deleteIfExists(fileToDelete);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
