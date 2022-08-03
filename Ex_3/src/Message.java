import java.io.Serializable;

public class Message implements Serializable {

    private String name;
    private String country;
    private String company;

    private Participants getName;
    private Conference conference;

    public Message(String n, String c, String co){
        this.name = n;
        this.country = c;
        this.company = co;
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


}
