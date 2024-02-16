package program;

import java.util.Locale;
import java.util.Scanner;

import entities.Bill;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		  Scanner sc = new Scanner(System.in);

			Bill client = new Bill();
		  
			System.out.print("Entre com os dados do cliente: ");

			do{
				System.out.print("Sexo (M / F): ");
				client.gender = sc.next().charAt(0);
			} while(client.gender != 'M' && client.gender != 'm' && client.gender != 'F' 
					&& client.gender != 'f');
			
			System.out.print("Quantidade de cervejas: ");
			client.beer = sc.nextInt();
			System.out.print("Quantidade de refrigerantes: ");
		  	client.softDrink = sc.nextInt();
			System.out.print("Quantidade de espetinhos: ");
		  	client.barbecue = sc.nextInt();

		  	System.out.println();
			System.out.println("RELATORIO");
			System.out.println("Consumo: " + client.feeding());
			System.out.println(client.feeding() > 30 ? "Isento de couvert" : "Couvert: " + client.cover());
			System.out.println("Ingresso: " + client.ticket());
			System.out.println("");
			System.out.println("Total a pagar: " + client.total());

		  	sc.close();

	}

}
