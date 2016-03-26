package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * This test is for the kata found
 * <a href="https://github.com/guyroyse/vending-machine-kata">here</a>.
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachineTest {

	private static final String INSERT_COIN = "INSERT COIN";

	/**
	 * This test is for the user story titled "Accept Coins"
	 */
	@Test
	public void acceptCoins_testThatDisplayWithNoCoins() {
		// Given: a vending machine with no coins
		VendingMachine vendingMachine = new VendingMachine();
		// When: no coins have been added.
		// Then: insert coin message is displayed
		assertThat(vendingMachine.getDisplay(), is(INSERT_COIN));
	}

	@Test
	public void acceptCoins_testQuarter() {
		// Setup: a coin for future use
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER);

		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.insert(coin);
		// Then: Insert coin message goes away
		assertThat(vendingMachine.getDisplay(), not(INSERT_COIN));
		// and: display updated to coin amount
		assertThat(vendingMachine.getDisplay(), is("$0.25"));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), emptyCollectionOf(Coin.class));
	}
	@Test
	public void acceptCoins_testDime() {
		// Setup: a coin for future use
		Coin coin = createCoin(AcceptedCoinTypes.DIME);

		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.insert(coin);
		// Then: Insert coin message goes away
		assertThat(vendingMachine.getDisplay(), not(INSERT_COIN));
		// and: display updated to coin amount
		assertThat(vendingMachine.getDisplay(), is("$0.10"));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), emptyCollectionOf(Coin.class));
	}
	@Test
	public void acceptCoins_testNickel() {
		// Setup: a coin for future use
		Coin coin = createCoin(AcceptedCoinTypes.NICKEL);

		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.insert(coin);
		// Then: Insert coin message goes away
		assertThat(vendingMachine.getDisplay(), not(INSERT_COIN));
		// and: display updated to coin amount
		assertThat(vendingMachine.getDisplay(), is("$0.05"));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), emptyCollectionOf(Coin.class));
	}
	@Test
	public void rejectedCoins_testPenny() {
		// Setup: a coin for future use
		Coin coin = new Penny();

		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.insert(coin);
		// Then: Insert coin message goes away
		assertThat(vendingMachine.getDisplay(), is(INSERT_COIN));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), hasSize(1));
	}

	static Coin createCoin(AcceptedCoinTypes acceptedCoin) {
		return createCoin(acceptedCoin, 0, 0);
	}

	static Coin createCoin(AcceptedCoinTypes acceptedCoin, int addWeight, int addSize) {
		return new Coin(acceptedCoin.getWeightInMilligrams() + addWeight,
				acceptedCoin.getDiameterInMicroMeters() + addSize);
	}
	public static class Penny extends Coin {
		private static final int PENNY_WEIGHT = 2500; // miligrams
		private static final int PENNY_DIAMETER = 19050; // micrometers
		public Penny(){
			super(PENNY_WEIGHT, PENNY_DIAMETER);
		}
	}
}
