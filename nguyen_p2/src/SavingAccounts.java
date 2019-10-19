import java.text.DecimalFormat;

public class SavingAccounts {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingAccounts(double balance) {
        savingsBalance = balance;
    }

    public double calculateMonthlyInterest() {
        double monthlyInterest;
        monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
        return savingsBalance;
    }

    public static void modifyInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    public static void main(String[] args) {
        SavingAccounts saver1 = new SavingAccounts(2000);
        SavingAccounts saver2 = new SavingAccounts(3000);
        DecimalFormat df = new DecimalFormat(".##");

        System.out.println("Saver 1 with balance of $2000: ");
        for (int i = 1; i <= 12; ++i) {
            SavingAccounts.modifyInterestRate(0.04);
            System.out.println("New savings balance of month " + i + ": $" + df.format(saver1.calculateMonthlyInterest()));
        }
        SavingAccounts.modifyInterestRate(0.05);
        System.out.println("New saving balance for next month after change interest rate to 5%: " + df.format(saver1.calculateMonthlyInterest()));

        System.out.println("");
        System.out.println("Saver 2 with balance of $3000: ");
        for (int i = 1; i <= 12; ++i) {
            SavingAccounts.modifyInterestRate(0.04);
            System.out.println("New savings balance of month " + i + ": $" + df.format(saver2.calculateMonthlyInterest()));
        }
        SavingAccounts.modifyInterestRate(0.05);
        System.out.println("New saving balance for next month after change interest rate to 5%: " + df.format(saver2.calculateMonthlyInterest()));
    }
}
