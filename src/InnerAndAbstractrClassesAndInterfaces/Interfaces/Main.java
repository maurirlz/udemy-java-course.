package InnerAndAbstractrClassesAndInterfaces.Interfaces;

public class Main {

    public static void main(String[] args) {

        ITelephone timsPhone;
        timsPhone = new DeskPhone(123465);
        timsPhone.powerOn();
        timsPhone.callPhone(123465);
        timsPhone.answer();

        timsPhone = new MobilePhone(24565);
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();


    }
}
