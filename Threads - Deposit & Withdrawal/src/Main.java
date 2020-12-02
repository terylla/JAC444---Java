

public class Main {

    public static void main(String[] args) {

        double[] balance = {1, 1, 1, 1, 1,1};
        String[] currency = {"Dollar(s)", "Pound(s)","Euro(s)",  "Pound(s)", "Pound(s)", "Dollar(s)"};


        SharedAccount account = new SharedAccount(0, ""); // initialize balance and currency as empty

        Deposit deposit = new Deposit(account, balance, currency);
        Withdrawal withdrawal = new Withdrawal(account, balance); // no need to worry about currency for withdraw

        deposit.start();
        withdrawal.start();


    }
}
