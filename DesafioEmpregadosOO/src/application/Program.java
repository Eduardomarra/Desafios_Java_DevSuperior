package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nameDepartment, email, phone;
		Integer payDay, numberEmployee;
		
		System.out.print("Nome do departamento: ");
		nameDepartment = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		payDay = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.print("Telefone: ");
		phone = sc.nextLine();
		Address address = new Address(email, phone);		
		Department department = new Department(nameDepartment, payDay, address);
		
		
		System.out.print("Quantos funcionários tem o departamento? ");
		numberEmployee = sc.nextInt();
		for(int i = 0; i < numberEmployee; i++) {
			System.out.println("Dados do funcionário " + (i + 1) +": "); 
			System.out.print("Nome: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
						
			department.addEmployee(new Employee(name, salary));
		}
		System.out.println();
		showReport(department);
		sc.close();
	}
	
	public static void showReport(Department department) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.print("Departamento" + department.getName() + " = ");
		System.out.println("R$ " + department.payroll());
		System.out.println("Pagamento realizado no dia " + department.getPayDay());
		System.out.println("Funcionários:");
		for(Employee e: department.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
	}

}
