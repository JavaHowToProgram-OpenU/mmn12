/** Represents a BankAccount with an interest
 *
 */
public class SavingsAccount extends BankAccount {

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
    /** Creates a new SavingsAccount BankAccount with the annual interest rate set to the DEFAULT_INTEREST_RATE.
     *  Uses the BankAccount constructor for setting the account details.
     *
     * @param accountNumber This SavingsAccount's accountNumber
     * @param accountOwnerName This SavingsAccount's accountownerName
     * @param accountOwnerId This SavingsAccount's accountOwnerId
     * @param balance This SavingsAccount's balance
     */
    public SavingsAccount(String accountNumber, String accountOwnerName, String accountOwnerId, double balance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    /** Creates a new SavingsAccount BankAccount. Uses the BankAccount constructor for setting the account details.
     *
     * @param accountNumber This SavingsAccount's accountNumber
     * @param accountOwnerName This SavingsAccount's accountownerName
     * @param accountOwnerId This SavingsAccount's accountOwnerId
     * @param balance This SavingsAccount's balance
     * @param interestRate The annual interest rate for this SavingsAccount BankAccount
     */
    public SavingsAccount(String accountNumber, String accountOwnerName,
                          String accountOwnerId, double balance, int interestRate) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
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

    /** Calculate and return the monthly interest for this SavingsAccount BankAccount
     *
     * @return - The monthly interest for this SavingsAccount BankAccount
     */
    public double getMonthlyInterest() {
        double decimalMonthlyRate = (this.getInterestRate() / 100) / 12;
        return decimalMonthlyRate * this.getBalance();
    }
    /** Runs the monthly management action to add the monthly interest
     *  to this SavingsAccount BankAccount
     *
     */
    @Override
    public void monthlyManagement() {
        this.setBalance(this.getBalance() + this.getMonthlyInterest());
    }
    
    /** Returns a String representation of this SavingsAccount BankAccount
     *
     * @return - A String representation of this SavingsAccount BankAccount
     */
    @Override
    public String toString() {
        return String.format("%s %s%n%s: %d%%%n",
                "savings account", super.toString(), "interest rate: ", this.getInterestRate());
    }

    /** Compares 2 InterestChecking NoServiceChargeChecking accounts
     *  by their respective properties to check if they're equal
     *
     * @param o The SavingsAccount BankAccount
     *          to compare this SavingsAccount BankAccount to
     * @return - true if the InterestChecking NoServiceChargeChecking accounts are equal and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SavingsAccount)) {
            return false;
        }
        else {
            if (!super.equals(o)) {
                return false;
            }
            SavingsAccount sa = (SavingsAccount) o;
            return sa.getInterestRate() == this.getInterestRate();
        }
    }
}
