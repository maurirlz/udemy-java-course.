package ObjectOrientedProgramming.Encapsulation.Challenge;

public class Main {
    public static void main(String[] args) {

        Printer impresora = new Printer(10,10,false);

        impresora.fillToner(50);

        System.out.println("Number of pages printed: " + impresora.printPage());

    }
}
