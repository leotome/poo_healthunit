package healthunit.models;
import java.util.List;

public interface Family {
  public String getName();
  public void addMember(Customer member);
  public void delMember(Customer member);
  public void listMembers();
  public List<Customer> getMembers();
}
