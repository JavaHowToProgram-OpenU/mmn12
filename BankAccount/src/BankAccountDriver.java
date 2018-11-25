/**
 *  mmn12-2
 *  * @author Gad Maor
 *  * @version 1.0
 */
public class BankAccountDriver {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];

        accounts[0] = new ServiceChargeChecking("748596", "James Bienstock", "678154962", 12000);
        accounts[1] = new NoServiceChargeChecking("958613", "Demodard Galadriad", "348591765", 5000, 1500);
        accounts[2] = new InterestChecking("916348", "John Whatshisface", "894535781", 3000, 300);
        accounts[3] = new SavingsAccount("593485", "Jane Cookie-Dough", "251385496", 2200, 10);
        accounts[4] = new HighInterestSavings("693258", "Johnnie Mnemonic", "546813759", 3000, 50);

        for (BankAccount account : accounts) {
            System.out.printf("%s%n%n%n",account);
        }
        // Running various actions on the accounts
        System.out.println("Depositing 2000 dollars to ServiceChargeChecking account.");
        accounts[0].deposit(2000);
        System.out.println("ServiceChargeChecking account after deposit:");
        System.out.println(accounts[0]);
        try {
            System.out.println("Writing a 4000$ check to withdraw from NoServiceChargeChecking account.");
            ((NoServiceChargeChecking) accounts[1]).writeCheck(4000);
        } catch (IllegalBalanceException e) {
            System.err.printf("%nException %s%n%n", e);
        } finally {
            System.out.println("NoServiceChargeChecking account after check processing:");
            System.out.println(accounts[1]);
        }
        try {
            System.out.println("Withdrawing 2000$ from InterestChecking account");
            accounts[2].withdraw(2000);
        } catch (IllegalBalanceException e) {
            System.err.printf("%nException %s%n%n", e);
        } finally {
            System.out.println("InterestChecking account after withdrawal");
            System.out.println(accounts[2]);
        }
        try {
            System.out.println("Withdrawing 2500$ from SavingsAccount account");
            accounts[3].withdraw(2500);
        } catch (IllegalBalanceException e) {
            System.err.printf("%nException %s%n%n", e);
        } finally {
            System.out.println("SavingsAccount account after withdrawal:");
            System.out.println(accounts[3]);
        }
        System.out.println("Deposit 1000$ to HighInterestSavings account");
        accounts[4].deposit(1000);
        System.out.println("HighInterestSavings account after deposit:");
        System.out.println(accounts[4]);

        // Running monthly management actions on all accounts
        for (BankAccount account : accounts) {
            try {
                System.out.println("Running monthly management task on " + account.getClass().getName() + " account...");
                account.monthlyManagement();
                System.out.println("Account" + account.getClass().getName() + " after monthly management task:");
                System.out.println(account);
            } catch (IllegalBalanceException e) {
                System.err.printf("%nException %s%n%n", e);
            }
        }
    }
}
