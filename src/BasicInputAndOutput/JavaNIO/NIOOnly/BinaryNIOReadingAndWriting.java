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

            /* Writing and Reading everything into a buffer in one shot into the buffer
            then writing the channel with that buffer.:  */

            ByteBuffer buffer = ByteBuffer.allocate(100);


            /* Chained put method calls */

//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1002).flip();

            /*  Unchained put methods calls, and wiriting data in backwards
            * order, using methods from SeekeableByteChannel */

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long ini1Pos = outputBytes.length;

            buffer.putInt(245);
            long int2Pos = ini1Pos + Integer.BYTES;

            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;

            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            /* Reading data backwards using indexes with SeekeableByteChannel interface  */

            RandomAccessFile ra = new RandomAccessFile(file, "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

            long[] positions = new long[3];

            positions[2] = int3Pos;
            positions[1] = int2Pos;
            positions[0] = ini1Pos;

            for (int i = positions.length - 1; i >= 0; i--) {

                channel.position(positions[i]);
                channel.read(readBuffer);
                readBuffer.flip();

                System.out.println(" Number read: " + readBuffer.getInt());

                if (i != 0) {

                    readBuffer.flip();
                }
            }

            File copy = new File("datacopy.dat");
            RandomAccessFile copyFile = new RandomAccessFile(copy, "rw");
            FileChannel copyChannel = copyFile.getChannel();
            channel.position(0); // Important, since the first argument in transferFrom refers as a relative position instead of an absolute one, so it is necessary to set the channel of the datasource to 0.
            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());

            System.out.println("Num transferred = " + numTransferred);

            channel.close();
            ra.close();
            copyChannel.close();

            /* Reading data sequentally.*/

//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//
//            System.out.println("int 1 = " + readBuffer.getInt());
//            System.out.println("int 2 = " + readBuffer.getInt());
//
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int 3 = " + readBuffer.getInt());

            /* Writing and Reading everything into a buffer sequentally*/
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//            int numBytes = binChannel.write(buffer);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.write(intBuffer);
//
//            System.out.println("numBytes written was: " + numBytes);
//
//            /* Reading data with a RAF using java.io package. */
//
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            byte[] byteArray = new byte[outputBytes.length];
////            ra.read(byteArray);
////            System.out.println(new String(byteArray));
////
////            long firstInt = ra.readInt();
////            System.out.println(firstInt);
//
//            /* Reading data using a RAF with Java.NIO */
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
////            System.out.println("outputBytes = " + new String(outputBytes));
//
//            if (buffer.hasArray()) {
//
//                System.out.println("bytebuffer = " + new String(buffer.array()));
//            }
//
//            /* Relative reads of Integers */
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////            channel.close();
////            ra.close();
//
//            /* Absolute read of Integers, passing an argument to the getInt method to point where exactly the read should begin. */
//
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
