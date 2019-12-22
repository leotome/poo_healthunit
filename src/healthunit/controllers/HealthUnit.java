package healthunit.controllers;

import java.util.List;

import healthunit.models.Appointment;
import healthunit.models.Category;
import healthunit.models.Service;
import healthunit.models.AgeRange;
import healthunit.models.Customer;
import healthunit.models.Employee;
import healthunit.models.Family;

public interface HealthUnit {
	void initializeCategories();
	void initializeAgeRange();
	void initializeServices();

	Category getCategory(String categoryName);
	AgeRange getAgeRange(String ageRangeName);
	Service getService(String serviceName);

	Customer getCustomer(String customerName);
	Family getFamily(String familyName);
	Employee getEmployee(String employeeName);

	List<Appointment> getAppointmentList();
	List<Customer> getCustomerList();
	List<Employee> getEmployeeList();
	List<Family> getFamilyList();

	void createCustomer(String name, String ageRangeName);
	void createEmployee(String name, String categoryName);
	void createFamily(String familyName) ;

	void associateCustomertoFamily(String customerName, String familyName);

	void deassociateCustomertoFamily(String customerName, String familyName);

	void listEmployees();
	void listFamilies();
	void listCustomers();

	void showFamily(String familyName);

	void createAppointment(String customerName, String service, String employeeName);
	void cancelAppointment(String customerName);

	void showAppointmentstoCustomer(String customerName);
	void showAppointmentstoFamily(String familyName);
	void showAppointmentstoEmployee(String category, String employeeName);
	void showAppointmentsperService(String serviceName);

	boolean save();
	boolean load();
}
