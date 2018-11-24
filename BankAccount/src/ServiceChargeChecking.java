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
                                 double balance) throws IllegalBalanceException {
        super(accountNumber, accountOwnerName, accountOwnerId, balance);
        this.monthlyComission = DEFAULT_MONTHLY_COMMISION;
    }
    public ServiceChargeChecking(String accountNumber, String accountOwnerName, String accountOwnerId,
                                 double balance, double monthlyComission) throws IllegalBalanceException {
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

    @Override
    public String toString(){
        return String.format("%s %s%n%s: $%,.2f",
                              "Checking Account", super.toString(), "monthly commission", this.getMonthlyComission());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BankAccount)) {
            return false;
        }
        else {
            BankAccount ba = (BankAccount)o;
            if (!ba.equals(o)) {
                return false;
            }
            ServiceChargeChecking scc = (ServiceChargeChecking)o;
            return  scc.getMonthlyComission() == this.getMonthlyComission();
        }
    }
}
