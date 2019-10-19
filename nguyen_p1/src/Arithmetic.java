import java.security.SecureRandom;
import java.util.Scanner;

public class Arithmetic {

    public static double randQuestion(SecureRandom rand, int level, int type) {
        int num1, num2, mixType;
        double result;

        if (level == 1) {
            num1 = rand.nextInt(9) + 1;
            num2 = rand.nextInt(9) + 1;
        }
        else if (level == 2)
        {
            num1 = rand.nextInt(90) + 10;
            num2 = rand.nextInt(90) + 10;
        }
        else if (level == 3) {
            num1 = rand.nextInt(900) + 100;
            num2 = rand.nextInt(900) + 100;
        }
        else {
            num1 = rand.nextInt(9000) + 1000;
            num2 = rand.nextInt(9000) + 1000;
        }

        if (type == 1) {
            System.out.print("How much is " + num1 + " plus " + num2 + "? ");
            return num1 + num2;
        }
        else if (type == 2) {
            System.out.print("How much is " + num1 + " times " + num2 + "? ");
            return num1 * num2;
        }
        else if (type == 3) {
            System.out.print("How much is " + num1 + " minus " + num2 + "? ");
            return num1 - num2;
        }
        else if (type == 4) {
            System.out.print("How much is " + num1 + " divided by " + num2 + " (round up to 1 decimal place)? ");
            result = Math.round(((double)(num1) / num2) * 10) / 10.0;
            return result;
        }
        else {
            mixType = rand.nextInt(4) + 1;
            if (mixType == 1) {
                System.out.print("How much is " + num1 + " plus " + num2 + "? ");
                return num1 + num2;
            }
            else if (mixType == 2) {
                System.out.print("How much is " + num1 + " times " + num2 + "? ");
                return num1 * num2;
            }
            else if (mixType == 3) {
                System.out.print("How much is " + num1 + " minus " + num2 + "? ");
                return num1 - num2;
            }
            else {
                System.out.print("How much is " + num1 + " divided by " + num2 + " (round up to 1 decimal place)? ");
                result = Math.round(((double)(num1) / num2) * 10) / 10.0;
                return result;
            }
        }
    }

    public static String rightAns(SecureRandom rand) {
        int ranNum;
        ranNum = rand.nextInt(4) + 1;

        switch (ranNum) {
            case 1:
                return "Very good!";
            case 2:
                return "Excellent";
            case 3:
                return "Nice work!";
            default:
                return "Keep up the good work!";
        }
    }

    public static String wrongAns(SecureRandom rand) {
        int ranNum;
        ranNum = rand.nextInt(4) + 1;

        switch (ranNum) {
            case 1:
                return "No. Please try again.";
            case 2:
                return "Wrong. Try once more.";
            case 3:
                return "Don't give up!";
            default:
                return "No. Keep trying.";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();

        double result, ans;
        char c;
        int difLevel, typeQues;

        System.out.print("Press a for answering 10 questions or press e for exiting the program: ");
        c = scan.next().charAt(0);

        while (c != 'e') {

            if (c == 'a') {
                int countAns = 0;

                System.out.print("Please enter a difficulty level (1-4): ");
                difLevel = scan.nextInt();
                while (difLevel < 1 || difLevel > 4)
                {
                    System.out.print("Sorry! We don't have that level. Only from 1 to 4: ");
                    difLevel = scan.nextInt();
                }

                System.out.println("Type of arithmetic problem: ");
                System.out.println("1: Addition");
                System.out.println("2: Multiplication");
                System.out.println("3: Subtraction");
                System.out.println("4: Division");
                System.out.println("5: A random mixture of all these types");
                System.out.print("Please pick a number: ");
                typeQues = scan.nextInt();
                while (typeQues < 1 || typeQues > 5)
                {
                    System.out.print("Sorry! We don't have this type of problem. Only from 1 to 5: ");
                    typeQues = scan.nextInt();
                }

                for (int i = 1; i <= 10; ++i) {
                    System.out.println("Question number " + i + ":");
                    result = randQuestion(rand, difLevel, typeQues);
                    ans = scan.nextDouble();
                    if (ans == result) {
                        System.out.println(rightAns(rand));
                        countAns++;
                    } else
                        System.out.println(wrongAns(rand));
                }

                System.out.println("You answered " + countAns + " questions correctly and " + (10 - countAns) + " questions incorrectly.");

                if (countAns > 7) {
                    System.out.println("Congratulations, you are ready to go to the next level!");
                }
                else {
                    System.out.println("Please ask your teacher for extra help.");
                }

                System.out.print("Press a for answering 10 questions or press e for exiting the program: ");
                c = scan.next().charAt(0);
            }
            else {
                System.out.print("No! Only a or e: ");
                c = scan.next().charAt(0);
            }
        }
    }
}
