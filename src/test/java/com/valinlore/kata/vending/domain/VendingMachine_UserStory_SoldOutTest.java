package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static com.valinlore.kata.vending.domain.VendingMachineTestUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * This test is for the kata found
 * <a href="https://github.com/guyroyse/vending-machine-kata">here</a>.
 * 
 * This one is for 'Sold Out' user story.
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachine_UserStory_SoldOutTest {
	private static final Object SOLD_OUT = "SOLD OUT";

	@Test
	public void testDisplaySoldOut_noPayment_cola() {
		// Given: a vending machine with no coins and no colas.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		fillTheMachineWithChange(vendingMachine);
		// When: press cola button
		vendingMachine.pressColaButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplaySoldOut_partialPayment_cola() {
		// Given: a vending machine with 3 quarter coins and no colas.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressColaButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is("$0.75"));
	}

	@Test
	public void testDisplaySoldOut_fullPayment_cola() {
		// Given: a vending machine with 4 quarter coins and no colas.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressColaButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is("$1.00"));
	}
	@Test
	public void testDisplaySoldOut_noPayment_chips() {
		// Given: a vending machine with no coins and no chips.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		fillTheMachineWithChange(vendingMachine);
		// When: press chips button
		vendingMachine.pressChipsButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplaySoldOut_partialPayment_chips() {
		// Given: a vending machine with 3 quarter coins and no chips.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press chips button
		vendingMachine.pressChipsButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is("$0.75"));
	}

	@Test
	public void testDisplaySoldOut_fullPayment_chips() {
		// Given: a vending machine with 4 quarter coins and no chips.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press chips button
		vendingMachine.pressChipsButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is("$1.00"));
	}
	@Test
	public void testDisplaySoldOut_noPayment_candy() {
		// Given: a vending machine with no coins and no candy.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		fillTheMachineWithChange(vendingMachine);
		// When: press candy button
		vendingMachine.pressCandyButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}

	@Test
	public void testDisplaySoldOut_partialPayment_candy() {
		// Given: a vending machine with 3 quarter coins and no candy.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press Cola button
		vendingMachine.pressColaButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is("$0.75"));
	}

	@Test
	public void testDisplaySoldOut_fullPayment_candy() {
		// Given: a vending machine with 4 quarter coins and no candy.
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setColaInventory(Collections.emptyList());
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));
		vendingMachine.insert(createCoin(AcceptedCoinTypes.QUARTER));

		// When: press candy button
		vendingMachine.pressCandyButton();
		// Then: sold out is displayed
		assertThat(vendingMachine.viewDisplay(), is(SOLD_OUT));
		// and: on second look display is back to default message
		assertThat(vendingMachine.viewDisplay(), is("$1.00"));
	}
}
