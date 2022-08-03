import java.rmi.Naming;

public class Server {

    public static void main(String[] args) {
        try {

            RemoteConferenceInterface conferenceServer1 = new Conference("Conference1");
            Naming.rebind("Conference1", conferenceServer1);

            RemoteConferenceInterface conferenceServer2 = new Conference("Conference2");
            Naming.rebind("Conference2", conferenceServer2);

            System.out.println("The server is up...");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
