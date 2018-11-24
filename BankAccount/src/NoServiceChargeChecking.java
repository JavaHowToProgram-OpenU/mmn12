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
}
