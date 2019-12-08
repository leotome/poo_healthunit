package healthunit.controllers;

import java.util.List;
import java.util.ArrayList;

import healthunit.models.Appointment;
import healthunit.models.Customer;
import healthunit.models.CustomerClass;
import healthunit.models.Employee;
import healthunit.models.EmployeeClass;
import healthunit.models.Family;
import healthunit.models.FamilyClass;

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
		customers.add(new CustomerClass(name, ageRange));
	}

	public void createEmployee(String name, String category) {
		employees.add(new EmployeeClass(name, category));

	}

	public void createFamily(String familyName) {
		families.add(new FamilyClass(familyName));

	}

	public List<Appointment> getAppointmentList(){
		return this.appointments;
	}
  public List<Customer> getCustomerList(){
		return this.customers;
	}
	public List<Employee> getEmployeeList(){
		return this.employees;
	}
  public List<Family> getFamilyList(){
		return this.families;
	}

	public Customer getCustomer(String customerName){
		Customer myCustomer = null;
		for(Customer i : this.getCustomerList()){
			if(i.getName() == customerName){
				myCustomer = i;
			}
		}
		return myCustomer;
	}

	public Family getFamily(String familyName){
		Family myFamily = null;
		for(Family i : this.getFamilyList()){
			if(i.getName() == familyName){
				myFamily = i;
			}
		}
		return myFamily;
	}

	public void associateCustomertoFamily(String customerName, String familyName) {
		Family familyToAdd = getFamily(familyName);
		Customer memberToAdd = getCustomer(customerName);
		familyToAdd.addMember(memberToAdd);
		memberToAdd.setFamilyName(familyToAdd.getName());
	}

	public void deassociateCustomertoFamily(String customerName, String familyName) {
		Family familyToChange = getFamily(familyName);
		Customer memberToDel = getCustomer(customerName);
		familyToChange.delMember(memberToDel);
		memberToDel.setFamilyName(null);
	}

	public void listCustomers() {
		for(Customer i : this.getCustomerList()){
			System.out.println(i.getFamilyName() + ' ' + i.getAgeRange() + ' ' + i.getName());
		}
	}

	public void listEmployees() {
		for(Employee i : this.getEmployeeList()){
			System.out.println(i.getCategory() + ' ' + i.getName());
		}
	}

	public void listFamilies() {
		for(Family i : this.getFamilyList()){
			System.out.println(i.getName());
		}
	}

	public void showFamily(String familyName) {
		Family familyToList = getFamily(familyName);
		familyToList.listMembers();
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
