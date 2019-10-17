package ObjectOrientedProgramming.MasterChallenge;

public class HealthyBurger extends Burger {

    private static final double DEFAULT_HEALTHYBURGER_PRICE = 15.50d;

    public HealthyBurger(String burguerName, double price) {
        super(burguerName, price);
    }

    public HealthyBurger(String burguerName, String rollType, String meat, double price) {
        super(burguerName, rollType, meat, price);
    }

    @Override
    public double showTotalPrice() {
        return super.showTotalPrice();
    }

    @Override
    public void addAdditionPrice(double additionPrice) {
        super.addAdditionPrice(additionPrice);
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
            super.setPrice(DEFAULT_HEALTHYBURGER_PRICE);
        }
        return super.getPrice();
    }

    @Override
    public boolean isLettuce() {
        return super.isLettuce();
    }

    @Override
    public boolean isTomato() {
        return super.isTomato();
    }

    @Override
    public boolean isBacon() {
        return super.isBacon();
    }

    @Override
    public boolean isPickles() {
        return super.isPickles();
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
        if (price < DEFAULT_HEALTHYBURGER_PRICE) {
            System.out.println("Price is less than the base healthy burger price, setting price to default. (" + DEFAULT_HEALTHYBURGER_PRICE +")");
            price = DEFAULT_HEALTHYBURGER_PRICE;
        }
        super.setPrice(price);
    }

    @Override
    public void setLettuce(boolean lettuce) {
        super.setLettuce(lettuce);
    }

    @Override
    public void setTomato(boolean tomato) {
        super.setTomato(tomato);
    }

    @Override
    public void setBacon(boolean bacon) {
        super.setBacon(bacon);
    }

    @Override
    public void setPickles(boolean pickles) {
        super.setPickles(pickles);
    }
}

