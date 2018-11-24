public class BankAccountDriver {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];

        accounts[0] = new ServiceChargeChecking("748596", "James Bienstock", "678154962", 12000);
        accounts[1] = new NoServiceChargeChecking("958613", "Demodard Galadriad", "348591765", 5000, 1500);
        accounts[2] = new InterestChecking("916348", "John Whatshisface", "894535781", 300);
        accounts[3] = new SavingsAccount("593485", "Jane Cookie-Dough", "251385496", 2200, 10);
        accounts[4] = new HighInterestSavings("693258", "Johnnie Mnemonic", "546813759", 3000, 500);

        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
}
