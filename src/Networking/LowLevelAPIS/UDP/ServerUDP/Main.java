package Networking.LowLevelAPIS.UDP.ServerUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        try {

            DatagramSocket socket = new DatagramSocket(5000);
            while (true) {

                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                socket.receive(packet);
                String message = new String(buffer, 0, packet.getLength(), StandardCharsets.UTF_8);

                System.out.println("Text received is: " + message);

                String returnString = "echo: " + new String(buffer, 0, packet.getLength());

                byte[] buffer2 = returnString.getBytes(StandardCharsets.UTF_8);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();

                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet);
            }

        } catch (SocketException e) {

            System.out.println("Socketexception: " + e.getMessage());
        } catch (IOException e) {

            System.out.println("IO exception: " + e.getMessage());
        }
    }
}
