package Networking.LowLevelAPIS.TCPIP.EchoClient;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 5000)) {

            socket.setSoTimeout(5000);

            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            String echoString;
            String response;

            do {

                System.out.println("Enter string to be echoed: ");
                echoString = sc.nextLine();

                stringToEcho.println(echoString);

                if (!echoString.equalsIgnoreCase("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }

            } while (!echoString.equalsIgnoreCase("exit"));

        } catch (SocketTimeoutException e) {

            System.out.println("socket timed out. " +  e.getMessage());
        } catch (IOException e) {

            System.out.println("Client error: " + e.getMessage());
        }
    }
}
