
import java.rmi.Remote;

public interface CarInterface extends Remote {

    String registerPlate(Car car) throws java.rmi.RemoteException;


}
