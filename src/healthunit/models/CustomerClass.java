package healthunit.models;

public class CustomerClass implements Customer {
    private String name;
    private String ageRange;

    public CustomerClass(String name, String ageRange){
      this.name = name;
      this.ageRange = ageRange;
    }

    public String getName() {
      return this.name;
    }

    public String getAgeRange(){
      return this.ageRange;
    }
}
