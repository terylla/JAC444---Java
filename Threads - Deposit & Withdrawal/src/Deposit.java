/////////////////////////////////////////////////
//  Name: Tran Ngoc La (Teryl)
//  SID: 150353175
//  Fall 2020 JAC444NBB
//  Workshop 9
//  Professor Reza Khotasjeh
////////////////////////////////////////////////


public class Deposit extends Thread{

    private SharedAccount account;
    private double[] balance;
    private String[] currency;

    public Deposit(SharedAccount deposit, double[] b, String[] cur){
        super("Depositing money:");
        account = deposit;
        balance = b;
        currency = cur;
    }

    @Override
    public void run(){
        for ( int i = 0; i < balance.length;i++){

            try {
                Thread.sleep( (int) ( Math.random() * 1000 ) );
            } catch(InterruptedException e) {
                System.err.println(e.toString());
            }

            synchronized(account) {
                account.Deposit(balance[i], currency[i]);
            }
        }
    }
}