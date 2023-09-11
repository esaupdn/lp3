package view;

import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args) throws Exception {
		Tax ipi = new Tax("IPI", "i.p.i", 8);
		Tax iss = new Tax("ISS", "i.s.s", 5);
		Tax icms = new Tax("ICMS", "i.c.m.s", 5);

		Product arroz = new Product("arroz", 7, 20, "nacional");
		Product feijao = new Product("feijao", 7, 25, "nacional");
		Product carne = new Product("carne", 7, 35, "nacional");
		Product cerveja = new Product("cerveja", 7, 30, "nacional");
		Product gas = new Product("gas", 7, 15, "nacional");
		Product gasolina = new Product("gasolina", 7, 15, "nacional");

		arroz.addTax(icms);
		arroz.addTax(iss);

		feijao.addTax(icms);
		feijao.addTax(iss);

		carne.addTax(icms);
		carne.addTax(ipi);

		cerveja.addTax(icms);
		cerveja.addTax(iss);
		cerveja.addTax(ipi);

		gas.addTax(icms);
		gas.addTax(ipi);

		gasolina.addTax(icms);

			printProduct(arroz);
			printProduct(feijao);
			printProduct(carne);
			printProduct(cerveja);
			printProduct(gas);
			printProduct(gasolina);
	}

	public static void printProduct(Product p) {
		System.out.println("" + p.getName());
		System.out.printf("preço: %.2f\n", p.calculateSalePrice());
	}
}