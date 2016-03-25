package com.valinlore.kata.vending.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * This test is for the kata found <a href="https://github.com/guyroyse/vending-machine-kata">here</a>.
 * @author Tiris Valinlore
 *
 */
public class VendingMachineTest {

	/**
	 * This test is for the user story titled "Accept Coins"
	 */
	@Test
	public void acceptCoins_testThatDisplayWithNoCoins() {
//		Given:
		VendingMachine vendingMachine = new VendingMachine();
//		When:
		// no coins added.
//		Then:
		assertThat(vendingMachine.getDisplay(), is(VendingMachine.DEFAULT_DISPLAY));
	}
}
