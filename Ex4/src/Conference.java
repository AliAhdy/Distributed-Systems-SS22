import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conference {

    private String name;

    List<Participants> participants = new ArrayList<Participants>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Participants> getParticipants(){
        return participants;
    }

    //Add Participants Object to a conference ArrayList
    public void addParticipant(String n, String c, String co){
        Participants p = new Participants(n,c,co);
        participants.add(p);
    }

    //Search one Participant
    public Participants searchParticipants(String name){
        Iterator<Participants> iterator = participants.iterator();
        while (iterator.hasNext()){
            Participants participants1 = iterator.next();
            if (name.equals(participants1.getName())){
                return participants1;
            }
        }
        return null;
    }

    //Get all Participants of a conference
    public List<String> getAllP(){
        List<String> participantName = new ArrayList<>();
        Iterator iterator;
        iterator = this.getParticipants().iterator();
        while(iterator.hasNext()){
            Participants par = (Participants) iterator.next();
            participantName.add(par.getName());
        }
        return participantName;
    }
}
