package Networking.HighLevelAPIS.HTTPURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {

        try {

            URL url = new URL("http://example.org");
            URI uri = url.toURI();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);
            int response = connection.getResponseCode();

            System.out.println("Response code: " + response);

            InputStream in = connection.getInputStream();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(in));

            String line;

            while((line = inputReader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (URISyntaxException | MalformedURLException e) {

            if (e.getClass().equals(MalformedURLException.class)) {

                System.out.println("Malformed url exception: " + e.getMessage());
            } else {

                System.out.println("URI Syntax exception: " + e.getMessage());
            }
        } catch (IOException e) {

            System.out.println("IO exception: " + e.getMessage());
        }
    }
}
