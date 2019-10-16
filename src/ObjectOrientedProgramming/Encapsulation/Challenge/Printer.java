package ObjectOrientedProgramming.Encapsulation.Challenge;

public class Printer {

    private int tonerLevel;
    private int numberOfPagesPrinted = 0;
    private int blankPages = 0;
    private boolean duplex = false;

    public Printer(int tonerLevel, int blankPages) {
        this(tonerLevel, blankPages, false);
    }

    public Printer(int tonerLevel, int blankPages, boolean duplex) {

        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }

        if (blankPages > 0) {
            this.blankPages = 0;
        }

        this.duplex = duplex;
    }

    public int printPage() {

        if ((this.tonerLevel <= 0) || (this.tonerLevel > 100) || (this.blankPages <= 0)) {

            System.out.println("toner level can't be lesser than 0 or greater than 100%" +
                    " or not enough blank pages, page not printed.");

            return -1;

        } else if (!isDuplex()) {

            this.numberOfPagesPrinted++;
            this.tonerLevel=-5;
            this.blankPages--;

            return this.numberOfPagesPrinted;
        }

        this.numberOfPagesPrinted++;
        this.tonerLevel=-10;
        this.blankPages--;

        return this.numberOfPagesPrinted;
    }

    public int fillToner(int inkPercentage) {

        if ((this.tonerLevel + inkPercentage < 0) || (this.tonerLevel + inkPercentage > 100)) {

            System.out.println("toner level can't be negative or greater than 100%.");

            return this.tonerLevel;
        }

        return this.tonerLevel += inkPercentage;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public void setDuplex(boolean duplex) {
        this.duplex = duplex;
    }

    public int getBlankPages() {
        return blankPages;
    }

    public void setBlankPages(int blankPages) {
        this.blankPages = blankPages;
    }
}
