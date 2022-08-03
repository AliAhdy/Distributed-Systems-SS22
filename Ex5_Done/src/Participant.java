import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Participant extends UnicastRemoteObject implements RemoteParticipantInterface {

    private String name;
    private String country;
    private String company;

    public Participant(String name, String country, String company) throws RemoteException{
        this.name = name;
        this.country = country;
        this.company = company;
    }

    @Override
    public String getName() throws RemoteException{
        return name;
    }

    @Override
    public String getCountry() throws RemoteException{
        return country;
    }

    @Override
    public String getCompany() throws RemoteException{
        return company;
    }

    @Override
    public void setCompany(String name) throws RemoteException{
        this.company = name;
    }
}
