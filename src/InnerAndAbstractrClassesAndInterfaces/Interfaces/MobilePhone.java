package InnerAndAbstractrClassesAndInterfaces.Interfaces;

public class MobilePhone implements ITelephone {


    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("mobile phone powered up");
    }

    @Override
    public void dial(int phoneNumber) {

        if (isOn) {
            System.out.println("Now ringing" + phoneNumber);
        } else {

            System.out.println("Phone is switched off.");
        }
    }

    @Override
    public void answer() {

        if (isRinging) {

            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn) {

            isRinging = true;
            System.out.println("melody ring");
        } else {

            isRinging = false;
            System.out.println("Mobile phone not on or invalid number");
        }

        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }

    public void setRinging(boolean ringing) {
        isRinging = ringing;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

