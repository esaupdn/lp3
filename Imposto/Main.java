package Imposto;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		Imposto icms = new Imposto("icms", 0.07);
		Imposto confins = new Imposto("confins", 0.12);
		Imposto ipi = new Imposto("ipi", 0.08);
		Imposto iss = new Imposto("iss", 0.05);
		Imposto cide = new Imposto("cide", 0.10);
		Imposto csll = new Imposto("csll", 0.04);
        
        List<Produto> prod = new ArrayList<>();
        
        Produto arroz = new Produto("arroz", 7.00, 0.20);
        arroz.insereImposto(icms);
        arroz.insereImposto(confins);
        arroz.insereImposto(iss);
        
        Produto feijao = new Produto("feijao", 7.00, 0.25);
        feijao.insereImposto(icms);
        feijao.insereImposto(confins);
        feijao.insereImposto(iss);
        
        Produto carne = new Produto("carne", 7.00, 0.35);
        carne.insereImposto(confins);
        carne.insereImposto(icms);
        carne.insereImposto(ipi);
        
        Produto cerveja = new Produto("cerveja", 7.00, 0.30);
        cerveja.insereImposto(confins);
        cerveja.insereImposto(icms);
        cerveja.insereImposto(iss);
        cerveja.insereImposto(ipi);
        
        Produto gas = new Produto("gas", 7.00, 0.15);
        gas.insereImposto(confins);
        gas.insereImposto(icms);
        gas.insereImposto(ipi);
        
        Produto gasolina = new Produto("gasolina", 7.00, 0.15);
        gasolina.insereImposto(confins);
        gasolina.insereImposto(icms);
        gasolina.insereImposto(cide);
        
        prod.add(arroz);
        prod.add(feijao);
        prod.add(carne);
        prod.add(cerveja);
        prod.add(gas);
        prod.add(gasolina);
        
        for(Produto produto : prod) {
        	double precoVenda = produto.calcularPrecoVenda();
        	produto.imprimeResultado(precoVenda);
        }
	}

}
