package com.valinlore.kata.vending.domain;

/**
 * This class has methods sharred across tests for user stories
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachineTestUtils {

	public static final String INSERT_COIN = "INSERT COIN";

	public static Coin createCoin(AcceptedCoinTypes acceptedCoin) {
		return createCoin(acceptedCoin, 0, 0);
	}

	public static Coin createCoin(AcceptedCoinTypes acceptedCoin, int addWeight, int addSize) {
		return new Coin(acceptedCoin.getWeightInMilligrams() + addWeight,
				acceptedCoin.getDiameterInMicroMeters() + addSize);
	}

	public static class Penny extends Coin {
		private static final int PENNY_WEIGHT = 2500; // miligrams
		private static final int PENNY_DIAMETER = 19050; // micrometers

		public Penny() {
			super(PENNY_WEIGHT, PENNY_DIAMETER);
		}
	}
}
