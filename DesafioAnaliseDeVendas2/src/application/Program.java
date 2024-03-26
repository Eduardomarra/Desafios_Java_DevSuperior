package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file path: ");
		String path = sc.nextLine();
		
		List<Sale> saleList = new ArrayList<>();
		Map<String, Double> mapSale = new HashMap<String, Double>();
		
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
				
				mapSale.put(seller, total);
				
				line = br.readLine();
			}
			
			System.out.println();
			System.out.println("Total sale per seller:");
			for(String key: mapSale.keySet()) {
				double sum = saleList.stream()
						.filter(s -> s.getSeller().contains(key))
						.map(s -> s.getTotal())
						.reduce(0.0, (x, y) -> x + y);
				
				System.out.println(key + " - R$ " + String.format("%.2f", sum));
			}
				
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		
		
		
		
		
		
		sc.close();
		

	}

}
