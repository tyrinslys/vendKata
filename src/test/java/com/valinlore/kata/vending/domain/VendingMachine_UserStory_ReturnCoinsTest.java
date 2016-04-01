package com.valinlore.kata.vending.domain;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
public class VendingMachine_UserStory_ReturnCoinsTest {
	@Test
	public void testCoinReturn() {
		// Given: a vending machine with 5 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		List<Matcher<Coin>> insertedCoinMatchers = new ArrayList<>();
		for (int index = 0; index < 5; index++) {
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
		while (coinFromReturn != null) {
			returnCoins.add(coinFromReturn);
			coinFromReturn = vendingMachine.takeCoinFromReturn();
		}
		assertThat(returnCoins, containsInAnyOrder(
				insertedCoinMatchers.get(0),
				insertedCoinMatchers.get(1),
				insertedCoinMatchers.get(2),
				insertedCoinMatchers.get(3),
				insertedCoinMatchers.get(4)
				));
		// and: double check more coins in return
		assertThat(vendingMachine.takeCoinFromReturn(), nullValue());
		// and: display goes back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Ignore
	@Test
	public void testcontainsAnyOrder_failing() {
		List<Matcher<Object>> testList = new ArrayList<>();
		List<Object> actualList = new ArrayList<>();
		for (int index = 0; index < 5; index++) {
			Object newObject = new Object();
			testList.add(sameInstance(newObject));
			actualList.add(newObject);
		}
		assertThat(actualList, containsInAnyOrder(testList));

	}
	@Test
	public void testcontainsAnyOrder_passing() {
		List<Matcher<Object>> testList = new ArrayList<>();
		List<Object> actualList = new ArrayList<>();
		for (int index = 0; index < 5; index++) {
			Object newObject = new Object();
			testList.add(sameInstance(newObject));
			actualList.add(newObject);
		}
		assertThat(actualList, containsInAnyOrder(
				testList.get(0),
				testList.get(1),
				testList.get(2),
				testList.get(3),
				testList.get(4)
				));

	}
}
