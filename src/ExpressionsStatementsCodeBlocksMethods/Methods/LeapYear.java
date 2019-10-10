package ExpressionsStatementsCodeBlocksMethods.Methods;

public class LeapYear {
    public static void main(String[] args) {
        int year = 1924;
        int firstStep = year % 4;
        int secondStep = year % 100;
        int thirdStep = year % 400;
        System.out.println(isLeapYear(year));
    }
    public static boolean isLeapYear(int year) {
        if  (year >= 1 && year <= 9999){
            return ((year % 400) == 0) || (((year % 100) != 0) && ((year % 4) == 0));
        }
        return false;
    }

}
