/** Represents a CheckingAccount with no monthly commission and a minimum allowed balance.
 *
 */
public class NoServiceChargeChecking extends CheckingAccount{

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Default minimum balance
    private static final double DEFAULT_MINIMUM_BALANCE = 500;
    // The minimum allowed balance for this NoServiceChargeChecking CheckingAccount
    private double minimumBalance;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /**
     * Creates a new NoServiceChargeChecking account with the minimum allowed balance
     * set to the DEFAULT_MINIMUM_BALANCE. Uses the CheckingAccount constructor for setting the account details.
     * @param accountNumber The CheckingAccount's accountNumber
     * @param accountOwnerName The CheckingAccount's accountownerName
     * @param accountOwnerId The CheckingAccount's accountOwnerId
     * @param balance The CheckingAccount's balance
     */
    public NoServiceChargeChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
    double balance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    /**  Creates a new ServiceChargeChecking account.
     *   Uses the CheckingAccount constructor for setting the account details.
     *
     * @param accountNumber The CheckingAccount's accountNumber
     * @param accountOwnerName The CheckingAccount's accountownerName
     * @param accountOwnerId The CheckingAccount's accountOwnerId
     * @param balance The CheckingAccount's balance
     * @param minimumBalance The minimum allowed balance for this NoServiceChargeChecking CheckingAccount
     */
    public NoServiceChargeChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                                   double balance, double minimumBalance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.minimumBalance = minimumBalance;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/
    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    /** This account type doesn't have a monthly management action associated with it
     *
     */
    public void monthlyManagement() {}

    /** Withdraws given amount from this NoServiceChargeChecking's balance
     *
     * @param amount The amount to withdraw from this BankAccount
     * @throws IllegalBalanceException if there's not enough money in this NoServiceChargeChecking to withdraw
     */
    @Override
    public void withdraw(double amount) throws IllegalBalanceException {
        double newBalance = this.getBalance() - amount;
        // Can't withdraw more than the minimum allowed balance
        if (newBalance < this.getMinimumBalance()) {
            throw new IllegalBalanceException("Insuffucuent funds! This account has a minimum allowed balance!");
        }
        else {
            this.setBalance(newBalance);
        }
    }

    /**  Writes a check(deducts amount from this account in the given amount)
     *
     * @param checkAmount The amount which to deduct from this NoServiceChargeChecking(the amount on the check)
     * @throws IllegalBalanceException if the deduction leads to a balance lower than the allowed minimum balance
     */
    @Override
    public void writeCheck (double checkAmount) throws IllegalBalanceException{
        this.withdraw(checkAmount);
    }
    /** Returns a String representation of this NoServiceChargeChecking CheckingAccount
     *
     * @return -  A String representation of this NoServiceChargeChecking CheckingAccount
     */
    @Override
    public String toString() {
        return String.format("%s %s%n%s: $%,.2f%n",
                "no service charge checking account", super.toString(), "minimum balance: ", this.getMinimumBalance());
    }

    /** Compares 2 NoServiceChargeChecking CheckingAccounts by their respective properties to check if they're equal
     *
     * @param o The NoServiceChargeChecking CheckingAccount to compare this NoServiceChargeChecking CheckingAccount to
     * @return - true if the NoServiceChargeChecking CheckingAccounts are equal and false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NoServiceChargeChecking)) {
            return false;
        }
        NoServiceChargeChecking nscc = (NoServiceChargeChecking)o;
        return  nscc.getMinimumBalance() == this.getMinimumBalance();
    }
}
