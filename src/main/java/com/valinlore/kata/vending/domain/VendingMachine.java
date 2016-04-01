package com.valinlore.kata.vending.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class VendingMachine {
	private static final String MESSAGE_INSERT_COIN = "INSERT COIN";
	private static final String MESSAGE_THANK_YOU = "THANK YOU";
	private String display = MESSAGE_INSERT_COIN;
	private Collection<Coin> coinReturn = new ArrayList<>(1);
	private Collection<Coin> internalCoinBin = new ArrayList<>(1);
	private Collection<Coin> coinsTalliedHolder = new ArrayList<>(1);
	private Collection<Product> productBin = new ArrayList<>(1);
	private int centsTallied;
	private boolean resetDisplay;
	private boolean displaySwapped;
	private boolean displayThankYouMessage;

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
			coinsTalliedHolder.add(coin);
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
		if (displaySwapped || displayThankYouMessage) {
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
			display = MESSAGE_INSERT_COIN;
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
		// Unlimited produt YAY!
		attemptDespenseProduct(new Cola());
	}

	public void pressCandyButton() {
		attemptDespenseProduct(new Candy());
	}

	public void pressChipsButton() {
		attemptDespenseProduct(new Chips());
	}

	private void attemptDespenseProduct(Product product) {
		if (centsTallied >= product.getCostOfProductInCents()) {
			centsTallied -= product.getCostOfProductInCents();
			productBin.add(product);
			makeChange();
			display = MESSAGE_THANK_YOU;
			displayThankYouMessage = true;
		} else {
			setPriceOnDisplay(product.getCostOfProductInCents());
		}
		this.displaySwapped = true;
	}

	private void makeChange() {
		while (centsTallied > 0) {
			AcceptedCoinTypes quarter = AcceptedCoinTypes.QUARTER;
			AcceptedCoinTypes dime = AcceptedCoinTypes.DIME;
			AcceptedCoinTypes nickel = AcceptedCoinTypes.NICKEL;
			// at the moment assuming infinite change Muhahaha!
			if (centsTallied >= quarter.getCents()) {
				centsTallied -= quarter.getCents();
				coinReturn.add(new Coin(quarter.getWeightInMilligrams(), quarter.getDiameterInMicroMeters()));
			} else if (centsTallied >= dime.getCents()) {
				centsTallied -= dime.getCents();
				coinReturn.add(new Coin(dime.getWeightInMilligrams(), dime.getDiameterInMicroMeters()));
			} else if (centsTallied >= nickel.getCents()) {
				centsTallied -= nickel.getCents();
				coinReturn.add(new Coin(nickel.getWeightInMilligrams(), nickel.getDiameterInMicroMeters()));
			}
		}
	}

	public Product takeProduct() {
		Product product = null;
		if (!productBin.isEmpty()) {
			Iterator<Product> iterator = productBin.iterator();
			product = iterator.next();
			iterator.remove();
		}
		return product;
	}

	public void pressCoinReturn() {
		returnCoins();
		display = MESSAGE_INSERT_COIN;
	}
	private void returnCoins(){
		Iterator<Coin> iterator = coinsTalliedHolder.iterator();
		while(iterator.hasNext()){
			coinReturn.add(iterator.next());
			iterator.remove();
		}
	}
}