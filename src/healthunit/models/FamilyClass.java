package healthunit.models;

import java.util.List;
import java.util.ArrayList;

public class FamilyClass implements Family {
  private String familyName;
  private List<Customer> members;

  public FamilyClass(String familyName){
    List<Customers> members = new ArrayList<>();
    this.familyName = familyName;
  }

  public String getName(){
    return this.name;
  }

  public void addMember(Customer member){
    members.add(member);
  }

  public void delMember(Customer member){
    for(Customer i : this.members){
      if(i.getName() == member.getName()){
        return null;
      }
    }
  }

  public String listMembers(){
    return null;
  }


}
