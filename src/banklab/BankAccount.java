package banklab;

public class BankAccount {
    private final String accountNo;
    private String holderName;
    private double balance;
    private double[] recentDeposits;
    private static int accountsCreated = 0;

    public BankAccount(String accNo, String holderName, double balance, double[] deposits) {
        this.accountNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
        this.recentDeposits = new double[3];
        for (int i = 0; i < 3; i++) {
            this.recentDeposits[i] = (deposits[i] > 0) ? deposits[i] : 0;
        }
        accountsCreated++;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    public double calculateTotalRecentDeposits() {
        double sum = 0;
        for (double d : recentDeposits) {
            sum += d;
        }
        return sum;
    }

    public void displayAccount() {
        System.out.println(accountNo + " | " + holderName + " | Balance: " + balance + " | Recent deposits: " + calculateTotalRecentDeposits());
    }

    public static int getAccountsCreated() { return accountsCreated; }
}