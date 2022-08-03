
public class Participants {
    private String name;
    private String country;
    private String company;


    public Participants(String n, String co, String c){
        name = n;
        country = co;
        company = c;
    }

    public String getName(){
        return  name;
    }

    public String getCountry(){
        return country;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String co){
        company = co;
    }

    //Covert to String
    @Override
    public String toString(){
        return this.name;
    }
}
