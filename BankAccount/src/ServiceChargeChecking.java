public class ServiceChargeChecking extends CheckingAccount {

    /******************************************************
     *                      Fields                        *
     *****************************************************/
    // Default monthly commission, if not set by constructor is 5 dollars
    private static final double DEFAULT_MONTHLY_COMMISION = 5;
    private double monthlyComission;

    /******************************************************
     *                      Constructors                  *
     *****************************************************/
    public ServiceChargeChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                                 double balance) {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.monthlyComission = DEFAULT_MONTHLY_COMMISION;
    }
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

    @Override
    public void monthlyManagement() throws IllegalBalanceException {
        this.setBalance(this.getBalance() - this.getMonthlyComission());
    }
}
