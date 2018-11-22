public abstract class BankAccount {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    private final String accountNumber;
    private final String accountOwnerName;
    private final String accountOwnerId;
    private double balance;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public BankAccount(String accountNumber, String accountOwnerName, String accountOwnerId, double balance)
            throws  IllegalBalanceException {
        this.accountNumber = accountNumber;
        this.accountOwnerName = accountOwnerName;
        this.accountOwnerId = accountOwnerId;
        if (balance < 0.0) {
            throw new IllegalBalanceException("Balance must be >= 0.0");
        }
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public String getAccountOwnerId() {
        return accountOwnerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws IllegalBalanceException {
        if (balance < 0.0) {
            throw new IllegalBalanceException("Balance must be >= 0.0");
        }
        this.balance = balance;
    }

    /** Deposits the given amount into this BankAccount's balance
     *
     * @param amount The amount to deposit to this BankAccount's balance
     */
    public void deposit(double amount) throws IllegalBalanceException {
        if (amount >= 0.0){
            setBalance(getBalance() + amount);
        }
    }
}
