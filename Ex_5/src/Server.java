import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*46.2.3 Implementierung des Remote-Interfaces

Die Implementierungsklasse

Nach der Definition des Remote-Interfaces muss dessen Implementierung (also die Klasse für die Remote-Objekte)
realisiert werden. Dazu erstellen wir eine Klasse TimeServiceImpl, die aus UnicastRemoteObject abgeleitet ist und das
Interface TimeService implementiert. UnicastRemoteObject stammt aus dem Paket java.rmi.server und ist für die Details
der Kommunikation zwischen Client und Server verantwortlich. Zusätzlich überlagert sie die Methoden clone, equals, hashCode
und toString der Klasse Object, um den Remote-Referenzen die Semantik von Referenzen zu verleihen.

Der hier verwendete Suffix "Impl" ist lediglich eine Namenskonvention, die anzeigt, daß das Objekt eine Implementierung
von "TimeService" ist. Wir hätten auch jeden anderen Namen wählen können. Die Klasse TimeServiceImpl wird später nur bei
der Instanziierung der zu registrierenden Remote-Objekte benötigt, auf Client-Seite kommt sie überhaupt nicht vor.*/

//participantInterface
class Participant extends UnicastRemoteObject implements ParticipantsInterface{

    private String name;
    private String country;
    private String company;

    public Participant(String name, String country, String company) throws RemoteException{
        this.name = name;
        this.country = country;
        this.company = company;
    }

    public Participant(Participant participant) throws RemoteException{

        this.name = participant.name;
        this.country = participant.country;
        this.company = participant.company;
    };
    //participant Methods
    public String getName() throws RemoteException{
        return name;
    }
    public String getCountry() throws RemoteException{
        return country;
    }
    public String getCompany() throws RemoteException{
        return company;
    }
    public void setCompany(String company) throws RemoteException{
        this.company = company;
    }
}

//
//ConfInterface
public class Server extends UnicastRemoteObject implements ConferenceInterface {

    private String confName;
    ArrayList<ParticipantsInterface> participantsInterface = new ArrayList<ParticipantsInterface>();

    public Server(String cName) throws RemoteException{
        confName = cName;
    }

    public ParticipantsInterface searching(String name) throws RemoteException{

        for (int i = 0; i < participantsInterface.size(); i++){
            if (participantsInterface.get(i).getName().equals(name)){
                return participantsInterface.get(i);
            }
        }
        return null;
    }

    public void addParticipant(String name, String country, String company){

        participantsInterface.add(new Server(name, country, company));

    }


    public static void main(String[] args) {
        try {

            ConferenceInterface conference1 = new Server("Conference1");
            ConferenceInterface conference2 = new Server("Conference2");

            Naming.rebind("Conference1", conference1);
            Naming.rebind("Conference2", conference2);

            System.out.println("The Server is up\n");

        }catch (Exception e ){
            System.out.println("Server Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
