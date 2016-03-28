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
public class VendingMachine_UserStory_MakeChangeTest {
	public static final String PRICE_COLA = "$1.00";
	public static final String PRICE_CHIPS = "$0.50";
	public static final String PRICE_CANDY = "$0.65";

	@Test
	public void testOverPaid_cola() {
		// Given: a vending machine with 5 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		// When: press cola button
		vendingMachine.pressColaButton();
		// Then: change is made
		Coin coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: no more coins in return
		assertThat(vendingMachine.takeCoinFromReturn(), nullValue());
	}

	@Test
	public void testOverPaid_chips() {
		// Given: a vending machine with 4 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		// When: press chips button
		vendingMachine.pressChipsButton();
		// Then: change is made
		Coin coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// And: and another coin is available
		coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.QUARTER.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.QUARTER.getDiameterInMicroMeters()));
		// and: no more coins in return
		assertThat(vendingMachine.takeCoinFromReturn(), nullValue());
	}

	@Test
	public void testOverPaid_candy() {
		// Given: a vending machine with 5 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		// When: press cola button
		vendingMachine.pressCandyButton();
		// Then: change is made
		Coin coinFromReturn = vendingMachine.takeCoinFromReturn();
		assertThat(coinFromReturn.getWeight(), is(AcceptedCoinTypes.DIME.getWeightInMilligrams()));
		assertThat(coinFromReturn.getSize(), is(AcceptedCoinTypes.DIME.getDiameterInMicroMeters()));
		// and: no more coins in return
		assertThat(vendingMachine.takeCoinFromReturn(), nullValue());
	}
}
