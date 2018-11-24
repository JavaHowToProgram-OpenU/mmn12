/** Represents a CheckingAccount which charges a monthly commission for managing the account.
 *
 */
public class ServiceChargeChecking extends CheckingAccount {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Default monthly commission, if not set by constructor is 5 dollars
    private static final double DEFAULT_MONTHLY_COMMISION = 5;
    // The monthly commission for this ServiceChargeChecking CheckingAccount
    private double monthlyComission;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /** Creates a new ServiceChargeChecking account with the commission set to the DEFAULT_MONTHLY_COMMISION.
     * Uses the CheckingAccount constructor for setting the account details.
     *
     * @param accountNumber The CheckingAccount's accountNumber
     * @param accountOwnerName The CheckingAccount's accountownerName
     * @param accountOwnerId The CheckingAccount's accountOwnerId
     * @param balance The CheckingAccount's balance
     */
    public ServiceChargeChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                                 double balance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.monthlyComission = DEFAULT_MONTHLY_COMMISION;
    }

    /** Creates a new ServiceChargeChecking account. Uses the CheckingAccount constructor for setting the account details.
     *
     * @param accountNumber The CheckingAccount's accountNumber
     * @param accountOwnerName The CheckingAccount's accountownerName
     * @param accountOwnerId The CheckingAccount's accountOwnerId
     * @param balance The CheckingAccount's balance
     * @param monthlyComission The monthly commission for this ServiceChargeChecking CheckingAccount
     */
    public ServiceChargeChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                                 double balance, double monthlyComission) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.monthlyComission = monthlyComission;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/
    public double getMonthlyComission() {
        return monthlyComission;
    }

    public void setMonthlyComission(double monthlyComission) {
        this.monthlyComission = monthlyComission;
    }

    /** Charges this ServiceChargeChecking CheckingAccount with the currently set monthly commission
     *
     */
    @Override
    public void monthlyManagement() {
        this.setBalance(this.getBalance() - this.getMonthlyComission());
    }

    /** Returns a String representation of this ServiceChargeChecking CheckingAccount
     *
     * @return A String representation of this ServiceChargeChecking CheckingAccount
     */
    @Override
    public String toString(){
        return String.format("%s %s%n%s: $%,.2f%n",
                              "service charge checking account", super.toString(), "monthly commission: ", this.getMonthlyComission());
    }

    /** Compares 2 ServiceChargeChecking CheckingAccounts by their respective properties to check if they're equal
     *
     * @param o The ServiceChargeChecking CheckingAccount to compare this ServiceChargeChecking CheckingAccount to
     * @return - true if the ServiceChargeChecking BankAccounts are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ServiceChargeChecking)) {
            return false;
        }
        else {
            if (!super.equals(o)) {
                return false;
            }
            ServiceChargeChecking scc = (ServiceChargeChecking)o;
            return  scc.getMonthlyComission() == this.getMonthlyComission();
        }
    }
}
