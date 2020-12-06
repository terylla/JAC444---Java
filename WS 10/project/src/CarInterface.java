/////////////////////////////////////////////////
//  Name: Tran Ngoc La (Teryl)
//  SID: 150353175
//  Fall 2020 JAC444NBB
//  Workshop 10
//  Professor Reza Khotasjeh
/////////////////////////////////////////////////

import java.rmi.Remote;

public interface CarInterface extends Remote {

    String registerPlate(Car car) throws java.rmi.RemoteException;


}