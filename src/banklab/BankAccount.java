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
        this.balance = (balance >= 0) ? balance : 0;
        this.recentDeposits = new double[3];
        for (int i = 0; i < 3; i++) {
            this.recentDeposits[i] = (deposits != null && deposits[i] > 0) ? deposits[i] : 0;
        }
        accountsCreated++;
    }

    public BankAccount(BankAccount other) {
        this.accountNo = other.accountNo;
        this.holderName = other.holderName;
        this.balance = other.balance;
        this.recentDeposits = other.recentDeposits;
        accountsCreated++;
    }

    public BankAccount(BankAccount other, boolean deep) {
        this.accountNo = other.accountNo;
        this.holderName = other.holderName;
        this.balance = other.balance;
        if (deep) {
            this.recentDeposits = new double[other.recentDeposits.length];
            for (int i = 0; i < other.recentDeposits.length; i++) {
                this.recentDeposits[i] = other.recentDeposits[i];
            }
        } else {
            this.recentDeposits = other.recentDeposits;
        }
        accountsCreated++;
    }

    public double getBalance() { return balance; }

    public void updateDepositHistory(int index, double amount) {
        if (index >= 0 && index < 3 && amount > 0) {
            recentDeposits[index] = amount;
        } else {
            System.out.println("Invalid deposit amount or index.");
        }
    }

    public double calculateTotalRecentDeposits() {
        double sum = 0;
        for (double d : recentDeposits) sum += d;
        return sum;
    }

    public void transferTo(BankAccount receiver, double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Transfer rejected: insufficient balance.");
        } else if (receiver != null) {
            this.balance -= amount;
            receiver.balance += amount;
        }
    }

    public BankAccount getRicherAccount(BankAccount other) {
        if (other == null || this.balance >= other.balance) return this;
        return other;
    }

    public void displayAccount() {
        System.out.println(accountNo + " | " + holderName + " | Balance: " + balance);
    }

    public static int getAccountsCreated() { return accountsCreated; }
}