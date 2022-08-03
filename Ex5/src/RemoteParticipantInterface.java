import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteParticipantInterface extends Remote {

    String getName() throws RemoteException;

    String getCountry() throws RemoteException;

    String getCompany() throws RemoteException;

    void setCompany(String cName) throws RemoteException;
}
