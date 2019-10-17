package ObjectOrientedProgramming.MasterChallenge;

public class Burger {
    
    private final static double DEFAULT_BURGER_PRICE = 13.30d;
    protected final static double LETTUCE_PRICING = 0.50d;
    protected final static double TOMATO_PRICING = 0.60d;
    protected final static double BACON_PRICING = 0.90d;
    protected final static double PICKLES_PRICING = 0.70d;

    private String burguerName;
    private String rollType;
    private String meat;
    private double price;
    private boolean lettuce;
    private boolean tomato;
    private boolean bacon;
    private boolean pickles;


    public Burger(String burguerName, double price) {
        this(burguerName,"NORMAL","BEEF",price);
    }

    public Burger(String burguerName, String rollType, String meat, double price) {

        this.burguerName = burguerName.toUpperCase();

        this.rollType = rollType.toUpperCase();

        if ((meat.compareToIgnoreCase("CHICKEN") == 0) || (meat.compareToIgnoreCase("BEEF") == 0) || (meat.compareToIgnoreCase("VEGGIE") == 0)) {

            this.meat = meat.toUpperCase();
        } else {

            System.out.println("Selected meat is invalid or unavailable, setting your meat to default (beef)");
            this.meat = "BEEF";
        }
        if (price > 0) {

            this.price = price;
        } else {

            System.out.println("Price less than or equal to 0, setting default burguer price.");
            this.price = 10.00d;
        }
    }

    public double showTotalPrice() {
        return this.price;
    }
    @Deprecated
    /*public void addAdditionPrice(double additionPrice) {
        this.price += additionPrice;
    }
    */
    public static double getLettucePricing() {
        return LETTUCE_PRICING;
    }

    public static double getTomatoPricing() {
        return TOMATO_PRICING;
    }

    public static double getBaconPricing() {
        return BACON_PRICING;
    }

    public static double getPicklesPricing() {
        return PICKLES_PRICING;
    }

    public String getBurguerName() {
        return burguerName.toUpperCase();
    }

    public String getRollType() {
        return rollType.toUpperCase();
    }

    public String getMeat() {
        return meat.toUpperCase();
    }

    public double getPrice() {
        if (price  <= 0) {
            price = DEFAULT_BURGER_PRICE;
        }
        return price;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isBacon() {
        return bacon;
    }

    public boolean isPickles() {
        return pickles;
    }

    public void setBurguerName(String burguerName) {
        this.burguerName = burguerName.toUpperCase();
    }

    public void setRollType(String rollType) {
        this.rollType = rollType.toUpperCase();
    }

    public void setMeat(String meat) {
        this.meat = meat.toUpperCase();
    }

    public void setPrice(double price) {
        if (price < DEFAULT_BURGER_PRICE) {
            System.out.println("Price is less than the base burger price, setting price to default. (" + DEFAULT_BURGER_PRICE +")");
            price = DEFAULT_BURGER_PRICE;
        }
        this.price = price;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public void setBacon(boolean bacon) {
        this.bacon = bacon;
    }

    public void setPickles(boolean pickles) {
        this.pickles = pickles;
    }

}
