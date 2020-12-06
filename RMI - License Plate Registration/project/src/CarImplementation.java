
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
