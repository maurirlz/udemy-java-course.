package ObjectOrientedProgramming.Classes;

public class VipCustomerChallenge {

    private String vipCustomerName;
    private double vipCustomerCreditLimit;
    private String vipCustomerEmail;

    public VipCustomerChallenge() {
        this("Mauricio Benitez",20000,"mauribenitez95@gmail.com");
    }

    public VipCustomerChallenge(String vipCustomerName, String vipCustomerEmail) {
        this(vipCustomerName,40000,vipCustomerEmail);
        this.vipCustomerName = vipCustomerName;
        this.vipCustomerEmail = vipCustomerEmail;
    }

    public VipCustomerChallenge(String vipCustomerName, double vipCustomerCreditLimit, String vipCustomerEmail) {
        this.vipCustomerName = vipCustomerName;
        this.vipCustomerCreditLimit = vipCustomerCreditLimit;
        this.vipCustomerEmail = vipCustomerEmail;
    }

    public String getVipCustomerChallengeName() {
        return vipCustomerName;
    }

    public double getVipCustomerChallengeCreditLimit() {
        return vipCustomerCreditLimit;
    }

    public String getVipCustomerChallengeEmail() {
        return vipCustomerEmail;
    }
}
