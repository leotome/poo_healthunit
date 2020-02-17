package healthunit.models;

import java.io.Serializable;

public class AppointmentClass implements Appointment,Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Employee employee;
	private Service service;
	
	public AppointmentClass(Customer customer, Service service, Employee employee) {
		this.customer = customer;
		this.service = service;
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
		return this.service.getName() + ' ' + this.employee.getCategory().getName() + ' ' + this.employee.getName();
	}	
}
