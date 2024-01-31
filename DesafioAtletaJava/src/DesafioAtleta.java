import java.util.Locale;
import java.util.Scanner;

public class DesafioAtleta {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int quantidadeAtletas, countM = 0, countF = 0;
		double alturaAtleta, maxAltura = 0.0, pesoAtleta, pesoMedioAtletas = 0.0, somaPesos = 0.0, somaAlturaMulheres = 0.0, alturaMediaMulheres = 0.0, percentHomens = 0.0;
		String nomeAtleta, atletaMaisAlto = "";
		char sexoAtleta;
		
		System.out.print("informe a quantidade de atletas: ");
		quantidadeAtletas = sc.nextInt();
		
		for (int x = 1; x <= quantidadeAtletas; x++) {
			System.out.println("Digite os dados do atleta nº " + x + ": ");
			
			System.out.print("Nome: ");
			nomeAtleta = sc.next();
			sc.nextLine();
						
			
			do {
	            System.out.print("Informe o sexo do atleta. Digite 'M' ou 'F': ");
	            sexoAtleta = sc.next().charAt(0);
	            if (sexoAtleta != 'M' && sexoAtleta != 'F' && sexoAtleta != 'm' && sexoAtleta != 'f') {
	                System.out.print("Sexo inválido. Digite 'M' ou 'F': "); 
	            }
	            
	        } while (sexoAtleta != 'M' && sexoAtleta != 'F' && sexoAtleta != 'm' && sexoAtleta != 'f');
			
			do {
				System.out.print("Altura: ");
				alturaAtleta = sc.nextDouble();
				
				if(alturaAtleta > maxAltura) {
				    maxAltura = alturaAtleta;
				    atletaMaisAlto = nomeAtleta;
				} 
				
				if(alturaAtleta <= 0) {
					System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				}
				
			} while (alturaAtleta <= 0);	
			
			
			
			
			
			do {
				System.out.print("Peso: ");
				pesoAtleta = sc.nextDouble();
				
				if(pesoAtleta <= 0) {
					System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				}
			} while (pesoAtleta <= 0);			
			
			//Cálculo da média dos pesos
			somaPesos += pesoAtleta;
			pesoMedioAtletas = somaPesos/quantidadeAtletas;			
            
			//Verificar quantidade de homens
            if (sexoAtleta == 'M' || sexoAtleta == 'm') {
				countM += 1;
			}	
            
            //Cálculo da média da altura das mulheres
            if (sexoAtleta == 'F' || sexoAtleta == 'f') {
				somaAlturaMulheres += alturaAtleta;
				countF += 1;
				alturaMediaMulheres = somaAlturaMulheres / countF;
			}
            
            System.out.println();
		}		
				
		//Cálculo do percentual de homens
		percentHomens = (countM * 100) / quantidadeAtletas;
		
		System.out.printf("Média pesos: %.2f %n", pesoMedioAtletas);
		System.out.println("Atleta mais alto: " + atletaMaisAlto);
		System.out.printf("Porcentagem de homens: %.1f %%%n", percentHomens);
		
		if (alturaMediaMulheres <= 0) {
			System.out.printf("Não há mulheres cadastradas");
		} else {
			System.out.printf("Altura média das mulheres: %.2f %n", alturaMediaMulheres);
		}
		
		
		
		sc.close();

	}

}
