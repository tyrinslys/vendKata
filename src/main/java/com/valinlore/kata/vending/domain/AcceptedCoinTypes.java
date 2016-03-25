package com.valinlore.kata.vending.domain;

/**
 * This class acts as a store for information about accepted coin types. 
 * @author Tiris Valinlore
 *
 */
public enum AcceptedCoinTypes {
	QUARTER(25, 40, 5, 100, 20),//FIXME: these numbers are guesses. Maybe there are some numbers from the internet I can plug in to be more realistic.
	DIME(10, 15, 2, 10, 4),
	NICKEL(5, 25, 4, 25, 6);
	private int cents;
	private int weightInMilligrams;
	private int weightTolerance;
	private int sizeInMicroMeters;
	private int sizeTolerance;
	private AcceptedCoinTypes(int cents,int weightInMilligrams, int weightTolerance, int sizeInMicroMeters, int sizeTolerance) {
		this.cents = cents;
		this.weightInMilligrams = weightInMilligrams;
		this.weightTolerance = weightTolerance;
		this.sizeInMicroMeters = sizeInMicroMeters;
		this.sizeTolerance = sizeTolerance;

	}
	public int getCents() {
		return cents;
	}
	public int getWeightInMilligrams() {
		return weightInMilligrams;
	}
	public int getWeightTolerance() {
		return weightTolerance;
	}
	public int getSizeInMicroMeters() {
		return sizeInMicroMeters;
	}
	public int getSizeTolerance() {
		return sizeTolerance;
	}
}