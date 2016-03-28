package com.valinlore.kata.vending.domain;

public class Product {
	private int costOfProductInCents;

	public Product(int costOfProductInCents) {
		this.costOfProductInCents = costOfProductInCents;
	}

	public int getCostOfProductInCents() {
		return costOfProductInCents;
	}
}
