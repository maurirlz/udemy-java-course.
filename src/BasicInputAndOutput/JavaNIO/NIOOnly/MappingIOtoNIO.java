package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MappingIOtoNIO {

    public static void main(String[] args) {

        // Get the path of a file.

        File file = new File("/Examples/testtest.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("/Examples");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples", "dir/file.txt");
        System.out.println(resolvedFile.toPath());

        // replace FileSystems.getDefault.getPath with Java.io:

        File workingDirectory = new File("").getAbsoluteFile(); // when passing an empty string to the File constructor, you get the Path to the working directory or current working directory.
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());


        // listing all files in a directory:

        String[] workingDirectoryContents = workingDirectory.list();

        assert workingDirectoryContents != null;
        for (String content : workingDirectoryContents) {

            System.out.print("\n" + content);
        }
    }
}
