import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Conference extends UnicastRemoteObject implements RemoteConferenceInterface {

    private String name;
    private ArrayList<RemoteParticipantInterface> participants;

    public Conference(String name) throws RemoteException {
        this.name = name;
        this.participants = new ArrayList<>();
    }

    @Override
    public RemoteParticipantInterface searchPar(String name) throws RemoteException{
        for (RemoteParticipantInterface participant : participants){
            if (participant.getName().equals(name)){
                return participant;
            }
        }
        return null;
    }

    @Override
    public void addParticipant(String name, String country, String company) throws RemoteException{
        Participant participant = new Participant(name, country, company);
        participants.add(participant);
    }

    @Override
    public ArrayList<RemoteParticipantInterface> getAllPar() throws RemoteException{
        return this.participants;
    }

    @Override
    public String getConfName(){
        return name;
    }

}
