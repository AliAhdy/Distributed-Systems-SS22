
public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference("Fra-UAS");
        conference.addParticipant("Ali", "Germany", "Test");
        conference.addParticipant("Test", "test", "test");

        System.out.print(conference);
        System.out.println("\n");
        System.out.print(conference.participants);

        String country = "Germany";
        int totalValue = 0;
        for (Participants p : conference.getParticipants()) {
            if (p.getCountry().equals(country)){
                totalValue++;
            }
        }
        System.out.println("\n");
        System.out.printf("Total: %s = %d", country, totalValue);


        //Test Search participant
        Participants participants = conference.searchParticipants("Test");
        System.out.println("\n" + participants);

    }
}
