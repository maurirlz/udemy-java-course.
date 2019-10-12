package ControlFlowStatements;

public class NumberToWords {
    public static void numberToWords(int num){
        if (num < 0){
            System.out.println("Invalid Value");
        } else {
            StringBuilder toWords = new StringBuilder();

            int lastDigit;
            int reverseNum = Math.abs(reverse(num));
            int leadingZeros = getDigitCount(num) - getDigitCount(reverseNum);

            while (reverseNum > 0){
                lastDigit = reverseNum % 10;
                switch (lastDigit){
                    case 0:
                        toWords.append("Zero ");
                        break;
                    case 1:
                        toWords.append("One ");
                        break;
                    case 2:
                        toWords.append("Two ");
                        break;
                    case 3:
                        toWords.append("Three ");
                        break;
                    case 4:
                        toWords.append("Four ");
                        break;
                    case 5:
                        toWords.append("Five ");
                        break;
                    case 6:
                        toWords.append("Six ");
                        break;
                    case 7:
                        toWords.append("Seven ");
                        break;
                    case 8:
                        toWords.append("Eight ");
                        break;
                    case 9:
                        toWords.append("Nine ");
                        break;
                }

                reverseNum /= 10;
            }

            for(int i = leadingZeros; i > 0; i--){
                toWords.append("Zero ");
            }
            if (num == 0){
                System.out.println("Zero");
            } else {
                System.out.println(toWords);
            }
        }
    }


    // Takes a numbers and reverses the order 1212 --> 2121 (negatives stay neg)
    public static int reverse(int num){
        int plusMinus = num < 0? -1 : 1;
        int reverseNum = 0;
        int lastDigit;
        num = Math.abs(num);

        while (num > 0){
            lastDigit = num % 10;
            reverseNum = reverseNum * 10;
            reverseNum += lastDigit;
            num /= 10;
        }
        return reverseNum * plusMinus;
    }


    // Returns the number of digits in a number 123 --> 3
    public static int getDigitCount(int num){
        if (num < 0){
            return -1;
        }
        int count = 1;

        while (num >= 10){
            count++;
            num /= 10;
        }
        return count;
    }
}

