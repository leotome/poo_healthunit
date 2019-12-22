package healthunit.app;

import java.util.Scanner;

import healthunit.controllers.HealthUnit;
import healthunit.controllers.HealthUnitClass;

public class Program {
	public static void main(String[] args) {
		HealthUnit healthunit = new HealthUnitClass();
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String line = input.nextLine();
			if(line.isBlank()) {
				input.close();
				System.exit(0);
			}
			String[] commands = line.split(" ");
			switch(commands[0]) {
			case "RP":
				healthunit.createEmployee(commands[1].toUpperCase(), commands[2].toUpperCase());
				break;
			case "RU":
				healthunit.createCustomer(commands[1], commands[2]);
				break;
			case "RF":
				healthunit.createFamily(commands[1]);
				break;
			case "AF":
				healthunit.associateCustomertoFamily(commands[1], commands[2]);
				break;
			case "DF":
				healthunit.deassociateCustomertoFamily(commands[1], commands[2]);
				//Desassociar utente de família
				break;
			case "LP":
				healthunit.listEmployees();
				//Listar profissionais
				break;
			case "LU":
				healthunit.listCustomers();
				//Listar utentes
				break;
			case "LF":
				healthunit.listFamilies();
				//Listar famílias
				break;
			case "MF":
				healthunit.showFamily(commands[1]);
				//Mostrar familia
				break;
			case "MC":
				healthunit.createAppointment(commands[1]);
				//Marcar cuidados a utente
				break;
			case "LCU":
				healthunit.showAppointmentstoCustomer(commands[1]);
				//Listar cuidados marcados a utente
				break;
			case "LCF":
				healthunit.showAppointmentstoFamily(commands[1]);
				//Listar cuidados marcados a família
				break;
			case "LSP":
				healthunit.showAppointmentstoEmployee(commands[1], commands[2]);
				//Listar serviços marcados a profissional
				break;
			case "LMS":
				healthunit.showAppointmentsperService(commands[1]);
				//Listar marcações por tipo de serviço
				break;
			case "G":
				boolean stateSave = healthunit.save();
				if(stateSave == true) {
					System.out.println("Unidade de saúde gravada.");
				} else {
					System.out.println("Ocorreu um erro na gravação.");
				}
				//Gravar 
				break;
			case "L":
				boolean stateRead = healthunit.load();
				if(stateRead == true) {
					System.out.println("Unidade de saúde carregada.");
				} else {
					System.out.println("Ocorreu um erro no carregamento.");
				}
				//Ler
				break;
			default:
				System.out.println("Instrução inválida.");
			}
		}
		input.close();
	}
		
}
