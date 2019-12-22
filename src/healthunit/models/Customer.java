package healthunit.models;

public interface Customer {
	String getName();
	void setFamilyName(String familyName);
	String getFamilyName();
	AgeRange getAgeRange();
}
