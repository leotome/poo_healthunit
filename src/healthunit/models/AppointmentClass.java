package healthunit.models;

import java.io.Serializable;

public class AppointmentClass implements Appointment,Serializable {
	private static final long serialVersionUID = 1L;
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
	
	public Employee getEmployee() {
		return this.employee;
	}
	
	public Service getService() {
		return this.service;
	}
	
	public String getInfo() {
		return this.service.getName() + ' ' + this.category.getName() + ' ' + this.employee.getName();
	}	
}
