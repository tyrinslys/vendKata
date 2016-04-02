package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * This test is for the kata found
 * <a href="https://github.com/guyroyse/vending-machine-kata">here</a>.
 * 
 * This one is for the 'Accept Coins' user story
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachine_UserStory_AcceptCoinsTest {

	/**
	 * This test is for the user story titled "Accept Coins"
	 */
	@Test
	public void acceptCoins_testThatDisplayWithNoCoins() {
		// Given: a vending machine with no coins
		VendingMachine vendingMachine = new VendingMachine();
		fillTheMachineWithChange(vendingMachine);
		// When: no coins have been added.
		// Then: insert coin message is displayed
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
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
		assertThat(vendingMachine.viewDisplay(), not(INSERT_COIN));
		// and: display updated to coin amount
		assertThat(vendingMachine.viewDisplay(), is("$0.25"));
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
		assertThat(vendingMachine.viewDisplay(), not(INSERT_COIN));
		// and: display updated to coin amount
		assertThat(vendingMachine.viewDisplay(), is("$0.10"));
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
		assertThat(vendingMachine.viewDisplay(), not(INSERT_COIN));
		// and: display updated to coin amount
		assertThat(vendingMachine.viewDisplay(), is("$0.05"));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), emptyCollectionOf(Coin.class));
	}

	@Test
	public void rejectedCoins_testPenny() {
		// Setup: a coin for future use
		Coin coin = new Penny();

		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		fillTheMachineWithChange(vendingMachine);
		// When: insert a coin
		vendingMachine.insert(coin);
		// Then: Insert coin message stays
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
		// and: coin is accepted (one coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), hasSize(1));

	}

	@Test
	public void rejectedCoins_testPenny_canRemoveRejectedCoin() {
		// Setup: a coin for future use
		Coin coin = new Penny();

		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		fillTheMachineWithChange(vendingMachine);
		// and: insert a coin
		vendingMachine.insert(coin);
		// When: I can remove the coin from the machine
		Coin coinFromReturn = vendingMachine.takeCoinFromReturn();
		// Then: coin is the same one I passed in
		assertThat(coinFromReturn, sameInstance(coin));
		// and: Insert coin message still around
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
		// and: coin is accepted (no coins in the coin return)
		assertThat(vendingMachine.peekCoinReturn(), emptyCollectionOf(Coin.class));
	}
}
