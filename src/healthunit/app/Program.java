package healthunit.app;

import java.util.Scanner;

import healthunit.controllers.HealthUnit;
import healthunit.controllers.HealthUnitClass;

public class Program {
	public static void main(String[] args) {
		HealthUnit healthunit = new HealthUnitClass();
		healthunit.initializeCategories();
		healthunit.initializeAgeRange();
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
				healthunit.createEmployee(commands[1], commands[2]);
				break;
			case "RU":
				healthunit.createCustomer(commands[1], commands[2]);
				break;
			case "RF":
				healthunit.createFamily(commands[1]);
				break;
			case "AF":
				break;
			case "DF":
				//Desassociar utente de família
				break;
			case "LP":
				healthunit.listEmployees();
				break;
			case "LU":
				//Listar utentes
				break;
			case "LF":
				//Listar famílias
				break;
			case "MF":
				//Mostrar familia
				break;
			case "MC":
				//Marcar cuidados a utente
				break;
			case "LCU":
				//Listar cuidados marcados a utente
				break;
			case "LCF":
				//Listar cuidados marcados a família
				break;
			case "LSP":
				//Listar serviços marcados a profissional
				break;
			case "LMS":
				//Listar marcações por tipo de serviço
				break;
			case "G":
				//Gravar 
				break;
			case "L":
				//Ler
				break;
			default:
				System.out.println("Instrução inválida.");
			}
		}
		input.close();
	}
		
}
