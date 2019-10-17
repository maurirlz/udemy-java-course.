package ObjectOrientedProgramming.MasterChallenge;

public class DeluxeBurger extends Burger {

    private static final double DEFAULT_DELUXEBURGER_PRICE = 18.50;

    private boolean chips = true;
    private boolean drink = true;

    public DeluxeBurger(String burguerName, double price, boolean chips, boolean drink) {
        super("DELUXE","NORMAL","BEEF", price);
        this.chips = chips;
        this.drink = drink;
    }

    public DeluxeBurger(String burguerName, String rollType, String meat, double price, boolean chips, boolean drink) {
        super("DELUXE", rollType.toUpperCase(), meat.toUpperCase(), price);
        this.chips = chips;
        this.drink = drink;
    }

    public boolean isChips() {
        return chips;
    }

    public void setChips(boolean chips) {
        this.chips = chips;
    }

    public boolean isDrink() {
        return drink;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    @Override
    public double showTotalPrice() {
        return super.showTotalPrice();
    }

    @Override
    public String getBurguerName() {
        return super.getBurguerName().toUpperCase();
    }

    @Override
    public String getRollType() {
        return super.getRollType().toUpperCase();
    }

    @Override
    public String getMeat() {
        return super.getMeat().toUpperCase();
    }

    @Override
    public double getPrice() {
        if (super.getPrice()  <= 0) {
            super.setPrice(DEFAULT_DELUXEBURGER_PRICE);
        }
        return super.getPrice();
    }

    @Override
    public boolean isLettuce() {
        return false;
    }

    @Override
    public boolean isTomato() {
        return false;
    }

    @Override
    public boolean isBacon() {
        return false;
    }

    @Override
    public boolean isPickles() {
        return false;
    }

    @Override
    public void setBurguerName(String burguerName) {
        super.setBurguerName(burguerName.toUpperCase());
    }

    @Override
    public void setRollType(String rollType) {
        super.setRollType(rollType.toUpperCase());
    }

    @Override
    public void setMeat(String meat) {
        super.setMeat(meat.toUpperCase());
    }

    @Override
    public void setPrice(double price) {
        if (price < DEFAULT_DELUXEBURGER_PRICE) {
            System.out.println("Price is less than the base deluxe burger price, setting price to default. (" + DEFAULT_DELUXEBURGER_PRICE +")");
            price = DEFAULT_DELUXEBURGER_PRICE;
        }
        super.setPrice(price);
    }
}
