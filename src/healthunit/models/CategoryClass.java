package healthunit.models;

public class CategoryClass implements Category {
	private String name;
	
	public CategoryClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
