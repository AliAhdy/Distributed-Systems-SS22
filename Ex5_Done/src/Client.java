import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        if (args.length != 1){
            throw  new IllegalArgumentException("Syntax: Client <hostname>");
        }

        Scanner scanner =  new Scanner(System.in);

        System.out.println("Conf 1 or 2?");
        String input = scanner.nextLine();
        if (input.equals("1")){
            input = "Conference1";
        }
        else if (input.equals("2")){
            input = "Conference2";
        }
        else throw new Exception("No conference selected!");

       try {
           RemoteConferenceInterface conference = (RemoteConferenceInterface) Naming.lookup("rmi://" + args[0] + "/" + input);

           //2.Example input
           conference.addParticipant("Ali", "Germany", "Test");
           conference.addParticipant("Amar", "Germany", "A");
           conference.addParticipant("Patrick", "Germany", "P");
           conference.addParticipant("Test", "Belgien", "TT");

           //1.SearchPar & 4.Change Company
           RemoteParticipantInterface participant = conference.searchPar("Ali");
           System.out.println(participant.getName() + " " + participant.getCountry() + " " +  participant.getCompany());
           participant.setCompany("12344");
           System.out.println(participant.getName() + " now works at: " + participant.getCompany());
           System.out.println("\n");

           //3.Output all participants
           System.out.println("Company name: " + conference.getConfName());

           for (RemoteParticipantInterface participantInterface : conference.getAllPar()){
               System.out.println("Name: " + participantInterface.getName());
               System.out.println("Country: " + participantInterface.getCountry());
               System.out.println("Company: " + participantInterface.getCompany());
               System.out.println("\n");
           }

           //5.Count all germans
           ArrayList<RemoteParticipantInterface> participants = conference.getAllPar();
           int counter = 0;
           int size = participants.size();

           for (RemoteParticipantInterface p : participants){
               if (p.getCountry().equals("Germany")){
                   counter++;
               }
           }
           System.out.println("Germans: " + counter);
           System.out.println("Size of Array: " + size);
           float per = (float) counter/size;
           System.out.println(per * 100 + "% People are german");

       }catch (Exception e){
           System.out.println("Client: " + e.getMessage());
           e.printStackTrace();
       }
    }
}
