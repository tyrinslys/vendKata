package com.valinlore.kata.vending.domain;

/**
 * This class acts as a store for information about accepted coin types. 
 * @author Tiris Valinlore
 *
 */
public enum AcceptedCoinTypes {
	// These sizes were pulled from the US mint website. tolerances are calculated to be %1
	QUARTER(25, 5670, 57, 24260, 243),
	DIME(10, 2268, 23, 17910, 179),
	NICKEL(5, 5000, 50, 21210, 212);
	private int cents;
	private int weightInMilligrams;
	private int weightTolerance;
	private int diameterInMicroMeters; //(diameter)
	private int sizeTolerance;
	private AcceptedCoinTypes(int cents,int weightInMilligrams, int weightTolerance, int sizeInMicroMeters, int sizeTolerance) {
		this.cents = cents;
		this.weightInMilligrams = weightInMilligrams;
		this.weightTolerance = weightTolerance;
		this.diameterInMicroMeters = sizeInMicroMeters;
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
	public int getDiameterInMicroMeters() {
		return diameterInMicroMeters;
	}
	public int getDiameterTolerance() {
		return sizeTolerance;
	}
}