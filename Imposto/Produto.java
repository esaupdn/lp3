package Imposto;

import java.util.ArrayList;
import java.util.List;

public class Produto {
	private String nome;
	private double precoCusto;
	private List<Imposto> impostos; 
	private double margemLucro;
	public Produto(String nome, double precoCusto, double margemLucro) {
	this.nome = nome;
	this.precoCusto = precoCusto;
	this.impostos = new ArrayList<>();
	this.margemLucro = margemLucro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public List<Imposto> getImpostos() {
		return impostos;
	}
	public void setImpostos(List<Imposto> impostos) {
		this.impostos = impostos;
	}

	public double getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}
	public void insereImposto(Imposto imposto) {
		impostos.add(imposto);
	}
	public void removeImposto(Imposto imposto) {
		impostos.remove(imposto);
	}
	
	public double calcularPrecoVenda() {
		double precoImpostos = 0.0;
		
		for(Imposto imposto : impostos) {
			precoImpostos += precoCusto * imposto.getTaxa();
		}
		
		double precoMargem = precoCusto + precoImpostos;
		double precoFinal = precoMargem + (precoMargem * this.margemLucro);
		
		return precoFinal;
	}
	
	public String MostraImposto() {
		String linha = "";
		for(Imposto imposto: impostos) {
			linha += imposto.getNome().concat(","); 
		}
		return linha;
	}
	
	public void imprimeResultado(double precoVenda) {
		System.out.println(this.nome);
    	System.out.println(String.format("Preco de venda: R$%.2f\n", precoVenda));
	}
}
