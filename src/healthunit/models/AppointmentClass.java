package healthunit.models;

public class AppointmentClass implements Appointment {
	private Customer customer;
	private Employee employee;
	private String service;
	
	public AppointmentClass(Customer customer, String service, Employee employee) {
		this.customer = customer;
		this.service = service;
		this.employee = employee;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public String getInfo() {
		return service + ' ' + this.employee.getCategory() + ' ' + this.employee.getName();
	}	
}
