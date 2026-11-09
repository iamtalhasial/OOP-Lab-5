package banklab;

public class Utility {
    public static void main(String[] args) {
        BankAccount ali = new BankAccount("4821", "Ali", 20000.0, new double[]{1000, 2000, 500});
        BankAccount sana = new BankAccount("7930", "Sana", 8000.0, new double[]{500, 500, 500});

        BankAccount shallow = new BankAccount(ali);
        BankAccount deep = new BankAccount(ali, true);

        ali.updateDepositHistory(0, 1500);

        System.out.println("Ali recent deposits: " + ali.calculateTotalRecentDeposits());
        System.out.println("Shallow: " + shallow.calculateTotalRecentDeposits() + " | Deep: " + deep.calculateTotalRecentDeposits());

        ali.transferTo(sana, 2000.0);
        System.out.println("After transfer | Ali: " + ali.getBalance() + " | Sana: " + sana.getBalance());

        ali.transferTo(sana, 30000.0); // Rejected transfer

        BankAccount richer = ali.getRicherAccount(sana);
        System.out.println("Richer account: " + (richer == ali ? "4821" : "7930"));

        System.out.println("BankAccount objects: " + BankAccount.getAccountsCreated());

        ATM atm = new ATM("ATM-01", "UCP Gate", true);
        atm.displayATM();
    }
}