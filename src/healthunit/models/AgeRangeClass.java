package healthunit.models;

import java.io.Serializable;

public class AgeRangeClass implements AgeRange,Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public AgeRangeClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
