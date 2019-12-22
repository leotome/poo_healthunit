package healthunit.models;

public class AgeRangeClass implements AgeRange {
	private String name;
	
	public AgeRangeClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
