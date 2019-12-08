package healthunit.models;

public class CustomerClass implements Customer {
    private String name;
    private String ageRange;
    private String familyName;

    public CustomerClass(String name, String ageRange){
      this.name = name;
      this.ageRange = ageRange;
    }

    public void setFamilyName(String familyName){
      this.familyName = familyName;
    }

    public String getFamilyName(){
      return this.familyName;
    }

    public String getName() {
      return this.name;
    }

    public String getAgeRange(){
      return this.ageRange;
    }
}
