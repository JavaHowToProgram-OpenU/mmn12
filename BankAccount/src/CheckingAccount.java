/** Represents a BankAccount with the ability to write checks
* mmn12-2
* @author Gad Maor
* @version 1.0
 *
 */
public abstract class CheckingAccount extends BankAccount {

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    /** Creates a new CheckingAccount BankAccount.
     *  Uses the BankAccount constructor for setting the account details.
     *
     * @param accountNumber This CheckingAccount's accountNumber
     * @param accountOwnerName This CheckingAccount's accountownerName
     * @param accountOwnerId This CheckingAccount's accountOwnerId
     * @param balance This CheckingAccount's balance
     */
    public CheckingAccount(String accountNumber, String accountOwnerName, String accountOwnerId, double balance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
    }

    /******************************************************
     *                      Methods                       *
     *****************************************************/

    /** Writes a check(deducts amount from this account in the given amount)
     *
     * @param checkAmount The amount which to deduct from this CheckingAccount(the amount on the check)
     * @throws IllegalBalanceException if the check's amount is higher than this CheckingAccount's balance
     */
    public void writeCheck(double checkAmount) throws IllegalBalanceException{
        if (checkAmount > this.getBalance()) {
            throw new IllegalBalanceException("Check bounced. Insufficient funds in account!");
        }
        else {
            this.setBalance(this.getBalance() - checkAmount);
        }
    }
}
