package healthunit.controllers;

import java.util.List;
import java.util.ArrayList;

import healthunit.models.Appointment;
import healthunit.models.AppointmentClass;
import healthunit.models.Category;
import healthunit.models.CategoryClass;
import healthunit.models.Service;
import healthunit.models.ServiceClass;
import healthunit.models.AgeRange;
import healthunit.models.AgeRangeClass;
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
	private List<Category> categories;
	private List<Service> services;
	private List<AgeRange> ageRanges;

	public HealthUnitClass(){
		appointments = new ArrayList<Appointment>();
		customers = new ArrayList<Customer>();
		employees = new ArrayList<Employee>();
		families = new ArrayList<Family>();
		categories = new ArrayList<Category>();
		services = new ArrayList<Service>();
		ageRanges = new ArrayList<AgeRange>();
	}
	
	public void initializeCategories() {
		categories.add(new CategoryClass("Medicina"));
		categories.add(new CategoryClass("Enfermagem"));
		categories.add(new CategoryClass("Auxiliar"));
	}
	
	public Category getCategory(String categoryName) {
		Category category = null;
		for(Category i : this.categories) {
			if(i.getName() == categoryName) {
				category = i;
			}
		}
		return category;
	}

	public void initializeAgeRange() {
		ageRanges.add(new AgeRangeClass("Jovem"));
		ageRanges.add(new AgeRangeClass("Adulto"));
		ageRanges.add(new AgeRangeClass("Idoso"));
	}
	
	public AgeRange getAgeRange(String ageRangeName) {
		AgeRange ageRange = null;
		for(AgeRange i : this.ageRanges) {
			if(i.getName() == ageRangeName) {
				ageRange = i;
			}
		}
		return ageRange;
	}
	
	public void initializeServices(){
		services.add(new ServiceClass("Consulta"));
		services.add(new ServiceClass("PequenaCirurgia"));
		services.add(new ServiceClass("Enfermagem"));
	}

	public Service getService(String serviceName) {
		Service service = null;
		for(Service i : this.services) {
			if(i.getName() == serviceName) {
				service = i;
			}
		}
		return service;
	}
	
	public void createCustomer(String name, String ageRangeName) {
		Customer customer = this.getCustomer(name);
		AgeRange ageRange = this.getAgeRange(ageRangeName);
		if (customer == null) {
			if (ageRange != null) {
				customers.add(new CustomerClass(name, ageRange));
			} else {
				System.out.println("Faixa etária inexistente.");
			}
		} else {
			System.out.println("Utente existente.");
		}
	}

	public void createEmployee(String name, String categoryName) {
		Category category = this.getCategory(categoryName);
		Employee employee = this.getEmployee(name);
		if (category != null) {
			if (employee == null) {
				employees.add(new EmployeeClass(name, category));	
			} else {
				System.out.println("Profissional existente.");
			}
		} else {
			System.out.println("Categoria inexistente.");
		}
	}

	public void createFamily(String familyName) {
		Family family = this.getFamily(familyName);
		if(family == null) {
			families.add(new FamilyClass(familyName));	
		} else {
			System.out.println("Família existente.");
		}
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

	public Employee getEmployee(String employeeName) {
		Employee myEmployee = null;
		for(Employee i : this.getEmployeeList()) {
			if(i.getName() == employeeName){
				myEmployee = i;
				break;
			}
		}
		return myEmployee;
	}

	public void associateCustomertoFamily(String customerName, String familyName) {
		Family familyToAdd = getFamily(familyName);
		Customer memberToAdd = getCustomer(customerName);
		if (memberToAdd != null) {
			if(memberToAdd.getFamilyName() == null) {
				if(familyToAdd != null) {
					familyToAdd.addMember(memberToAdd);
					memberToAdd.setFamilyName(familyToAdd.getName());			
				} else {
					System.out.println("Família inexistente.");
				}
			} else {
				System.out.println("Utente pertencente a família.");
			}
		} else {
			System.out.println("Utente inexistente.");
		}
	}

	public void deassociateCustomertoFamily(String customerName, String familyName) {
		Family familyToChange = getFamily(familyName);
		Customer memberToDel = getCustomer(customerName);
		if(memberToDel != null) {
			if(memberToDel.getFamilyName() == familyName) {
				familyToChange.delMember(memberToDel);
				memberToDel.setFamilyName(null);
			} else {
				System.out.println("Utente não pertence a família.");
			}
		} else {
			System.out.println("Utente inexistente.");
		}
	}

	public void listEmployees() {
		if(!this.getEmployeeList().isEmpty()) {
			for(Employee i : this.getEmployeeList()){
				System.out.println(i.getCategory().getName() + ' ' + i.getName());
			}
		} else {
			System.out.println("Sem profissionais registados.");
		}
	}
	
	public void listFamilies() {
		if(!this.getFamilyList().isEmpty()) {
			for(Family i : this.getFamilyList()){
				System.out.println(i.getName());
			}
		} else {
			System.out.println("Sem famílias registadas.");
		}
	}
	
	public void listCustomers() {
		if(!this.getCustomerList().isEmpty()) {
			for(Customer i : this.getCustomerList()){
				if(i.getFamilyName() == null) {
					System.out.println(i.getAgeRange().getName() + ' ' + i.getName());	
				} else {
					System.out.println(i.getFamilyName() + ' ' + i.getAgeRange().getName() + ' ' + i.getName());
				}
			}
		} else {
			System.out.println("Sem utentes registados.");
		}
	}

	public void showFamily(String familyName) {
		Family familyToList = getFamily(familyName);
		if(familyToList != null) {
			familyToList.listMembers();	
		} else {
			System.out.println("Família inexistente.");
		}
	}

	public void createAppointment(String customerName, String service, String employeeName) {
		this.appointments.add(new AppointmentClass(this.getCustomer(customerName), service, this.getEmployee(employeeName)));

	}

	public void cancelAppointment(String customerName) {
		int custIndex = 0;
		int foundCust = 0;
		Customer customer = getCustomer(customerName);
		if(customer != null) {
			for(Appointment i : this.getAppointmentList()) {
				if(i.getCustomer().getName() == customerName){
					this.appointments.remove(custIndex);
					foundCust++;
				}
				custIndex++;
			}
			if(foundCust == 0) {
				System.out.println("Utente sem cuidados de saúde marcados.");
			}
		} else {
			System.out.println("Utente inexistente.");
		}
	}

	public void showAppointmentstoCustomer(String customerName) {
		Customer customer = this.getCustomer(customerName);
		int appointCounter = 0;
		if (customer != null) {
			for(Appointment i : this.getAppointmentList()) {
				if(i.getCustomer().getName() == customer.getName()) {
					System.out.println(i.getInfo());
					appointCounter++;
				}
			}
			if (appointCounter == 0) {
				System.out.println("Utente sem cuidados de saúde marcados.");
			}
		} else {
			System.out.println("Utente inexistente.");
		}
	}

	public void showAppointmentstoFamily(String familyName) {
		Family family = this.getFamily(familyName);
		int appointCounter = 0;
		if (family != null) {
			for(Customer i : family.getMembers()) {
				for(Appointment j : this.getAppointmentList()) {
					if(j.getCustomer().getName() == i.getName()) {
						System.out.println(i.getName() + ' ' + j.getInfo());
						appointCounter++;
					}
				}
			}
			if (appointCounter == 0) {
				System.out.println("Família sem cuidados de saúde marcados.");
			}
		} else { 
			System.out.println("Família inexistente.");
		}
	}

	public void showAppointmentstoEmployee(String category, String employeeName) {
		Employee employee = this.getEmployee(employeeName);
		int serviceCounter = 0;
		if(employee != null) {
			//TODO
			if(serviceCounter == 0) {
				System.out.println("Profissional de saúde sem marcações.");
			}
		} else {
			System.out.println("Profissional de saúde inexistente.");
		}
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
