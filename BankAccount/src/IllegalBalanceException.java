/** Represents an Exception caused by overdraw of a BankAccount
 *
 */
public class IllegalBalanceException extends Exception {
    public IllegalBalanceException() {
        super();
    }
    public IllegalBalanceException(String s) {
        super(s);
    }
}
