package SavingsAccount;

public class SavingsAccount {
    private static double annualInterestRate = 0;
    private double savingsBalance;
    
    private SavingsAccount(double balance){
        savingsBalance = balance;
    }
    
    public void calculateMonthlyInterest(){
        savingsBalance += ((savingsBalance * annualInterestRate) / 12);
    }
    
    public static void setInterestRate(double newRate){
        annualInterestRate = (newRate >= 0 && newRate <= 1)
                ?newRate:0.04;
    }
    
    @Override
    public String toString(){
        return String.format("$%.2f", savingsBalance);
    }
    
    public static void main(String args[]){
        /* Sets the balance of two savings accounts as well as the interest rate. */
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.setInterestRate(0.04);
        System.out.println("Savings Account Balances");
        System.out.printf("%-10s%10s%10s\n", "Month", "Saver1", "Saver2");
        /* Calculates interest over 12 months. */
        for(int month = 1; month <= 12; month++){
            String monthNum = Integer.toString(month);
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("%-10s%10s%10s\n", monthNum, saver1.toString(),
                    saver2.toString());
        }
        /* Resets the interest rate to 5% and calculates month 13. */
        SavingsAccount.setInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("%-10s%10s%10s\n", "13", saver1.toString(), saver2.toString());
    }
}