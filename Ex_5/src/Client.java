import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception{

        if (args.length != 1)
            throw new IllegalArgumentException("Syntax: DateClient <hostname>");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Conference 1 or 2?");
        String chooseConference = scanner.nextLine();
        if (chooseConference.equals("1")){
            chooseConference = "Conference1";
        }
        else if (chooseConference.equals("2")){
            chooseConference = "Conference2";
        }
        else throw new Exception("FAIL");

        try{

            //Conference Objects
            ConferenceInterface conference = (ConferenceInterface) Naming.lookup("rmi://" + args[0] + "/" + chooseConference);
            System.out.println("Connection established\n");

            conference.addParticipant("Ali", "Germany", "A");
            conference.addParticipant("Amar", "Germany", "B");
            conference.addParticipant("Tim", "Irak", "C");

            //1.Search Participant
            System.out.println("Search for name: Ali");
            ParticipantsInterface participant = conference.searching("Ali");

            //2.Adding of participant
            conference.addParticipant("Patrick", "Germany", "companyT");

            //.Change Company
            System.out.println(participant.getCompany());
            participant.setCompany("12345");
            System.out.println(participant.getName() + " changed company to: " + participant.getCompany());

           /* //3.Print of all participants in conference
            //Hashset of conference1 + iteration
            HashSet<ParticipantsInterface> participantSet1 = conference.getParticipants();
            Iterator<ParticipantsInterface> iterator = participantSet1.iterator();
            //
            while (iterator.hasNext()){
                String a = iterator.next().getName();
                System.out.println("Name: " + a);
            }*/

            //4.Return name of conference
            System.out.println(conference.getConferenceName());

            //Calc
            ArrayList<ParticipantsInterface> participantsInterface = conference.getParticipants();
            int counter = 0;
            int size = participantsInterface.size();

            for (ParticipantsInterface p : participantsInterface){
                if (p.getCountry().equals("Germany")){
                    counter++;
                }
            }
            System.out.println(counter);
            System.out.println(size);
            float y = (float) counter/size;
            System.out.println(y * 100 + "% People are german");
            /*
            //1.Search participant
            ParticipantsInterface participant1 = conference2.searching("Elia");

            //change the company of a participant
            participant1.setCompany("UAS-FRA");
            //Test
            System.out.println(participant1.getCompany());

            System.out.println("\n");
            System.out.println(conference2.getConferenceName());
            //Return of all company's of conference2 (see if company of ali changed)
            HashSet<ParticipantsInterface> participantsSet2 = conference2.getParticipants();
            Iterator<ParticipantsInterface> iterator2 = participantsSet2.iterator();
            //
            while (iterator2.hasNext()){
                String b = iterator2.next().getCompany();
                System.out.println("Company: " + b);
            }




            System.out.println("\n");
            System.out.println(conference2.getConferenceName());
            //Return of all Country's of Conference2
            HashSet<ParticipantsInterface> participantsSet3 = conference2.getParticipants();
            Iterator<ParticipantsInterface> iterator3 = participantsSet3.iterator();
            while (iterator3.hasNext()){
                String c = iterator3.next().getCountry();
                System.out.println("Country: " + c);
            }

            //Calc of all germans
            System.out.println("\n");
            calc(conference1, conference2);
*/
        }catch (Exception e){
            System.out.println("Client Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


