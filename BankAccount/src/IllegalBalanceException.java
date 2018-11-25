/** Represents an Exception caused by overdraw of a BankAccount
* mmn12-2
* @author Gad Maor
* @version 1.0
 */
public class IllegalBalanceException extends Exception {
    public IllegalBalanceException() {
        super();
    }
    public IllegalBalanceException(String s) {
        super(s);
    }
}
