package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Contributors;
import entities.Individual;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Contributors> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int payers = sc.nextInt();
		
		for(int i = 0; i < payers; i++) {
			i++;
			System.out.println("Tax payer #"+i+" data:");
			i--;
			
			System.out.print("Individual or company (i/c)?: ");
			char ic = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.next();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			
			if(ic == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpend = sc.nextDouble();
				list.add(new Individual(name, income, healthExpend));
				
			} else {
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				list.add(new Company(name, income, employees));
			}
		}
		
		System.out.println("\nTAXES PAID");
		for(Contributors x : list) {
			System.out.println(x.toString());
		}
		
		double sum = 0.0;
		for(Contributors x : list) {
			sum += x.taxPaid();
		}
		System.out.println("\nTOTAL TAXES: $"+ String.format("%.2f", sum));
	}

}
