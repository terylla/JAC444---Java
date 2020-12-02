

import java.text.DecimalFormat;

public class SharedAccount {

    private double balance;
    private String currency;

    //*** Constructor ***//
    SharedAccount(double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    //*** Setters ***//
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    //*** Getters ***//
    public double getBalance() {
        return this.balance;
    }

    public String getCurrency() {
        return this.currency;
    }


    //*** Container to accept only 1 object at a time  ***//

    DecimalFormat df = new DecimalFormat("###0.00");

    // Deposit
    public synchronized void Deposit(double val, String cur){
        while (getBalance() != 0 && !getCurrency().equals(cur)) {
            try{
                System.out.println("Only 1 currency allowed in account. Empty account balance to deposit a different currency." + "\n");
                wait(); // wait til Withdraw is performed
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        setCurrency(cur);
        System.out.println(Thread.currentThread().getName() +  " " + df.format(val) + " " + getCurrency() + ".");
        setBalance(getBalance()+val);
        System.out.println("Current balance: " + df.format(getBalance()) + " " + cur + "."+ "\n");

        notify(); // tell the waiting thread (Withdraw) to be ready
    }


    // Withdraw
    public synchronized void Withdraw(double val){

        while (getBalance() < val) {
        try{
            System.out.println("Unable to withdraw if balance is 0. Deposit money to withdraw." + "\n");
            wait(); // wait til Deposit is performed
        } catch (InterruptedException e){
            e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " "  + df.format(val) + " " + getCurrency() + ".");
        setBalance(getBalance() - val);
        System.out.println("Current balance: " + df.format(getBalance()) + "." + "\n");

        notify(); // tell the waiting thread (Deposit) to be ready

    }




}
