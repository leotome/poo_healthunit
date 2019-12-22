package healthunit.controllers;

public interface HealthUnit {
	void initializeCategories();
	void initializeAgeRange();
	
	void createCustomer(String name, String ageRange);
	void createEmployee(String name, String category);
	void createFamily(String familyName);
	
	void associateCustomertoFamily(String customerName, String familyName);
	void deassociateCustomertoFamily(String customerName, String familyName);
	
	void listCustomers();
	void listEmployees();
	void listFamilies();
	
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
