package Networking.HighLevelAPIS.URI;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {

            URI baseURI = new URI("http://username:password@mynewserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedURI = baseURI.resolve(uri1);
            URI resolvedURI2 = baseURI.resolve(uri2);
            URI resolvedURI3 = baseURI.resolve(uri3);

            URL url1 = resolvedURI.toURL();
            URL url2 = resolvedURI2.toURL();
            URL url3 = resolvedURI3.toURL();

            System.out.println("URL 1: " + url1);
            System.out.println("URL 2: " + url2);
            System.out.println("URL 3: " + url3);

            URI relativizedURI = baseURI.relativize(resolvedURI2);

            System.out.println("RELATIVE URI2: " + relativizedURI);

        } catch (URISyntaxException | MalformedURLException e) {

            if (e.getClass().equals(MalformedURLException.class)) {

                System.out.println("Malformed url exception: " + e.getMessage());
            } else {

                System.out.println("URI Syntax exception: " + e.getMessage());
            }
         }
    }
}
