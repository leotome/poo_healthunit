package healthunit.models;

public class CustomerClass implements Customer, Cloneable {
    private String name;
    private AgeRange ageRange;
    private String familyName;

    public CustomerClass(String name, AgeRange ageRange){
      this.name = name;
      this.ageRange = ageRange;
      this.familyName = null;
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
    
<<<<<<< HEAD
    public Customer clone() {
    	Customer cust = null;
		try {
			cust = (Customer) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
    	return cust;
    }
    
=======
>>>>>>> 763e592dacc7cf19761957ef5efa8867ac969ad4
}
