package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributes {

    public static void main(String[] args) throws IOException {

        Path fileToCreate = FileSystems.getDefault().getPath("Examples", "fileattributeslesson.txt");

        if (Files.notExists(fileToCreate)) {

            Files.createFile(fileToCreate);
        }

        Path dirToCreate = FileSystems.getDefault().getPath("Examples", "newDir");

        if (Files.notExists(dirToCreate)) {

            Files.createDirectory(dirToCreate); // creates a single directory
        }

        Path directoriesToCreate = FileSystems.getDefault().getPath("Examples", "newDirectory", "oneLayer", "twoLayers");

        if (Files.notExists(directoriesToCreate)) {

            Files.createDirectories(directoriesToCreate);
        }

        Path twoLayersFolder = FileSystems.getDefault().getPath("Examples/newDirectory/oneLayer/twoLayers");
        BasicFileAttributes attributesTwoLayer = Files.readAttributes(twoLayersFolder, BasicFileAttributes.class);

        System.out.print("two Layers folder attributes: " +
                "\n size: " + attributesTwoLayer.size() +
                "\n Last modified: " + attributesTwoLayer.lastModifiedTime() +
                "\n Created: " + attributesTwoLayer.creationTime() +
                "\n is a directory? " + attributesTwoLayer.isDirectory());
    }
}
