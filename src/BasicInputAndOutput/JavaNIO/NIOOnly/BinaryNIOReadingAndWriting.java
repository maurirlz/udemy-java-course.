package BasicInputAndOutput.JavaNIO.NIOOnly;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BinaryNIOReadingAndWriting {

    public static void main(String[] args) {

        File file = new File("data.dat");

        try (FileOutputStream binFile = new FileOutputStream(file)) {

            FileChannel binChannel = binFile.getChannel();
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            buffer.put(outputBytes);
            buffer.flip();
            int numBytes = binChannel.write(buffer);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.write(intBuffer);

            System.out.println("numBytes written was: " + numBytes);

            /* Reading data with a RAF using java.io package. */

//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] byteArray = new byte[outputBytes.length];
//            ra.read(byteArray);
//            System.out.println(new String(byteArray));
//
//            long firstInt = ra.readInt();
//            System.out.println(firstInt);

            /* Reading data using a RAF with Java.NIO */
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            buffer.flip();
            long numBytesRead = channel.read(buffer);
//            System.out.println("outputBytes = " + new String(outputBytes));

            if (buffer.hasArray()) {

                System.out.println("bytebuffer = " + new String(buffer.array()));
            }

            /* Relative reads of Integers */
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            channel.close();
//            ra.close();

            /* Absolute read of Integers, passing an argument to the getInt method to point where exactly the read should begin. */

            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
