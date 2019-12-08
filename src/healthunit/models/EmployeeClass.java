package healthunit.models;

public class EmployeeClass implements Employee {
  private String name;
  private String category;

  public EmployeeClass(String name, String category){
    this.name = name;
    this.category = category;
  }

  public String getName(){
    return this.name;
  }

  public String getCategory(){
    return this.category;
  }

}
