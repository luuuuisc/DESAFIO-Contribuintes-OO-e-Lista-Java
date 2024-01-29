package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();
        
        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do " + (i + 1) + "º contribuinte:");
            System.out.print("Renda anual com salário: ");
            double salaryIncome = sc.nextDouble();

            System.out.print("Renda anual com prestação de serviço: ");
            double serviceIncome = sc.nextDouble();

            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();

            System.out.print("Gastos médicos: ");
            double healthSpending = sc.nextDouble();

            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending);
            taxPayers.add(taxPayer);
        }

        for (TaxPayer tp : taxPayers) {
            System.out.println();
            System.out.println("RESUMO DO IMPOSTO: ");
            System.out.printf("Imposto sobre salário: %.2f%n", tp.salaryTax());
            System.out.printf("Imposto sobre serviço: %.2f%n", tp.servicesTax());
            System.out.printf("Imposto sobre capital: %.2f%n", tp.capitalTax());
            System.out.printf("Imposto bruto: %.2f%n", tp.grossTax());
            System.out.printf("Abatimento: %.2f%n", tp.taxRebate());
            System.out.printf("Imposto líquido: %.2f%n", tp.netTax());
        }

        sc.close();
	}

}
