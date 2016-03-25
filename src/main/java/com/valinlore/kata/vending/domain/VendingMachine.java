package com.valinlore.kata.vending.domain;

public class VendingMachine {
	static final String DEFAULT_DISPLAY = "INSERT COIN";
	private String display = DEFAULT_DISPLAY;

	/** 
	 * This is how you add money to the machine. If a coin is rejected it will be returned from this method.
	 * @param coin Null if coin is added to the machine tally.
	 */
	public Coin insert(Coin coin) {
		return null;
	}

	/**
	 * This will be how you check what text is displaying at the current object state.
	 * @return gaurenteed not null
	 */
	public String getDisplay() {
		return display;
	}

}
