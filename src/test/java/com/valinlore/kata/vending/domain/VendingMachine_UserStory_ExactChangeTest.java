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
 * This one is for 'Exact Change' user story.
 * 
 * @author Tiris Valinlore
 *
 */
public class VendingMachine_UserStory_ExactChangeTest {
	private static final Object EXACT_CHANGE_ONLY = "EXACT CHANGE ONLY";

	@Test
	public void testExactChangeMessage_WithNoChange() {
		// Given: a vending machine with no change
		VendingMachine vendingMachine = new VendingMachine();
		
		// When: default state... nothing to do here

		// Then: exact change is displayed
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
		// and: on second look display is still exact change
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
	}
	@Test
	public void testExactChangeMessage_WithNotEnoughChange_case1() {
		// Given: a vending machine with 1 nickel
		VendingMachine vendingMachine = new VendingMachine();
		addChange(vendingMachine, AcceptedCoinTypes.NICKEL, 1);
		
		// When: default state... nothing to do here

		// Then: exact change is displayed
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
		// and: on second look display is still exact change
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
	}
	@Test
	public void testExactChangeMessage_WithNotEnoughChange_case2() {
		// Given: a vending machine with 1 dime and 1 nickel
		VendingMachine vendingMachine = new VendingMachine();
		addChange(vendingMachine, AcceptedCoinTypes.DIME, 1);
		addChange(vendingMachine, AcceptedCoinTypes.NICKEL, 1);
		
		// When: default state... nothing to do here

		// Then: exact change is displayed
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
		// and: on second look display is still exact change
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
	}
	@Test
	public void testExactChangeMessage_WithNotEnoughChange_case3() {
		// Given: a vending machine with 2 nickel
		VendingMachine vendingMachine = new VendingMachine();
		addChange(vendingMachine, AcceptedCoinTypes.NICKEL, 2);
		
		// When: default state... nothing to do here

		// Then: exact change is displayed
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
		// and: on second look display is still exact change
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
	}
	@Test
	public void testExactChangeMessage_WithNotEnoughChange_case4() {
		// Given: a vending machine with 3 nickel
		VendingMachine vendingMachine = new VendingMachine();
		addChange(vendingMachine, AcceptedCoinTypes.NICKEL, 3);
		
		// When: default state... nothing to do here

		// Then: exact change is displayed
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
		// and: on second look display is still exact change
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
	}

	@Test
	public void testExactChangeMessage_WithJustEnoughChange_case1() {
		// Given: a vending machine with 2 dimes and 1 nickel
		VendingMachine vendingMachine = new VendingMachine();
		addChange(vendingMachine, AcceptedCoinTypes.DIME, 2);
		addChange(vendingMachine, AcceptedCoinTypes.NICKEL, 1);
		
		// When: default state... nothing to do here

		// Then: defalut message is displayed
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
		// and: on second look display is still default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}
	@Test
	public void testExactChangeMessage_WithJustEnoughChange_case2() {
		// Given: a vending machine with 1 dimes and 2 nickel
		VendingMachine vendingMachine = new VendingMachine();
		addChange(vendingMachine, AcceptedCoinTypes.DIME, 1);
		addChange(vendingMachine, AcceptedCoinTypes.NICKEL, 2);
		
		// When: default state... nothing to do here

		// Then: default message is displayed
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
		// and: on second look display is still default message
		assertThat(vendingMachine.viewDisplay(), is(INSERT_COIN));
	}
}
