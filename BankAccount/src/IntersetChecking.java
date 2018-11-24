/** Represents a NoServiceChargeChecking with an interest and no monthly commission
 *
 */
public class IntersetChecking extends NoServiceChargeChecking {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Default interest rate in percentage
    private static final int DEFAULT_INTEREST_RATE = 5;
    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public IntersetChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                            double balance, double minimumBalance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance, minimumBalance);
    }
}
