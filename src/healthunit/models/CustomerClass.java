package healthunit.models;

public class CustomerClass implements Customer {
    private String name;
    private AgeRange ageRange;
    private String familyName;

    public CustomerClass(String name, AgeRange ageRange){
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

    public AgeRange getAgeRange(){
      return this.ageRange;
    }
}
