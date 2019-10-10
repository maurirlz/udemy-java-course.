package ExpressionsStatementsCodeBlocksMethods.Methods;

public class MegaBytesConverter {
    public static void main(String[] args) {
        int kiloBytes = 2500;
        printMegaBytesAndKiloBytes(kiloBytes);

    }
    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if (kiloBytes < 0){
            System.out.println("Invalid Value");
        } else {
            /* 1MB = 1024KB */
            int megaBytes = kiloBytes / 1024;
            int remainder = kiloBytes % 1024;

            System.out.println(kiloBytes + " KB = "
            + megaBytes + " MB and "
            + remainder + " KB");

        }
    }
}
