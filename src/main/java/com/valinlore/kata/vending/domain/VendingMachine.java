package com.valinlore.kata.vending.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	private static final String SOLD_OUT = "SOLD OUT";
	private static final String MESSAGE_INSERT_COIN = "INSERT COIN";
	private static final String MESSAGE_THANK_YOU = "THANK YOU";
	private static final String MESSAGE_EXACT_CHANGE = "EXACT CHANGE ONLY";
	private String display;
	private Collection<Coin> coinReturn = new ArrayList<>(1);
	private Collection<Coin> internalCoinBin = new ArrayList<>(1);
	private Collection<Coin> coinsTalliedHolder = new ArrayList<>(1);
	private Collection<Product> productBin = new ArrayList<>(1);
	private Collection<Cola> colaInventory = new ArrayList<>(1);
	private Collection<Chips> chipsInventory = new ArrayList<>(1);
	private Collection<Candy> candyInventory = new ArrayList<>(1);
	private Map<AcceptedCoinTypes, List<Coin>> change = new HashMap<>(3);
	private int centsTallied;
	private boolean resetDisplay;
	private boolean displaySwapped;
	private boolean displayThankYouMessage;

	public VendingMachine() {
		change.put(AcceptedCoinTypes.QUARTER, new ArrayList<>(1));
		change.put(AcceptedCoinTypes.DIME, new ArrayList<>(1));
		change.put(AcceptedCoinTypes.NICKEL, new ArrayList<>(1));
		resetDisplay();
	}

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
			if (exactChangeNeeded()) {
				display = MESSAGE_EXACT_CHANGE;
			} else {
				display = MESSAGE_INSERT_COIN;
			}
		}
	}

	/**
	 * largest accepted payment is 25 cents. smallest given is 5 cents so I
	 * figure if we can despense 20 cents we should be good. Also throw in at
	 * least one nickel for good measure.
	 * 
	 * 
	 * @return
	 */
	private boolean exactChangeNeeded() {
		// check that we have one nickel
		if (!(change.get(AcceptedCoinTypes.NICKEL).size() >= 1)) {
			return true;
		}

		// check that we have 20 cents
		if (!(change.get(AcceptedCoinTypes.DIME).size() >= 2)
				&& !(change.get(AcceptedCoinTypes.NICKEL).size() >= 4)) {
			return true;
		}
		// another check that we have 20 cents
		if (!(change.get(AcceptedCoinTypes.DIME).size() >= 1
				&& change.get(AcceptedCoinTypes.NICKEL).size() >= 2)) {
			return true;
		}
		return false;
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
		attemptDespenseProduct(new Cola());
	}

	public void pressCandyButton() {
		attemptDespenseProduct(new Candy());
	}

	public void pressChipsButton() {
		attemptDespenseProduct(new Chips());
	}

	private boolean hasInventory(Product product) {
		if (product instanceof Cola) {
			return !colaInventory.isEmpty();
		} else if (product instanceof Chips) {
			return !chipsInventory.isEmpty();
		} else if (product instanceof Candy) {
			return !candyInventory.isEmpty();
		}
		return false;
	}

	private void attemptDespenseProduct(Product product) {
		if (!hasInventory(product)) {
			display = SOLD_OUT;
		} else if (centsTallied >= product.getCostOfProductInCents()) {
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

	private void returnCoins() {
		Iterator<Coin> iterator = coinsTalliedHolder.iterator();
		while (iterator.hasNext()) {
			coinReturn.add(iterator.next());
			iterator.remove();
		}
	}

	public void setColaInventory(List<Cola> colas) {
		if (colas != null) {
			colaInventory.addAll(colas);
		}
	}

	public void setChipsInventory(List<Chips> bagsOfChips) {
		if (bagsOfChips != null) {
			chipsInventory.addAll(bagsOfChips);
		}
	}

	public void setCandyInventory(List<Candy> bagsOfCandy) {
		if (bagsOfCandy != null) {
			candyInventory.addAll(bagsOfCandy);
		}
	}

	public void addChange(AcceptedCoinTypes coinType, List<Coin> coins) {
		if (coinType == null || coins == null) {
			return;
		}

		List<Coin> coinsOfSpecificType = change.get(coinType);
		coinsOfSpecificType.addAll(coins);
		resetDisplay();
	}
}