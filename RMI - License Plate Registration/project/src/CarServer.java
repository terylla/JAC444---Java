/////////////////////////////////////////////////
//  Name: Tran Ngoc La (Teryl)
//  SID: 150353175
//  Fall 2020 JAC444NBB
//  Workshop 10
//  Professor Reza Khotasjeh
/////////////////////////////////////////////////

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class CarServer {

    public static void main(String args[]){

            try {

                CarInterface stub = new CarImplementation();
                LocateRegistry.createRegistry(8000);
                Naming.rebind("rmi://localhost:8000/Server", stub);

                System.out.println("\n*** Opening server to register the cars... ***");
                InetAddress addr = InetAddress.getByName(null);
                System.out.println("\nConnected to: " + addr);
                System.out.println("\n******** Please note: Client & Server will automatically disconnect if there is no more car to register.");

            } catch (RemoteException | UnknownHostException | MalformedURLException e) {
                e.printStackTrace();
            }

    }

}
