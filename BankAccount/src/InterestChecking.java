/** Represents a NoServiceChargeChecking with an interest and no monthly commission
 *  mmn12-2
 *  * @author Gad Maor
 *  * @version 1.0
 */
public class InterestChecking extends NoServiceChargeChecking {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Default annual interest rate in percentage
    private static final int DEFAULT_INTEREST_RATE = 5;
    // Annual interest rate in percentage
    private int interestRate;
    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /** Creates a new InterestChecking account with the annual interest rate set to the DEFAULT_INTEREST_RATE.
     *  Uses the NoServiceChargeChecking constructor for setting the account details.
     *
     * @param accountNumber The InterestChecking's accountNumber
     * @param accountOwnerName The InterestChecking's accountownerName
     * @param accountOwnerId The InterestChecking's accountOwnerId
     * @param balance The InterestChecking's balance
     * @param minimumBalance The minimum allowed balance for this InterestChecking NoServiceChargeChecking
     */
    public InterestChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                            double balance, double minimumBalance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance, minimumBalance);
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    /** Creates a new InterestChecking account.
     *  Uses the NoServiceChargeChecking constructor for setting the account details.
     *
     * @param accountNumber The InterestChecking's accountNumber
     * @param accountOwnerName The InterestChecking's accountownerName
     * @param accountOwnerId The InterestChecking's accountOwnerId
     * @param balance The InterestChecking's balance
     * @param minimumBalance The minimum allowed balance for this InterestChecking NoServiceChargeChecking
     * @param interestRate The annual interest rate for this InterestChecking NoServiceChargeChecking account
     */
    public InterestChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                            double balance, double minimumBalance, int interestRate) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance, minimumBalance);
        this.interestRate = interestRate;
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/
    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    /** Calculate and return the monthly interest for this InterestChecking NoServiceChargeChecking account
     *
     * @return - The monthly interest for this InterestChecking NoServiceChargeChecking account
     */
    public double getMonthlyInterest() {
        double decimalMonthlyRate = ((double) this.getInterestRate() / 100) / 12;
        return decimalMonthlyRate * this.getBalance();
    }

    /** Runs the monthly management action to add the monthly interest
     *  to this InterestChecking NoServiceChargeChecking account
     *
     */
    @Override
    public void monthlyManagement() {
        this.setBalance(this.getBalance() + this.getMonthlyInterest());
    }

    /** Returns a String representation of this InterestChecking NoServiceChargeChecking account
     *
     * @return - A String representation of this InterestChecking NoServiceChargeChecking account
     */
    @Override
    public String toString() {
        return String.format("%s %s%s: %d%%%n",
                "interest checking", super.toString(), "annual interest rate: ", this.getInterestRate());
    }

    /** Compares 2 InterestChecking NoServiceChargeChecking accounts
     *  by their respective properties to check if they're equal
     *
     * @param o The InterestChecking NoServiceChargeChecking account
     *          to compare this InterestChecking NoServiceChargeChecking account to
     * @return - true if the InterestChecking NoServiceChargeChecking accounts are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InterestChecking)) {
            return false;
        }
        else {
            if (!super.equals(o)) {
                return false;
            }
            InterestChecking ic = (InterestChecking) o;
            return ic.getInterestRate() == this.getInterestRate();
        }
    }
}
