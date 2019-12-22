package healthunit.models;

public class ServiceClass implements Service {
	private String name;
	
	public ServiceClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}