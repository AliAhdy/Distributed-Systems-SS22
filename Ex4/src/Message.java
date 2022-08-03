import java.io.Serializable;

public class Message implements Serializable {

    private String conferenceName;
    private String name;
    private String country;
    private String company;
    private String method;

    public Message(String conferenceName, String name, String country, String company, String method){
        this.conferenceName = conferenceName;
        this.name = name;
        this.country = country;
        this.company = company;
        this.method = method;
    }

    public String getConferenceName(){
        return conferenceName;
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

    public String getMethod(){
        return method;
    }
}
