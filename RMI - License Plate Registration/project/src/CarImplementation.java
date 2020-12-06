/////////////////////////////////////////////////
//  Name: Tran Ngoc La (Teryl)
//  SID: 150353175
//  Fall 2020 JAC444NBB
//  Workshop 10
//  Professor Reza Khotasjeh
/////////////////////////////////////////////////

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarImplementation extends UnicastRemoteObject implements CarInterface {

    protected CarImplementation() throws RemoteException {
        super();
    }

    @Override
    public String registerPlate(Car car) throws RemoteException {
            return "" + car.hashCode(); // //Generate a random number for license plate
    }



}
