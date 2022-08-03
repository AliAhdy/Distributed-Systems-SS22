package com.example.a6;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Conference {

    private String Cname;
    private Participant participant;

    private Set<Participant> parSet = new HashSet<>();

    public Conference(String Cname){
        this.Cname = Cname;
    }

    public Participant searchP(String name){
        Iterator<Participant> it = parSet.iterator();
        while (it.hasNext()){
            Participant p = it.next();
            if (name.equals(p.getName())){
                return p;
            }
        }
        return null;
    }

    public void addPar(String name, String country, String company){
        Participant participant1 = new Participant(name, country, company);
        parSet.add(participant1);
    }

    public Set<Participant> getParSet(){
        return parSet;
    }
}

