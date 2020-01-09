package healthunit.controllers;

import java.io.IOException;
import java.util.List;

import healthunit.models.Appointment;
import healthunit.models.Customer;
import healthunit.models.Employee;
import healthunit.models.Family;

public interface HealthUnit {
	void initializeAll();

	List<Appointment> getAppointmentList();
	List<Customer> getCustomerList();
	List<Employee> getEmployeeList();
	List<Family> getFamilyList();

	void createCustomer(String name, String ageRangeName);
	void createEmployee(String name, String categoryName);
	void createFamily(String familyName) ;

	void associateCustomertoFamily(String customerName, String familyName);

	void deassociateCustomertoFamily(String customerName);

	void listEmployees();
	void listFamilies();
	void listCustomers();

	void showFamily(String familyName);

	void createAppointment(String customerName) throws IOException;
	void cancelAppointment(String customerName);

	void showAppointmentstoCustomer(String customerName);
	void showAppointmentstoFamily(String familyName);
	void showAppointmentstoEmployee(String category, String employeeName);
	void showAppointmentsperService(String serviceName);

}
//update
