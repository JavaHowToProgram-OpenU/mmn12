/** Represents a SavingsAccount with an interest and a minimum allowed balance
 *  mmn12-2
 *  * @author Gad Maor
 *  * @version 1.0
 */
public class HighInterestSavings extends SavingsAccount {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Default minimum balance
    private static final double DEFAULT_MINIMUM_BALANCE = 1000;
    // The minimum allowed balance for this HighInterestSavings SavingsAccount
    private double minimumBalance;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /**
     * Creates a new HighInterestSavings account with the minimum allowed balance
     * set to the DEFAULT_MINIMUM_BALANCE. Uses the SavingsAccount constructor for setting the account details.
     *
     * @param accountNumber    This HighInterestSavings's accountNumber
     * @param accountOwnerName This HighInterestSavings's accountownerName
     * @param accountOwnerId   This HighInterestSavings's accountOwnerId
     * @param balance          This HighInterestSavings's balance
     * @param interestRate     The annual interest rate for this HighInterestSavings BankAccount
     */
    public HighInterestSavings(String accountNumber, String accountOwnerName,
                               String accountOwnerId, double balance, int interestRate) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance, interestRate);
        this.minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    /**
     * Creates a new HighInterestSavings account. Uses the SavingsAccount constructor for setting the account details.
     *
     * @param accountNumber    This HighInterestSavings's accountNumber
     * @param accountOwnerName This HighInterestSavings's accountownerName
     * @param accountOwnerId   This HighInterestSavings's accountOwnerId
     * @param balance          This HighInterestSavings's balance
     * @param interestRate     The annual interest rate for this HighInterestSavings BankAccount
     * @param minimumBalance   The minimum allowed balance for this HighInterestSavings SavingsAccount
     */
    public HighInterestSavings(String accountNumber, String accountOwnerName,
                               String accountOwnerId, double balance,
                               int interestRate, double minimumBalance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance, interestRate);
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

    /** Withdraws given amount from this HighInterestSavings SavingsAccount's balance
     *
     * @param amount The amount to withdraw from this HighInterestSavings SavingsAccount's balance
     * @throws IllegalBalanceException if there's not enough money in this HighInterestSavings
     *         SavingsAccount to withdraw
     */
    @Override
    public void withdraw(double amount) throws IllegalBalanceException {
        double newBalance = this.getBalance() - amount;
        // Can't withdraw more than the minimum allowed balance
        if (newBalance < this.getMinimumBalance()) {
            throw new IllegalBalanceException("Insufficent funds! This account has a minimum allowed balance!");
        }
        else {
            this.setBalance(newBalance);
        }
    }
    /** Returns a String representation of this HighInterestSavings SavingsAccount
     *
     * @return -  A String representation of this HighInterestSavings SavingsAccount
     */
    @Override
    public String toString() {
        return String.format("%s %s%s: $%,.2f%n",
                "high interest savings account", super.toString(), "minimum balance: ", this.getMinimumBalance());
    }

    /** Compares 2 NoServiceChargeChecking CheckingAccounts by their respective properties to check if they're equal
     *
     * @param o The HighInterestSavings SavingsAccount to compare this HighInterestSavings SavingsAccount to
     * @return - true if the HighInterestSavings SavingsAccount are equal and false otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HighInterestSavings)) {
            return false;
        }
        else {
            if (!super.equals(o)) {
                return false;
            }
            HighInterestSavings his = (HighInterestSavings) o;
            return his.getMinimumBalance() == this.getMinimumBalance();
        }
    }
}