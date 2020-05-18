package Networking.HighLevelAPIS.URLConnections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {

            URL url = new URL("http://example.org");
            URI uri = url.toURI();

            /*
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );

            String line = "";

            while (line != null) {

                line = inputStream.readLine();
                System.out.println(line);
            }

            inputStream.close();
            */

            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            InputStream in = urlConnection.getInputStream();
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(in));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

//            List<String> headers = headerFields.values().stream()
//                    .collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
//
//
//            headers.forEach(System.out::println);

            headerFields.forEach((s, strings) -> {

                System.out.println("-----Key: " + s);
                strings.forEach(s1 -> {
                    System.out.println("\t\tValue: " + s1);
                });
            });

            inputStream.close();

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
