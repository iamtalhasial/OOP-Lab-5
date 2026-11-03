package banklab;

public class Utility {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("4821", "Ali", 20000.0, new double[]{1000, 2000, 500});
        accounts[1] = new BankAccount("7930", "Sana", 8000.0, new double[]{500, 500, 500});

        for (BankAccount acc : accounts) {
            acc.displayAccount();
        }

        accounts[0].withdraw(10000.0);
        accounts[1].withdraw(30000.0);

        BankAccount alias = accounts[0];
        System.out.println("Alias sees balance: " + alias.getBalance());

        System.out.println("Bank accounts created: " + BankAccount.getAccountsCreated());

        ATM atm = new ATM("ATM-01", "UCP Gate", true);
        atm.displayATM();
    }
}