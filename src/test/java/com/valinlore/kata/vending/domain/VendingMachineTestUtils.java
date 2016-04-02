package com.valinlore.kata.vending.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public static void addChange(VendingMachine vendingMachine, AcceptedCoinTypes coinType, int quantity){
		for(int index = 0; index <= quantity; index++){
			vendingMachine.addChange(coinType, Arrays.asList(createCoin(coinType)));
		}
	}
	/**
	 * fills the vending machine with change. 100 coins each type
	 * @param vendingMachine
	 */
	public static void fillTheMachineWithChange(VendingMachine vendingMachine){
		List<Coin> coins = new ArrayList<>();
		for (int index = 0; index < 100; index++) {
			coins.add(createCoin(AcceptedCoinTypes.QUARTER));
		}
		vendingMachine.addChange(AcceptedCoinTypes.QUARTER, coins);
		for (int index = 0; index < 100; index++) {
			coins.add(createCoin(AcceptedCoinTypes.DIME));
		}
		vendingMachine.addChange(AcceptedCoinTypes.DIME, coins);
		for (int index = 0; index < 100; index++) {
			coins.add(createCoin(AcceptedCoinTypes.NICKEL));
		}
		vendingMachine.addChange(AcceptedCoinTypes.NICKEL, coins);
	}

	public static class Penny extends Coin {
		private static final int PENNY_WEIGHT = 2500; // miligrams
		private static final int PENNY_DIAMETER = 19050; // micrometers

		public Penny() {
			super(PENNY_WEIGHT, PENNY_DIAMETER);
		}
	}
}
