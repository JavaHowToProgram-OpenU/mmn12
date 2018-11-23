/** Represents a BankAccount, holding a specific balance.
 *
 */
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
    /** Create a new BankAccount object
     *
     * @param accountNumber This BankAccount's accountNumber
     * @param accountOwnerName This BankAccount's accountownerName
     * @param accountOwnerId This BankAccount's accountOwnerId
     * @param balance This BankAccount's balance
     * @throws IllegalBalanceException if balance < 0.0
     */
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

    /******************************************************
     *                      Methods                       *
     *****************************************************/
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

    /** Setter method for balance
     *
     * @param balance The balance to which to set this BankAccount's balance
     * @throws IllegalBalanceException if balance < 0.0
     */
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
    public void deposit(double amount) {
        if (amount >= 0.0){
            this.setBalance(this.getBalance() + amount);
        }
    }

    /** Withdraws given amount from this BankAccount's balance
     *
     * @param amount The amount to withdraw from this BankAccount
     * @throws IllegalBalanceException if there's not enough money in this BankAccount to withdraw
     */
    public void withdraw(double amount) throws IllegalBalanceException {
        // Not enough money in balance - throw IllegalBalanceException
        if (amount > this.getBalance()){
            throw new IllegalBalanceException("Insufficient funds for withdrawl in account!");
        }
        else if (amount >= 0.0) {
            this.setBalance(this.getBalance() - amount);
        }
    }

    /** Method for monthly management activities of a BankAccount object type.
     *  Must be implemented by all extending subclasses.
     *
     */
    public abstract monthlyManagement(){};

    /** Returns a String representation of this BankAccount object
     *
     * @return This BankAccount in String form
     */
    @Override
    public String toString() {
        return String.format("number: %s%nAccount Owner: %s%nOwner ID: %s%nbalance: $%,.2f",
                        getAccountNumber(), getAccountOwnerName(),
                        getAccountOwnerId(), getBalance());
    }

    /** Compares 2 BankAccounts by their respective properties
     *
     * @param o The BankAccount to compare this BankAccount to
     * @return - true if the BankAccounts are equal and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BankAccount)) {
            return false;
        }
        else {
            BankAccount ba = (BankAccount)o;
            return ba.getBalance() == this.getBalance() &&
                   ba.getAccountNumber() == this.getAccountNumber() &&
                   ba.getAccountOwnerId() == this.getAccountOwnerId() &&
                   ba.getAccountOwnerName() == this.getAccountOwnerName();
        }
    }
}
