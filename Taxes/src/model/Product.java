package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice;
	private double profit;
	private List<Tax> taxes;
	private boolean industrialized;
	private String origin;

	public Product(String name, double costPrice, double profit, String origin) throws Exception {
		setName(name);
		setCostPrice(costPrice);
		setProfit(profit);
		setOrigin(origin);
		this.industrialized = false;
		this.taxes = new ArrayList<>();
	}

	public double calculateSalePrice() {
		double taxSum = 0;
		for (Tax tax : taxes) {
			taxSum += tax.calculate(this);
		}

		double finalCost = this.costPrice + taxSum;

		double finalPrice = finalCost + (finalCost * profit);
		return finalPrice;
	}

	public boolean addTax(Tax objTax) throws Exception {
		if (objTax == null)
			throw new Exception("imposto não pode ser nulo");

		if (taxes.contains(objTax))
			return false;
		else {
			if (objTax.getAbbr().equals("IPI"))
				this.industrialized = true;

			taxes.add(objTax);
		}

		return true;
	}

	public String getName() {
		return this.name;
	}

	public String getOrigin() {
		return this.origin;
	}

	public boolean getIndustrialized() {
		return this.industrialized;
	}

	public double getCostPrice() {
		return this.costPrice;
	}

	public double getProfit() {
		return this.profit;
	}

	private void setOrigin(String origin) throws Exception {
		origin = origin.substring(0, 1).toUpperCase() + origin.substring(1).toLowerCase();
		if (origin == null || origin.equals("") || !origin.equals("nacional") && !origin.equals("importado"))
			throw new Exception("origem inválida");

		this.origin = origin;
	}

	private void setProfit(double profit) throws Exception {
		if (profit <= 0)
			throw new Exception("margem de lucro inválida");

		this.profit = profit / 100;
	}

	private void setCostPrice(double costPrice) throws Exception {
		if (costPrice <= 0)
			throw new Exception("preço de custo inválido");

		this.costPrice = costPrice;
	}

	private void setName(String name) throws Exception {
		if (name == null || name.equals(""))
			throw new Exception("nome inválido");

		this.name = name;
	}

}