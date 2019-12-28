package healthunit.models;

import java.io.Serializable;

public class CategoryClass implements Category,Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	
	public CategoryClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
