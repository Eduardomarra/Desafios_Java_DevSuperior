package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file path: ");
		String path = sc.nextLine();
		
		List<Sale> saleList = new ArrayList<>();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				int month = Integer.parseInt(fields[0]);
				int year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				int items = Integer.parseInt(fields[3]);
				double total = Double.parseDouble(fields[4]);
				
				saleList.add(new Sale(month, year, seller, items, total));
				
				line = br.readLine();
			}
			
			List<Sale> stmSale = saleList.stream()
					.filter(s -> s.getYear() == 2016)
					.sorted((s1, s2) -> s2.averagePrice().compareTo(s1.averagePrice()))
					.limit(5)
					.collect(Collectors.toList());
			
			System.out.println();
			System.out.println("First five sales of 2016 with the highest average price:");
			stmSale.forEach(System.out::println);
			
			
			double sum = saleList.stream()
					.filter(s -> s.getMonth() == 1 || s.getMonth() == 7)
					.filter(s -> s.getSeller().equals("Logan"))
					.map(s -> s.getTotal())
					.reduce(0.0, (x, y) -> x + y);
					

			System.out.println();
			System.out.print("Total value sold by seller Logan in months 1 and 7 = " + sum);
				
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		
		
		
		
		
		
		sc.close();
		

	}

}
