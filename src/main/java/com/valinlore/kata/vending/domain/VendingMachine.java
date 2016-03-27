package com.valinlore.kata.vending.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class VendingMachine {
	private static final int PRICE_COLA = 100;
	private static final int PRICE_CHIPS = 50;
	private static final int PRICE_CANDY = 65;
	static final String DEFAULT_DISPLAY = "INSERT COIN";
	private String display = DEFAULT_DISPLAY;
	private Collection<Coin> coinReturn = new ArrayList<>();
	private Collection<Coin> internalCoinBin = new ArrayList<>();
	private int centsTallied;
	private boolean resetDisplay;
	private boolean displaySwapped;

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
		setPriceOnDisplay(centsTallied);
	}

	/**
	 * This will be how you check what text is displaying at the current object
	 * state.
	 * 
	 * @return gaurenteed not null
	 */
	public String viewDisplay() {
		if (displaySwapped) {
			if (resetDisplay) {
				resetDisplay();
				resetDisplay = false;
				displaySwapped = false;
			}
			resetDisplay = true;
		}
		return display;
	}

	private void resetDisplay() {
		if (centsTallied > 0) {
			setPriceOnDisplay(centsTallied);
		} else {
			display = DEFAULT_DISPLAY;
		}
	}

	private void setPriceOnDisplay(int priceInCents) {
		this.display = String.format("$%.2f", priceInCents / 100d);
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
		setPriceOnDisplay(PRICE_COLA);
		this.displaySwapped = true;
	}

	public void pressCandyButton() {
		setPriceOnDisplay(PRICE_CANDY);
		this.displaySwapped = true;
	}

	public void pressChipsButton() {
		setPriceOnDisplay(PRICE_CHIPS);
		this.displaySwapped = true;
	}

	public Product takeProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
