public class BankAccountDriver {
    public static void main(String[] args) {
        ServiceChargeChecking scc = null;
        try {
            scc = new ServiceChargeChecking("253874", "Gad Maor", "065965832", -1);
        } catch (IllegalBalanceException e) {
            System.err.printf("%n%s", e);
        }
        System.out.println(scc);
    }
}
