package view;

import model.Product;
import model.Sale;
import model.SaleItem;

public class Main {

	public static void main(String[] args) {
		
		Product arroz = new Product ("Arroz Pileco T1", 15);
		Product feijao = new Product ("Feijao Malicia ", 20);
		Product sal = new Product("Sal Salgado", 5);
				
		SaleItem siArroz = new SaleItem(arroz,3);
		SaleItem siFeijao = new SaleItem(feijao,2);
		SaleItem siSal = new SaleItem(sal,2);
		
		Sale sale = new Sale();
		sale.addSaleItem(siFeijao);
		sale.addSaleItem(siArroz);
		sale.addSaleItem(siSal);
		
		System.out.println(String.format("Venda - #1234 - %s", sale.getDate().toLocaleString()));
		
		for(SaleItem saleItem : sale.getSaleItems()) {
			System.out.print(saleItem.getProduct().getDescription() + " - ");
			System.out.print(saleItem.getAmount() + " - ");
			System.out.print("R$"+ saleItem.getProduct().getPrice() + " - ");
			System.out.print("R$"+ saleItem.getSaleItemSubTotal()+ "\n");
		}
		System.out.println("Total: R$" +sale.getTotal());
	}

}
