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
	public static final String PRICE_CHIPS = "$0.50";
	public static final String PRICE_CANDY = "$0.65";
	private static final Object THANK_YOU = "THANK YOU";

	@Test
	public void testDisplayPrice_cola() {
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: press cola button
		vendingMachine.pressColaButton();
		// Then: Price of cola is displayed
		assertThat(vendingMachine.viewDisplay(), is(PRICE_COLA));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_cola_partialPayment() {
		// Given: a vending machine with 3 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressColaButton();
		// Then: Price of cola is displayed
		assertThat(vendingMachine.viewDisplay(), is(PRICE_COLA));
		// and: on second look display is back to amount inserted message
		assertThat(vendingMachine.viewDisplay(), is("$0.75"));
	}

	@Test
	public void testDespenseProduct_cola() {
		// Given: a vending machine with 4 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressColaButton();
		// Then: Cola is despensed
		Product product = vendingMachine.takeProduct();
		assertThat(product, instanceOf(Cola.class));
		// and: Thank you message is displayed
		assertThat(vendingMachine.viewDisplay(), is(THANK_YOU));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_chips() {
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: pres chips button
		vendingMachine.pressChipsButton();
		// Then: Price of chips is displayed
		assertThat(vendingMachine.viewDisplay(), is(PRICE_CHIPS));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_chips_partialPayment() {
		// Given: a vending machine with 1 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press chips button
		vendingMachine.pressChipsButton();
		// Then: Price of cola is displayed
		assertThat(vendingMachine.viewDisplay(), is(PRICE_CHIPS));
		// and: on second look display is back to amount inserted message
		assertThat(vendingMachine.viewDisplay(), is("$0.25"));
	}

	@Test
	public void testDespenseProduct_chips() {
		// Given: a vending machine with 4 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressChipsButton();
		// Then: Cola is despensed
		Product product = vendingMachine.takeProduct();
		assertThat(product, instanceOf(Chips.class));
		// and: Thank you message is displayed
		assertThat(vendingMachine.viewDisplay(), is(THANK_YOU));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_candy() {
		// Given: a vending machine with no coins.
		VendingMachine vendingMachine = new VendingMachine();
		// When: press candy button
		vendingMachine.pressCandyButton();
		// Then: Price of candy is displayed
		assertThat(vendingMachine.viewDisplay(), is(PRICE_CANDY));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplayPrice_candy_partialPayment() {
		// Given: a vending machine with 3 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressCandyButton();
		// Then: Price of cola is displayed
		assertThat(vendingMachine.viewDisplay(), is(PRICE_CANDY));
		// and: on second look display is back to amount inserted message
		assertThat(vendingMachine.viewDisplay(), is("$0.50"));
	}

	@Test
	public void testDespenseProduct_candy() {
		// Given: a vending machine with 4 quarter coins.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.DIME));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.NICKEL));

		// When: press Cola button
		vendingMachine.pressCandyButton();
		// Then: Cola is despensed
		Product product = vendingMachine.takeProduct();
		assertThat(product, instanceOf(Candy.class));
		// and: Thank you message is displayed
		assertThat(vendingMachine.viewDisplay(), is(THANK_YOU));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

}
