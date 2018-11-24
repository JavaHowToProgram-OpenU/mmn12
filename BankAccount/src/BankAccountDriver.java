public class BankAccountDriver {
    public static void main(String[] args) {
        ServiceChargeChecking scc = new ServiceChargeChecking("253874", "Gad Maor", "065965832", 21537);
        System.out.println(scc);
        ServiceChargeChecking scc2 = new ServiceChargeChecking("253874", "Gad Maor", "065965832", 21537, 5);
        System.out.println(scc2);
        System.out.println(scc.equals(scc2));
    }
}
