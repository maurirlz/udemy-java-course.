package Networking.LowLevelAPIS.UDP.ClientUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {

            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            String echoString;

            do {

                System.out.println("Enter string to be echoed: ");
                echoString = sc.nextLine();

                String s;
                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer,buffer.length, address, 5000);
                datagramSocket.send(packet);


            } while (!echoString.equalsIgnoreCase("exit"));

        } catch (SocketTimeoutException e) {

            System.out.println("Socket timed out.");
        } catch (IOException e) {

            System.out.println("Client error: " + e.getMessage());
        }
    }
}
