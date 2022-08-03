import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;

public interface ConferenceInterface extends Remote {

    public ParticipantsInterface searching(String name) throws RemoteException;

    public void addParticipant(String name, String country, String company) throws RemoteException;

    public String getConferenceName() throws RemoteException;

    public ArrayList<ParticipantsInterface> getParticipants() throws RemoteException;
}
