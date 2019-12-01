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
				//Registar profissional
				break;
			case "RU":
				//Registar utente
				break;
			case "RF":
				//Registar família
				break;
			case "AF":
				//Associar utente a família
				break;
			case "DF":
				//Desassociar utente de família
				break;
			case "LP":
				//Listar profissionais
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
