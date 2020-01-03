package healthunit.models;

import java.io.Serializable;

public class CustomerClass implements Customer,Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
    private AgeRange ageRange;
    private String familyName;

    public CustomerClass(String name, AgeRange ageRange){
      this.name = name;
      this.ageRange = ageRange;
      this.familyName = "";
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
    
    public int getAgeRangeId() {
    	return this.getAgeRange().getId();
    }

}
