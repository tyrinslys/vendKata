package com.valinlore.kata.vending.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class VendingMachine {
	private static final String PRICE_COLA = "$1.00";
	static final String DEFAULT_DISPLAY = "INSERT COIN";
	private String display = DEFAULT_DISPLAY;
	private Collection<Coin> coinReturn = new ArrayList<>();
	private Collection<Coin> internalCoinBin = new ArrayList<>();
	private int centsTallied;
	private boolean resetDisplay;

	/**
	 * This is how you add money to the machine. If a coin is rejected it will
	 * be placed in the coinReturn for the customer to retrieve.
	 * 
	 * @param coin
	 */
	public void insert(Coin coin) {
		AcceptedCoinTypes determinedCoinType = CoinUtils.determineCoinType(coin);
		if (determinedCoinType == null) {
			coinReturn.add(coin);
		} else {
			internalCoinBin.add(coin);
			updateDisplay(determinedCoinType);
		}
	}

	private void updateDisplay(AcceptedCoinTypes determinedCoinType) {
		this.centsTallied += determinedCoinType.getCents();
		this.display = String.format("$%.2f", centsTallied / 100d);
	}

	/**
	 * This will be how you check what text is displaying at the current object
	 * state.
	 * 
	 * @return gaurenteed not null
	 */
	public String getDisplay() {
		if (resetDisplay) {
			display = DEFAULT_DISPLAY;
		}
		if (display == PRICE_COLA) {
			resetDisplay = true;
		}
		return display;
	}

	public Collection<Coin> peekCoinReturn() {
		return Collections.unmodifiableCollection(coinReturn);
	}

	public Coin takeCoinFromReturn() {
		Coin coin = null;
		if (coinReturn.size() >= 1) {
			Iterator<Coin> iterator = coinReturn.iterator();
			coin = iterator.next();
			iterator.remove();
		}
		return coin;
	}

	public void pressColaButton() {
		display = PRICE_COLA;
	}
}
