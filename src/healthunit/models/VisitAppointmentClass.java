package healthunit.models;

import java.io.Serializable;

public class VisitAppointmentClass implements Appointment,Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Employee employee;
	private Category category;
	private Service service;

	public VisitAppointmentClass(Customer c, Service s, Category ct, Employee e) {
		this.customer = c;
		this.service = s;
		this.category = ct;
		this.employee = e;
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
