package com.valinlore.kata.vending.domain;

public class Coin {
	private final int weight;
	private final int size;

	/**
	 * @param weight
	 *            In micrograms
	 * @param size
	 *            in micrometers
	 */
	public Coin(int weight, int size) {
		this.weight = weight;
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public int getSize() {
		return size;
	}
}
