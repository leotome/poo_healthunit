package healthunit.models;
import java.util.List;

public interface Family {
  String getName();
  void addMember(Customer member);
  void delMember(Customer member);
  void listMembers();
  List<Customer> getMembers();
}
