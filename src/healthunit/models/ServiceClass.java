package healthunit.models;

import java.io.Serializable;

public class ServiceClass implements Service,Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	
	public ServiceClass(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}