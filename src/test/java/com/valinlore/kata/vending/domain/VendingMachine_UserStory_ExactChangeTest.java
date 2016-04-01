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
	public void testDisplaySoldOut_noPayment_cola() {
		// Given: a vending machine with no coins and no change
		VendingMachine vendingMachine = new VendingMachine();
		
		// When: default state... nothing to do here

		// Then: exact change is displayed
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
		// and: on second look display is still exact change
		assertThat(vendingMachine.viewDisplay(), is(EXACT_CHANGE_ONLY));
	}
}
