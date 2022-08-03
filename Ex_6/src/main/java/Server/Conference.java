package Server;

import java.util.ArrayList;

public class Conference {
    private String name;
    ArrayList<Participant> participants = new ArrayList<>();

    public Conference(String name){
        this.name = name;
    }

    public void AddPar(String name, String country, String company){
        participants.add(new Participant(name, country,company));
    }

    public  ArrayList<Participant> ReturnAllPar(){
        return participants;
    }

    public ArrayList<String> ReturnParName(){
        ArrayList<String> parName = new ArrayList<>();
        for (Participant p : participants){
            parName.add(p.getName());
        }
        return parName;
    }

    public Participant SearchByName(String name){
        for (Participant p : participants){
            if (p.getName().equals(name)){
                System.out.println("Participant found");
            }
        }
        System.out.println("No Participant found!");
        return null;
    }
}