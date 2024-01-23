import java.util.Locale;
import java.util.Scanner;

public class DesafioImposto {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double salarioAnual, salarioMensal, servicoAnual, ganhoCapitalAnual, gastoMedico, gastoEducacao,
		impostoSalario, impostoServico, impostoCapital, maxDeducoes, impostoBruto, gastosDedutiveis, abatimento = 0;
		
		System.out.print("Renda anual com salário: ");
		salarioAnual = sc.nextDouble();
		
		System.out.print("Renda anual com prestação de serviços: ");
		servicoAnual = sc.nextDouble();
		
		System.out.print("Renda anual com ganho de capital: ");
		ganhoCapitalAnual = sc.nextDouble();
		
		System.out.print("Gastos médicos: ");
		gastoMedico = sc.nextDouble();
		
		System.out.print("Gastos educacionais: ");
		gastoEducacao = sc.nextDouble();
		
		salarioMensal = salarioAnual / 12;
		gastosDedutiveis = gastoMedico + gastoEducacao;
		
		
		if(salarioMensal < 3000 ) {
			impostoSalario = salarioAnual * 0;
			impostoServico = servicoAnual * 0.15;
			impostoCapital = ganhoCapitalAnual * 0.2;
		} else if (salarioMensal >=3000 && salarioMensal <5000) {
			impostoSalario = salarioAnual * 0.1;
			impostoServico = servicoAnual * 0.15;
			impostoCapital = ganhoCapitalAnual * 0.2;
		} else {
			impostoSalario = salarioAnual * 0.2;
			impostoServico = servicoAnual * 0.15;
			impostoCapital = ganhoCapitalAnual * 0.2;
		}
		
		maxDeducoes = (impostoSalario + impostoServico + impostoCapital) * 0.3;
		impostoBruto = impostoSalario + impostoServico + impostoCapital;
		
		if(gastosDedutiveis < maxDeducoes) {
			abatimento = gastosDedutiveis;
		} else {
			abatimento = maxDeducoes;
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		System.out.println("");
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
		System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
		System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);
		
		System.out.println("");
		System.out.println("");
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f%n", maxDeducoes);
		System.out.printf("Gastos dedutíveis: %.2f%n", gastoMedico + gastoEducacao);
		
		System.out.println("");
		System.out.println("");
		System.out.println("RESUMO:");
		System.out.printf("Imposto total bruto: %.2f%n", impostoBruto);
		System.out.printf("Abatimento: %.2f%n", abatimento);
		System.out.printf("Imposto devido: %.2f%n", impostoBruto - abatimento);
		
		sc.close();

	}

}
