
public abstract class CheckingAccount extends BankAccount {

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
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
