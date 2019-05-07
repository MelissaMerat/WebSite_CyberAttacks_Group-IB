package website.Entities;

public class Company {
    private String name;
    private String location;
    private String industry;
    private int id;

    public Company(){
       this.id=0;
       this.industry="";
       this.location="";
       this.name="";
    }

    public Company(String name, String location, String industry, int id){
        this.id=id;
        this.industry=industry;
        this.location=location;
        this.name=name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getIndustry() {
        return industry;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
