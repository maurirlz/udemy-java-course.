package Networking.LowLevelAPIS.TCPIP.EchoServer;

import java.io.*;
import java.net.Socket;

public class Echoer extends Thread {

    private final Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = reader.readLine();
                System.out.println("Recieved client input: " + echoString);

                if (echoString.equalsIgnoreCase("exit")) {

                    break;
                }

                writer.println(echoString);
            }

        } catch (IOException e) {

            System.out.println("Oops. " + e.getMessage());
        } finally {
            try {

                socket.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
