import java.rmi.Remote;
import java.rmi.RemoteException;

/*46.2.2 Das Remote-Interface

Das Remote-Interface definiert die Schnittstelle zwischen Client und Server.
Bei seiner Entwicklung müssen einige Regeln beachtet werden:

Das Remote-Interface muß aus dem Interface Remote des Pakets java.rmi abgeleitet und als public deklariert werden.
Jede Methode muß die Exception RemoteException (ebenfalls aus dem Paket java.rmi) deklarieren.
Hiermit werden alle Arten von Netzwerkproblemen oder Verbindungsstörungen zwischen Client und Server angezeigt.
Nur die im Remote-Interface definierten Methoden stehen später den Clients zur Verfügung. Werden später bei
der Implementierung des Servers weitere Methoden hinzugefügt, so bleiben sie für den Client unsichtbar. */

public interface ParticipantsInterface extends Remote {

    public String getName() throws RemoteException;

    public String getCountry() throws RemoteException;

    public String getCompany() throws RemoteException;

    public void setCompany(String company) throws RemoteException;
}
