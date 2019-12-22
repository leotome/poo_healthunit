package healthunit.models;

public class AppointmentClass implements Appointment {
	private Customer customer;
	private Employee employee;
	private Category category;
	private Service service;
	
	public AppointmentClass(Customer customer, Service service, Category category, Employee employee) {
		this.customer = customer;
		this.service = service;
		this.category = category;
		this.employee = employee;
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public String getInfo() {
		return this.service.getName() + ' ' + this.category.getName() + ' ' + this.employee.getName();
	}	
}
