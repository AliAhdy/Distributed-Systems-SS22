package Server;

public class Participant {

    private String name;
    private String country;
    private String company;

    public Participant(String name, String country, String company){
        this.name = name;
        this.country = country;
        this.company = company;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }
}