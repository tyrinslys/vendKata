package com.valinlore.kata.vending.domain;

import org.hamcrest.Matcher;
import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This test is for the kata found
 * <a href="https://github.com/guyroyse/vending-machine-kata">here</a>.
 * 
 * This one is for 'Make Change' user story.
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachine_UserStory_ReturnCoinsTest  {
	@Test
	public void testCoinReturn() {
		// Given: a vending machine with 5 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		List<Matcher<Coin>> insertedCoinMatchers = new ArrayList<>();
		for(int index = 0; index < 5; index++){
			Coin coin = createCoin(AcceptedCoinTypes.QUARTER);
			vendingMachine.insert(coin);
			Matcher<Coin> coinMatcher = sameInstance(coin);
			insertedCoinMatchers.add(coinMatcher);
		}
		// When: press coin Return button
		vendingMachine.pressCoinReturn();
		// Then: change is made
		assertThat(vendingMachine.peekCoinReturn(), hasSize(5));
		// and: you can grab all the coins that were inserted
		List<Coin> returnCoins = new ArrayList<>();
		Coin coinFromReturn = vendingMachine.takeCoinFromReturn();
		while(coinFromReturn != null){
			returnCoins.add(coinFromReturn);
			coinFromReturn = vendingMachine.takeCoinFromReturn();
		}
		assertThat(returnCoins, contains(insertedCoinMatchers));
		// and: double check more coins in return
		assertThat(vendingMachine.takeCoinFromReturn(), nullValue());
		// and: display goes back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}
}
