/////////////////////////////////////////////////
//  Name: Tran Ngoc La (Teryl)
//  SID: 150353175
//  Fall 2020 JAC444NBB
//  Workshop 9
//  Professor Reza Khotasjeh
////////////////////////////////////////////////

class Withdrawal extends  Thread{

    private SharedAccount account;
    private double[] balance;
    // no need to worry about currency for withdraw

    public Withdrawal(SharedAccount withdraw, double[] b){
        super("Withdrawing money:");
        this.account = withdraw;
        this.balance = b;

    }

    @Override
    public void run(){
       for (int i = 0; i < balance.length; i++) {

           try {
               Thread.sleep( (int) ( Math.random() * 1000 ) );
           } catch(InterruptedException e) {
               System.err.println(e.toString());
           }

           synchronized (account) {
               account.Withdraw(1); // withdraw 1.00 at a time
           }
       }
    }
}