package Concurrency.ConcurrentPackage;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class MyProducer implements Runnable {

    private final ArrayBlockingQueue<String> buffer;
    private String color;


    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        Random random = new Random();
        String[] numbers = {"1", "2", "3", "4", "5"};

        for (String number : numbers) {

            try {

                System.out.println(color + "Adding... " + number);
                buffer.put(number);

                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e ) {

                System.out.println("Producer was interrupted.");
            }
        }

        System.out.println(color + "Adding EOF and exiting... ");

        try {

            buffer.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
