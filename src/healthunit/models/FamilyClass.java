package healthunit.models;

import java.util.List;
import java.util.ArrayList;

public class FamilyClass implements Family {
  private String familyName;
  private List<Customer> members;

  public FamilyClass(String familyName){
    this.members = new ArrayList<Customer>();
    this.familyName = familyName;
  }

  public String getName(){
    return this.familyName;
  }

  public void addMember(Customer member){
    this.members.add(member);
  }

  public void delMember(Customer member){
	int index = 0;
    for(Customer i : this.members){
      if(i.getName() == member.getName()){
        this.members.remove(index);
        break;
      }
      index++;
    }
  }
  
  public List<Customer> getMembers(){
	  return this.members;
  }

  public void listMembers(){
    for(Customer i : this.members){
      System.out.println(i.getAgeRange() + ' ' + i.getName());
    }
  }

}
