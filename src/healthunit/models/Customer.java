package healthunit.models;

public interface Customer extends Cloneable {
	String getName();
	void setFamilyName(String familyName);
	String getFamilyName();
	AgeRange getAgeRange();
}
