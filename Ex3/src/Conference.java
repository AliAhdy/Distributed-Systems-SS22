import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Conference {
    private String name;
    List<Participants> participants = new ArrayList<Participants>();

    public Conference(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    //Add Participants Object to a conference ArrayList
    public void addParticipant(String n, String c, String co){
        Participants p = new Participants(n,c,co);
        participants.add(p);
    }

    public List<Participants> getParticipants(){
        return participants;
    }

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

    @Override
    public String toString(){
        return this.name;
    }
}
