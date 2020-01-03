package healthunit.models;

import java.io.Serializable;

public class EmployeeClass implements Employee,Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Category category;

  public EmployeeClass(String name, Category category){
    this.name = name;
    this.category = category;
  }

  public String getName(){
    return this.name;
  }

  public Category getCategory(){
    return this.category;
  }

  public int getCategoryId() {
	  return this.getCategory().getId();
  }
}
