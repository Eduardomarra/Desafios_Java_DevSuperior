package program;

import java.util.Scanner;

import entities.Champion;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite os dados do primeiro campeão:");
		Champion champion1 = new Champion();
		System.out.print("Nome: ");
		champion1.setName(sc.nextLine());
		System.out.print("Vida inicial: ");
		champion1.setLife(sc.nextInt());
		System.out.print("Ataque: ");
		champion1.setAttack(sc.nextInt());
		System.out.print("Armadura: ");
		champion1.setArmor(sc.nextInt());
		sc.nextLine();

		System.out.println();
		  
		System.out.println("Digite os dados do Segundo campeão:");
		Champion champion2 = new Champion();
		System.out.print("Nome: ");
		champion2.setName(sc.nextLine());
		System.out.print("Vida inicial: ");
		champion2.setLife(sc.nextInt());
		System.out.print("Ataque: ");
		champion2.setAttack(sc.nextInt());
		System.out.print("Armadura: ");
		champion2.setArmor(sc.nextInt());

		System.out.println();
		System.out.print("Quantos turnos você deseja executar? ");
		int turnos = sc.nextInt();
		System.out.println();

		for(int i = 1; i <= turnos; i++) {

			champion1.takeDamage(champion1, champion2);

			System.out.println("Resultado do turno " + i + ":");
			System.out.println(Champion.status(champion1));
			System.out.println(Champion.status(champion2));
			System.out.println();

			if(champion1.getLife() < 1 || champion2.getLife() < 1){
				i = turnos;
			};		
		}
		  
		System.out.println();
		System.out.println("FIM DE COMBATE");

		sc.close();
	}

}
