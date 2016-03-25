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
	public void acceptCoins_testThatAccepQuarters() {
		//Setup: a coin for future use
		Coin coin = createCoin(AcceptedCoinTypes.QUARTER);
		
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.insert(coin );
		// Then: Insert coin message goes away
		assertThat(vendingMachine.getDisplay(), not(INSERT_COIN));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), emptyCollectionOf(Coin.class));
	}

	private Coin createCoin(AcceptedCoinTypes acceptedCoin) {
		return new Coin(acceptedCoin.weight(), acceptedCoin.size());
	}
}
