package com.valinlore.kata.vending.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VendingMachine {
	static final String DEFAULT_DISPLAY = "INSERT COIN";
	private String display = DEFAULT_DISPLAY;
	private Collection<Coin> coinReturn = new ArrayList<>();
	private Collection<Coin> internalCoinBin;
	private int centsTallied;

	/**
	 * This is how you add money to the machine. If a coin is rejected it will
	 * be placed in the coinReturn for the customer to retrieve.
	 * 
	 * @param coin
	 */
	public void insert(Coin coin) {
		display = "Got coin";
		AcceptedCoinTypes determinedCoinType = CoinUtils.determineCoinType(coin);
		updateDisplay(determinedCoinType);
	}

	private void updateDisplay(AcceptedCoinTypes determinedCoinType) {
		this.centsTallied += determinedCoinType.getCents();
		this.display = String.format("$%.2f", centsTallied/100d);
	}

	/**
	 * This will be how you check what text is displaying at the current object
	 * state.
	 * 
	 * @return gaurenteed not null
	 */
	public String getDisplay() {
		return display;
	}

	public Collection<Coin> peekCoinReturn() {
		return Collections.unmodifiableCollection(coinReturn);
	}

}
