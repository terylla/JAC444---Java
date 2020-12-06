
import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class CarClient {
    public static void main(String[] args) throws RemoteException {
        try {

            CarInterface c = (CarInterface) Naming.lookup("rmi://localhost:8000/Server");

            BufferedReader inFromUser = new BufferedReader(
                    new InputStreamReader(System.in));

            Car[] cars = new Car[4];
            cars[0] = new Car("2021 Jeep Wrangler 4XE", "Matte Army Green", 1000);
            cars[1] = new Car("Audi 2021 RS7 Sportback", "Black", 2000);
            cars[2] = new Car("Range Rover", "Black/White", 3000);
            cars[3] = new Car("Honda Civic 2019", "Beelack", 4000);


            for(int i = 0; i < cars.length; i++ ){

                System.out.println("\nCar to be registered:\n" + cars[i]);
                System.out.println("Enter Y/y to register, Q/q to quit, or any other letter to skip:");

                // Take input from user
                String toClient = inFromUser.readLine();

                // If Y/y, the generate license plate
                if (toClient.equals("y") || toClient.equals("Y")) {

                    System.out.println("Registering car on server...Please hold.");

                    //Wait a bit
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    //Generate a random number for license plate
                    cars[i].getRegistered(c.registerPlate(cars[i]));

                    System.out.println("Car was successfully registered:\n"+ cars[i]);

                // else if Q/q, then close the client
                } else if (toClient.equals("q") || toClient.equals("Q")) {
                    System.out.println("User chose to quit. Closing Client...\n");
                    System.exit(0);

                // otherwise, car is not registered, display message
                } else {
                    System.out.println("Car was not registered.");
                    continue;
                }

            }

            System.out.println("\nWarning: No more car to register!");
            System.out.println("Warning: Closing connection now... \n");


        } catch (MalformedURLException murle) {
            System.out.println("MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println("NotBoundException");
            System.out.println(nbe);
        } catch (java.lang.ArithmeticException ae) {
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        } catch (EOFException eof) {
            System.out.println("End of File!");
            System.out.println(eof);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
