package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BInaryNIOHelloWorld {

    public static void main(String[] args) {

        File file = new File("data.dat");

        try (FileOutputStream binFile = new FileOutputStream(file)) {

            FileChannel binChannel = binFile.getChannel();
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.write(intBuffer);

            System.out.println("numBytes written was: " + numBytes);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
