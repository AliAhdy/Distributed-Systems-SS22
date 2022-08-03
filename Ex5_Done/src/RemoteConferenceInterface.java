import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteConferenceInterface extends Remote {

    RemoteParticipantInterface searchPar(String name) throws RemoteException;

    void addParticipant(String name, String country, String company) throws RemoteException;

    ArrayList<RemoteParticipantInterface> getAllPar() throws RemoteException;

    String getConfName() throws RemoteException;
}
