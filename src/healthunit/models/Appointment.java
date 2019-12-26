package healthunit.models;

public interface Appointment {
	Customer getCustomer();
	Employee getEmployee();
	Service getService();
	String getInfo();
}
