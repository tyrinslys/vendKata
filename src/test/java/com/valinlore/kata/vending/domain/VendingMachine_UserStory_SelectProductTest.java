package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * This test is for the kata found
 * <a href="https://github.com/guyroyse/vending-machine-kata">here</a>.
 * 
 * This one is for 'Select Product' user story.
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachine_UserStory_SelectProductTest {
	public static final String PRICE_COLA = "$1.00";
	public static final String PRICE_CHIPS = "$$0.50";
	public static final String PRICE_CANDY = "$0.65";

	@Test
	public void testDisplayPrice_cola() {
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.pressColaButton();
		// Then: Price of cola is displayed
		assertThat(vendingMachine.getDisplay(), is(PRICE_COLA));
		// and: on second look display is back to default message
		assertThat(vendingMachine.getDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_chips() {
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.pressChipsButton();
		// Then: Price of chips is displayed
		assertThat(vendingMachine.getDisplay(), is(PRICE_CHIPS));
		// and: on second look display is back to default message
		assertThat(vendingMachine.getDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_candy() {
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: insert a coin
		vendingMachine.pressCandyButton();
		// Then: Price of candy is displayed
		assertThat(vendingMachine.getDisplay(), is(PRICE_CANDY));
		// and: on second look display is back to default message
		assertThat(vendingMachine.getDisplay(), is(INSERT_COIN));
	}

}
