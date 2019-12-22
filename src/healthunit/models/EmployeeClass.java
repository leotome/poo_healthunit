package healthunit.models;

public class EmployeeClass implements Employee {
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

}
