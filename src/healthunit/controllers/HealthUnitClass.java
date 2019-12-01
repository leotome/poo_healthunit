package healthunit.controllers;

import java.util.List;
import java.util.ArrayList;

import healthunit.models.Appointment;
import healthunit.models.Customer;
import healthunit.models.Employee;
import healthunit.models.Family;

public class HealthUnitClass implements HealthUnit{
	private List<Appointment> appointments;
	private List<Customer> customers;
	private List<Employee> employees;
	private List<Family> families;

	public HealthUnitClass(){
		appointments = new ArrayList<Appointment>();
		customers = new ArrayList<Customer>();
		employees = new ArrayList<Employee>();
		families = new ArrayList<Family>();
	}

	public void createCustomer(String name, String ageRange) {
		// TODO Auto-generated method stub
	}

	public void createEmployee(String name, String category) {
		// TODO Auto-generated method stub

	}

	public void createFamily(String familyName) {
		// TODO Auto-generated method stub

	}

	public void associateCustomertoFamily(String customerName, String familyName) {
		// TODO Auto-generated method stub

	}

	public void deassociateCustomertoFamily(String customerName, String familyName) {
		// TODO Auto-generated method stub

	}

	public void listCustomers() {
		// TODO Auto-generated method stub

	}

	public void listEmployees() {
		// TODO Auto-generated method stub

	}

	public void listFamilies() {
		// TODO Auto-generated method stub

	}

	public void showFamily(String familyName) {
		// TODO Auto-generated method stub

	}

	public void createAppointment(String customerName) {
		// TODO Auto-generated method stub

	}

	public void cancelAppointment(String customerName) {
		// TODO Auto-generated method stub

	}

	public void showAppointmentstoCustomer(String customerName) {
		// TODO Auto-generated method stub

	}

	public void showAppointmentstoFamily(String familyName) {
		// TODO Auto-generated method stub

	}

	public void showAppointmentstoEmployee(String category, String employeeName) {
		// TODO Auto-generated method stub

	}

	public void showAppointmentsperService(String serviceName) {
		// TODO Auto-generated method stub

	}

	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean load() {
		// TODO Auto-generated method stub
		return false;
	}

}
