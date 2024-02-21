package application;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> payer = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int N = sc.nextInt();
		
		
		for(int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Digite os dados do " + (i+1) + "º contribuinte: ");
			System.out.print("Renda anual com salário: ");
			double salary = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double services = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capital = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double health = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double education = sc.nextDouble();
			
			TaxPayer taxPayer = new TaxPayer(salary, services, capital, health, education);
			
			payer.add(taxPayer);
		}
		
		for(TaxPayer list: payer) {
			int i = 1;
			System.out.println();
			System.out.println("Resumo do " + i + "º contribuinte:");
			System.out.printf("Imposto bruto total: R$%.2f%n", list.grossTax());
			System.out.printf("Abatimento: %.2f%n", list.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", list.netTax());
			System.out.println();
			i++;
		}
		
		sc.close();

	}

}
