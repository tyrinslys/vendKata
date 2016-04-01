package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		// When: press coin Return button
		vendingMachine.pressCoinReturn();
		// Then: change is made
		assertThat(vendingMachine.peekCoinReturn(), hasSize(5));
		// and: you can grab coin
		Coin coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: you can grab coin
		coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: you can grab coin
		coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: you can grab coin
		coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: you can grab coin
		coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: no more coins in return
		assertThat(vendingMachine.takeCoinFromReturn(), nullValue());
		// and: display goes back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}
}
