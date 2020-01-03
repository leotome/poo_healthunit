package healthunit.models;

import java.io.Serializable;

public class CategoryClass implements Category,Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public CategoryClass(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}

}
