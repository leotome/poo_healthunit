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

import java.util.Scanner;

public class HealthUnitClass implements HealthUnit{
	private List<Appointment> appointments;
	private List<Customer> customers;
	private List<Employee> employees;
	private List<Family> families;
	private List<Category> categories;
	private List<Service> services;
	private List<AgeRange> ageRanges;

	public void initializeAll() {
		this.categories.add(new CategoryClass("Medicina"));
		this.categories.add(new CategoryClass("Enfermagem"));
		this.categories.add(new CategoryClass("Auxiliar"));
		this.ageRanges.add(new AgeRangeClass("Jovem"));
		this.ageRanges.add(new AgeRangeClass("Adulto"));
		this.ageRanges.add(new AgeRangeClass("Idoso"));
		this.services.add(new ServiceClass("Consulta"));
		this.services.add(new ServiceClass("PequenaCirurgia"));
		this.services.add(new ServiceClass("Enfermagem"));
	}

	public HealthUnitClass(){
		appointments = new ArrayList<Appointment>();
		customers = new ArrayList<Customer>();
		employees = new ArrayList<Employee>();
		families = new ArrayList<Family>();
		categories = new ArrayList<Category>();
		services = new ArrayList<Service>();
		ageRanges = new ArrayList<AgeRange>();
		this.initializeAll();
	}

	public Category getCategory(String categoryName) {
		for(Category i : this.categories) {
			if(i.getName().equalsIgnoreCase(categoryName)) {
				return i;
			}
		}
		return null;
	}


	public AgeRange getAgeRange(String ageRangeName) {
		for(AgeRange i : this.ageRanges) {
			if(i.getName().equalsIgnoreCase(ageRangeName)) {
				return i;
			}
		}
		return null;
	}

	public Service getService(String serviceName) {
		for(Service i : this.services) {
			if(i.getName().equalsIgnoreCase(serviceName)) {
				return i;
			}
		}
		return null;
	}


	public void createCustomer(String name, String ageRangeName) {
		Customer customer = this.getCustomer(name);
		AgeRange ageRange = this.getAgeRange(ageRangeName);
		if (ageRange != null) {
			if (customer == null) {
				customers.add(new CustomerClass(name, ageRange));
				System.out.println("Utente registado com sucesso.");
			} else {
					System.out.println("Utente existente.");
			}
		} else {
			System.out.println("Faixa etária inexistente.");
		}
	}

	public void createEmployee(String categoryName, String name) {
		Category category = this.getCategory(categoryName);
		Employee employee = this.getEmployee(name);
		if (category != null) {
			if (employee == null) { //Check and perhaps correct this
				employees.add(new EmployeeClass(name, category));
				System.out.println("Profissinal registado com sucesso.");
			} else {
				if(employee.getCategory() != category) {
					employees.add(new EmployeeClass(name, category));
					System.out.println("Profissinal registado com sucesso.");
				} else {
					System.out.println("Profissional existente.");
				}
			}
		} else {
			System.out.println("Categoria inexistente.");
		}
	}

	public void createFamily(String familyName) {
		Family family = this.getFamily(familyName);
		if(family == null) {
			families.add(new FamilyClass(familyName));
			System.out.println("Família adicionada com sucesso.");
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
		for(Customer i : this.getCustomerList()){
			if(i.getName().equalsIgnoreCase(customerName)){
				return i;
			}
		}
		return null;
	}

	public Family getFamily(String familyName){
		for(Family i : this.getFamilyList()){
			if(i.getName().equalsIgnoreCase(familyName)){
				return i;
			}
		}
		return null;
	}

	public Employee getEmployee(String employeeName) {
		for(Employee i : this.getEmployeeList()) {
			if(i.getName().equalsIgnoreCase(employeeName)){
				return i;
			}
		}
		return null;
	}

	public void associateCustomertoFamily(String customerName, String familyName) {
		Family familyToAdd = getFamily(familyName);
		Customer memberToAdd = getCustomer(customerName);
		if (memberToAdd != null) {
			if(memberToAdd.getFamilyName().isBlank()) {
				if(familyToAdd != null) {
					familyToAdd.addMember(memberToAdd);
					memberToAdd.setFamilyName(familyToAdd.getName());
					System.out.println("Utente associado a família.");
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

	public void deassociateCustomertoFamily(String customerName) {
		Customer memberToDel = getCustomer(customerName);
		if(memberToDel != null) {
			if(!memberToDel.getFamilyName().isEmpty()) {
				Family familyToChange = getFamily(memberToDel.getFamilyName());
				familyToChange.delMember(memberToDel);
				memberToDel.setFamilyName("");
				System.out.println("Utente desassociado de família.");
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
				if(i.getFamilyName() == "") {
					System.out.println(i.getAgeRange().getName() + ' '
							+ i.getName());
				} else {
					System.out.println(i.getFamilyName() + ' '
							+ i.getAgeRange().getName() + ' ' + i.getName());
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

	public void createAppointment(String customerName) {
		Scanner apInput = new Scanner(System.in); //Never close this scanner!
		Customer customer = this.getCustomer(customerName);
		if(customer != null) {
			while(apInput.hasNextLine()) {
				String line = apInput.nextLine();
				if(line.isBlank()) {
					break;
				}
				Service service = this.getService(line);
			if(service != null) {
						String line_2 = apInput.nextLine();
						if(line_2.isBlank()) {
							break;
						}
						String[] myCommand = line_2.split(" ");
						Category category = this.getCategory(myCommand[0]);
						Employee employee = this.getEmployee(myCommand[1]);
						if(category != null) {
							if(employee != null) {
								Appointment a = null;
								switch (service.getName()) {
								case "Consulta":
									if(category.getName().equalsIgnoreCase("Medicina")) {
										a = new AppointmentClass(customer, service, category, employee);
										this.appointments.add(a);
										System.out.println("Cuidados marcados com sucesso.");
									} else {
										System.out.println("Categoria inválida.");
									}
									break;
								case "PequenaCirurgia":
									a = new AppointmentClass(customer, service, category, employee);
									this.appointments.add(a);
									System.out.println("Cuidados marcados com sucesso.");
									break;
								case "Enfermagem":
									if(category.getName().equalsIgnoreCase("Auxiliar") || category.getName().equalsIgnoreCase("Enfermagem")) {
										a = new AppointmentClass(customer, service, category, employee);
										this.appointments.add(a);
										System.out.println("Cuidados marcados com sucesso.");
									} else {
										System.out.println("Categoria inválida.");
									}
									break;
								}
							} else {
								System.out.println("Profissional de saúde inexistente.");
							}
						} else {
							System.out.println("Categoria inexistente.");
						}
			} else {
				System.out.println("Serviço inexistente.");
			}
		  }
		} else {
			System.out.println("Utente inexistente.");
		}
	}

	public void cancelAppointment(String customerName) {
		int foundCust = 0;
		Customer customer = getCustomer(customerName);
		List<Appointment> auxiliar = new ArrayList<Appointment>();
		if(customer != null) {
			for(Appointment i : this.getAppointmentList()) {
				if(i.getCustomer().getName().equalsIgnoreCase(customerName)){
					auxiliar.add(i);
					foundCust++;
				}
			}
			if(foundCust != 0) {
				for(Appointment i : auxiliar) {
					this.appointments.remove(i);
				}
				System.out.println("Cuidados de saúde desmarcados com sucesso.");
			} else {
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
				if(i.getCustomer().getName().equalsIgnoreCase(customerName)) {
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
					if(j.getCustomer().getName().equalsIgnoreCase(i.getName())) {
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
		int employeeCounter = 0;
		if(employee != null) {
			for(Appointment i : this.getAppointmentList()) {
				if(i.getEmployee().getName().equalsIgnoreCase(employee.getName())) {
					System.out.println(i.getService().getName()
							+ " " + i.getCustomer().getName());
					employeeCounter++;
				}
			}
			if(employeeCounter == 0) {
				System.out.println("Profissional de saúde sem marcações.");
			}
		} else {
			System.out.println("Profissional de saúde inexistente.");
		}
	}

	public void showAppointmentsperService(String serviceName) {
		Service service = this.getService(serviceName);
		int serviceCounter = 0;
		if(service != null) {
			for(Appointment i : this.getAppointmentList()) {
				if(i.getService().getName().equalsIgnoreCase(service.getName())) {
					System.out.println(i.getEmployee().getCategory().getName()
							+ " " + i.getEmployee().getName()
							+ " " + i.getCustomer().getName());
					serviceCounter++;
				}
			}
			if (serviceCounter == 0) {
				System.out.println("Serviço sem marcações.");
			}
		} else {
			System.out.println("Serviço inexistente.");
		}
	}

	public boolean save() {
		// TODO Auto-generated method stub
		// Should check: https://stackoverflow.com/questions/27326226/java-how-do-you-write-arraylist-to-a-binary-file
		return false;
	}

	public boolean load() {
		// TODO Auto-generated method stub
		return false;
	}

}
