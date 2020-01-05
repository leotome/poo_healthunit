package healthunit.app;

import java.util.Scanner;
import java.io.*;

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
				if(commands.length == 3) {
					healthunit.createEmployee(commands[1], commands[2]);	
				} else {
					System.out.println("Instrução inválida.");
				}
				break;
			case "RU":
				if(commands.length == 3) {
					healthunit.createCustomer(commands[1], commands[2]);
				} else {
					System.out.println("Instrução inválida.");
				}
				break;
			case "RF":
				if(commands.length == 2) {
					healthunit.createFamily(commands[1]);	
				} else {
					System.out.println("Instrução inválida.");
				}
				break;
			case "AF":
				if(commands.length == 3) {
					healthunit.associateCustomertoFamily(commands[1], commands[2]);
				} else {
					System.out.println("Instrução inválida.");
				}
				break;
			case "DF":
				if(commands.length == 2) {
					healthunit.deassociateCustomertoFamily(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
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
				if(commands.length == 2) {
					healthunit.showFamily(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
				//Mostrar familia
				break;
			case "MC":
				if(commands.length == 2) {
					healthunit.createAppointment(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
				//Marcar cuidados a utente
				break;
			case "CC":
				if(commands.length == 2) {
					healthunit.cancelAppointment(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
				break;
			case "LCU":
				if(commands.length == 2) {
					healthunit.showAppointmentstoCustomer(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
				//Listar cuidados marcados a utente
				break;
			case "LCF":
				if(commands.length == 2) {
					healthunit.showAppointmentstoFamily(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
				//Listar cuidados marcados a família
				break;
			case "LSP":
				if(commands.length == 3) {
					healthunit.showAppointmentstoEmployee(commands[1], commands[2]);
				} else {
					System.out.println("Instrução inválida.");
				}
				//Listar serviços marcados a profissional
				break;
			case "LMS":
				if(commands.length == 2) {
					healthunit.showAppointmentsperService(commands[1]);
				} else {
					System.out.println("Instrução inválida.");
				}
				//Listar marcações por tipo de serviço
				break;
			case "G":
				boolean stateSave = false;
				try {
					FileOutputStream fileOut = new FileOutputStream("healthunit.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(healthunit);
					out.close();
					fileOut.close();
					stateSave = true;
				} catch(IOException i) {
					i.printStackTrace();
				}
				if(stateSave == true) {
					System.out.println("Unidade de saúde gravada.");
				} else {
					System.out.println("Ocorreu um erro na gravação.");
				}
				//Gravar
				break;
			case "L":
				boolean stateRead = false;
			     try {
			         FileInputStream fileIn = new FileInputStream("healthunit.ser");
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         healthunit = (HealthUnit) in.readObject();
			         in.close();
			         fileIn.close();
			         stateRead = true;
			      } catch (IOException i) {
			         i.printStackTrace();
			      } catch (ClassNotFoundException c) {
			    	  c.printStackTrace();
			      }
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
